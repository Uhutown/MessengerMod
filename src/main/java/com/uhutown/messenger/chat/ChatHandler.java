package com.uhutown.messenger.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;

public final class ChatHandler {

    private static final List<UUID> registerdPlayers = new ArrayList<>();
    private static final Map<UUID, List<Chat>> chats = new HashMap<>();

    public static boolean isPlayerRegisterd(final EntityPlayer player) {
        return registerdPlayers.contains(player.getUniqueID());
    }

    public static void registerNewPlayer(final EntityPlayer player) {
        final UUID uuid = player.getUniqueID();
        if (!registerdPlayers.contains(uuid))
            registerdPlayers.add(uuid);
    }

    public static List<Chat> getChatsForPlayer(final EntityPlayer player) {
        return chats.getOrDefault(player.getUniqueID(), new ArrayList<>());
    }

}
