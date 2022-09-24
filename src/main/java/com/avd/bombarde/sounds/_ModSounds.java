package com.avd.bombarde.sounds;

import com.avd.bombarde.BombardeMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class _ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BombardeMod.MODID);

    public static final RegistryObject<SoundEvent> COMMUNISM_SOUND = SOUNDS.register("red_sun", ()
            -> new SoundEvent(new ResourceLocation(BombardeMod.MODID, "red_sun")));

    public static void register(IEventBus eventBus){
        SOUNDS.register(eventBus);
    }
}
