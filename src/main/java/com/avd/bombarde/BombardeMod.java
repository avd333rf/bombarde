package com.avd.bombarde;

import com.avd.bombarde.blocks.*;
import com.avd.bombarde.items.*;
import com.avd.bombarde.sounds.*;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(BombardeMod.MODID)
public class BombardeMod
{
    public static final String MODID = "bombarde";

    private static final Logger LOGGER = LogUtils.getLogger();

    //public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public BombardeMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        //registration
        _ModSounds.register(modEventBus);
        _ModItems.register(modEventBus);
        _ModBlocks.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
//        LOGGER.info("HELLO FROM COMMON SETUP");
//        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    @SubscribeEvent
    public void onItemUseFinish(LivingEntityUseItemEvent.Finish event){
        var entity = event.getEntity();
        var item = event.getItem().getItem();
        //entity.hurt(DamageSource.CACTUS, 1000f);
        if (entity instanceof Player && item instanceof CommunismItem){

            var pos = new BlockPos(entity.getPosition(0));
            entity.getLevel().playSound((Player)entity, pos, _ModSounds.COMMUNISM_SOUND.get(), SoundSource.BLOCKS, 1f, 1f);
        }
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event)  {
        var player = event.getEntity();
        GiveItems(player);
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.@NotNull PlayerRespawnEvent event)  {
        var player = event.getEntity();
        GiveItems(player);
    }

    private void GiveItems(Player player){
        if(player == null)
            return;

        player.getInventory().add (new ItemStack(_ModItems.BOMB_ITEM.get(),1));
        player.getInventory().add (new ItemStack(_ModItems.MOLOTOV_ITEM.get(),1));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
