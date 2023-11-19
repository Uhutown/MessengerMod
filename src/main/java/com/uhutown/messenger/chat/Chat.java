package com.uhutown.messenger.chat;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.uhutown.messenger.enums.ChangedState;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldServer;

public class Chat {

    private final List<ChatMember> member = new ArrayList<>();
    private final List<Message> messages = new ArrayList<>();
    private final WorldServer world;

    public Chat(final WorldServer world, final ChatMember... players) {
        for (final ChatMember player : players) {
            this.member.add(player);
        }
        this.world = world;
    }

    public void addMember(final ChatMember member) {

    }

    public boolean removePlayer(final ChatMember member) {
        // TODO apply ChatSettings
        if (!member.getPermissonLevel().isAdmin())
            return false;
        updateOnClient(null, ChangedState.ADDED_MEMBER, member);
        return true;
    }

    public boolean clearMessages(final ChatMember deleter) {
        // TODO apply ChatSettings
        if (!deleter.getPermissonLevel().isAdmin())
            return false;
        messages.clear();
        updateOnClient(null, ChangedState.DELETED_ALL_MESSAGES);
        return true;
    }

    public boolean addMessage(final ChatMember sender, final Message message) {
        // TODO apply ChatSettings
        if (!sender.getPermissonLevel().isMember())
            return false;
        messages.add(message);
        updateOnClient(message, ChangedState.SEND_MESSAGE);
        return true;
    }

    public boolean deleteMessage(final ChatMember deleter, final Message message) {
        // TODO apply ChatSettings
        if (!deleter.equals(message.getSender()) && !deleter.getPermissonLevel().isModerator())
            return false;
        messages.remove(message);
        updateOnClient(message, ChangedState.DELETE_MESSAGE);
        return true;
    }

    private void updateOnClient(final @Nullable Message message, final ChangedState state) {
        updateOnClient(message, state, null);
    }

    private void updateOnClient(final @Nullable Message message, final ChangedState state,
            final @Nullable ChatMember member) {
        this.member.forEach(user -> {
            final EntityPlayer player = world.getPlayerEntityByUUID(user.getUUID());
            if (player == null)
                return;
            // TODO networking
        });
    }
}
