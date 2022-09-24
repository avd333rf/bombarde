package com.avd.bombarde.mobs;

import com.avd.bombarde.BombardeMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class _ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BombardeMod.MODID);

//    public static final RegistryObject<EntityType<ComCreeper>> HOG = ENTITY_TYPES.register("com_creeper",
//            () -> EntityType.Builder.of(ComCreeper::new, MobCategory.CREATURE)
//                    .sized(1.0f, 1.0f) // Hitbox Size
//                    .build(new ResourceLocation(BombardeMod.MODID, "com_creeper").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
