package com.uhutown.messenger.proxy;

import java.util.Map;

import com.troblecodings.core.UIInit;
import com.troblecodings.core.net.NetworkHandler;
import com.troblecodings.guilib.ecs.GuiHandler;
import com.uhutown.messenger.MessengerModMain;
import com.uhutown.messenger.init.ItemInit;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void initModEvent(final FMLPreInitializationEvent event) {
        final Map.Entry<GuiHandler, NetworkHandler> init = UIInit.initCommon(MessengerModMain.MODID,
                MessengerModMain.getLogger(), MessengerModMain.isDebug());
        MessengerModMain.handler = init.getKey();
        MessengerModMain.network = init.getValue();

        ItemInit.init();
    }

    public void init(final FMLInitializationEvent event) {

    }

}