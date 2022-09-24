package com.avd.bombarde.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

public class MolotovItem extends Item {
    public MolotovItem() {
        super(new Item.Properties()
                .tab(CreativeModeTab.TAB_COMBAT)
                .stacksTo(16));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
        var pos = player.getPosition(0);
        level.explode(null, pos.x, pos.y + 1, pos.z, 10F, true, Explosion.BlockInteraction.NONE);

        return super.use(level, player, p_41434_);
    }
}
