package com.avd.bombarde.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

public class BombItem extends Item {
    public BombItem() {
        super(new Item.Properties()
                .tab(CreativeModeTab.TAB_COMBAT)
                .stacksTo(16));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
        player.getInventory().add (new ItemStack(_ModItems.COMMUNISM_ITEM.get(),16));

        var pos = player.getPosition(0);
        level.explode(null, pos.x, pos.y + 2d, pos.z, 10F, false, Explosion.BlockInteraction.BREAK);

        return InteractionResultHolder.consume(player.getItemInHand(p_41434_));
    }

}
