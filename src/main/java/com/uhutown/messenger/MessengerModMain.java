package com.uhutown.messenger;

import org.apache.logging.log4j.Logger;

import com.uhutown.messenger.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MessengerModMain.MODID, name = MessengerModMain.NAME, version = MessengerModMain.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class MessengerModMain {

    public static final String MODID = "messengermod";
    public static final String NAME = "Messenger Mod";
    public static final String VERSION = "1.0";

    @SidedProxy(serverSide = "com.uhutown.messenger.proxy.CommonProxy", clientSide = "com.uhutown.messenger.proxy.ClientProxy")
    public static CommonProxy proxy;
    private static Logger logger;
    private static MessengerModMain instance;

    public MessengerModMain() {
        instance = this;
    }

    public static MessengerModMain getInstance() {
        return instance;
    }

    public static Logger getLogger() {
        return logger;
    }

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.initModEvent(event);
    }

    @EventHandler
    public void init(final FMLInitializationEvent event) {
        proxy.init(event);
    }
}
