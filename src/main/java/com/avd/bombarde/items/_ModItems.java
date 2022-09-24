package com.avd.bombarde.items;

import com.avd.bombarde.BombardeMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class _ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BombardeMod.MODID);

    public static final RegistryObject<Item> MOLOTOV_ITEM = ITEMS.register("molotov", ()
            -> new MolotovItem());
    public static final RegistryObject<Item> BOMB_ITEM = ITEMS.register("bomb", ()
            -> new BombItem());
    public static final RegistryObject<Item> COMMUNISM_ITEM = ITEMS.register("communism", ()
            -> new CommunismItem());

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
