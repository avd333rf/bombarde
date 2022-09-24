package com.avd.bombarde.mobs;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;

public class ComCreeper extends Creeper {
    public ComCreeper(EntityType<? extends Creeper> p_32278_, Level p_32279_) {
        super(p_32278_, p_32279_);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }
}
