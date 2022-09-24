package com.avd.bombarde.items;

import net.minecraft.world.effect.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public class CommunismItem extends Item {
    public CommunismItem() {
        super(new Item.Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food((new FoodProperties.Builder()).nutrition(-100).meat().saturationMod(-0.5f).effect(new Supplier<MobEffectInstance>() {
                    @Override
                    public MobEffectInstance get() {
                        return new MobEffectInstance(MobEffects.WITHER, 999999, 10);
                    }
                }, 1f).build())
                .stacksTo(16));
    }
}
