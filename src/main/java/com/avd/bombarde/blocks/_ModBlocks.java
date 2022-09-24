package com.avd.bombarde.blocks;

import com.avd.bombarde.BombardeMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class _ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BombardeMod.MODID);

//    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", ()
//            -> new Block(BlockBehaviour.Properties.of(Material.STONE)));

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
