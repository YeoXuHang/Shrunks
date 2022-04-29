package com.github.ayaan.shrunk.entity.custom;

import com.github.ayaan.shrunk.entity.ShrunkModEntityTypes;
import com.github.ayaan.shrunk.item.ShrunkModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Objects;

public class OrchidMantisEntity extends Animal {
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

}