package com.uhutown.messenger.items;

import com.uhutown.messenger.MessengerModMain;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChatItem extends Item {

    public ChatItem() {
        setCreativeTab(CreativeTabs.MISC);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(final EntityPlayer player, final World worldIn,
            final BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX,
            final float hitY, final float hitZ) {
        if (!worldIn.isRemote) {
            MessengerModMain.handler.invokeGui(ChatItem.class, player, worldIn, pos, "chatitem");
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
}
