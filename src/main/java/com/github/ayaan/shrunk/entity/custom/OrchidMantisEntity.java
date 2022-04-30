package com.github.ayaan.shrunk.entity.custom;

import com.github.ayaan.shrunk.entity.ShrunkModEntityTypes;
import com.github.ayaan.shrunk.item.ShrunkModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;
import java.util.Objects;

public class OrchidMantisEntity extends Animal {

    //Saddle
    private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(OrchidMantisEntity.class, EntityDataSerializers.BOOLEAN);

    public OrchidMantisEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
         xpReward = 0;
         setNoAi(false);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0f)
                .add(Attributes.ATTACK_SPEED, 0.5f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 32D)
                .build();
    }

        protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 0.8D));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 0.9D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.7D, Ingredient.of(ShrunkModItems.EXAMPLE_ITEM.get()), false));
        }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob p_146744_) {
        return ShrunkModEntityTypes.ORCHID_MANTIS.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return Objects.equals(ShrunkModItems.EXAMPLE_ITEM.get(), stack.getItem());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SADDLED, Boolean.valueOf(false));
    }

    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        Item item = itemstack.getItem();
        if (item == ShrunkModItems.LEAF_SADDLE.get() && !this.isSaddled()) {
            if (!player.isCreative()) {
                itemstack.shrink(1);
            }
            player.playSound(SoundEvents.HORSE_SADDLE, 1f, 1f);
            this.setSaddled(true);
            return InteractionResult.SUCCESS;
        }
        InteractionResult type = super.mobInteract(player, interactionHand);
        if (type != InteractionResult.SUCCESS && !isFood(itemstack)) {
            if (!player.isShiftKeyDown() && this.isSaddled()) {
                player.startRiding(this);
                return InteractionResult.SUCCESS;
            }
        }
        return type;
    }
    public void positionRider(Entity passenger) {
        if (this.hasPassenger(passenger)) {
            float radius = -0.25F;
            float angle = (0.01745329251F * this.yBodyRot);
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            passenger.setPos(this.getX() + extraX , this.getY() + -1.8 + this.getPassengersRidingOffset() + passenger.getMyRidingOffset(), this.getZ() + extraZ);
        }
    }

    @javax.annotation.Nullable
    public Entity getControllingPassenger() {
        for (Entity passenger : this.getPassengers()) {
            if (passenger instanceof Player) {
                Player player = (Player) passenger;
                if (player.getMainHandItem().getItem() == ShrunkModItems.EXAMPLE_ITEM.get() || player.getOffhandItem().getItem() == ShrunkModItems.EXAMPLE_ITEM.get()) {
                    return player;
                }
            }
        }
        return null;
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("Saddled", this.isSaddled());
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setSaddled(compoundTag.getBoolean("Saddled"));
    }

    public boolean isSaddled() {
        return this.entityData.get(SADDLED).booleanValue();
    }

    public void setSaddled(boolean saddled) {
        this.entityData.set(SADDLED, Boolean.valueOf(saddled));
    }

    protected void dropEquipment() {
        super.dropEquipment();
        if (this.isSaddled()) {
            if (!this.level.isClientSide) {
                this.spawnAtLocation(ShrunkModItems.LEAF_SADDLE.get());
            }
        }
    }

}