package com.uhutown.messenger.proxy;

import com.uhutown.messenger.MessengerModMain;
import com.uhutown.messenger.gui.ChatGui;
import com.uhutown.messenger.items.ChatItem;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void initModEvent(final FMLPreInitializationEvent event) {
        super.initModEvent(event);
        MessengerModMain.handler.addGui(ChatItem.class, ChatGui::new);
    }

}
