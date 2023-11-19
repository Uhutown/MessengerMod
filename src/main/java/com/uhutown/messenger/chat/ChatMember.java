package com.uhutown.messenger.chat;

import java.util.Objects;
import java.util.UUID;

import com.uhutown.messenger.enums.PermissonLevel;

public class ChatMember {

    private final UUID uuid;
    private final PermissonLevel permisson;

    public ChatMember(final UUID uuid, final PermissonLevel permisson) {
        this.uuid = uuid;
        this.permisson = permisson;
    }

    public UUID getUUID() {
        return uuid;
    }

    public PermissonLevel getPermissonLevel() {
        return permisson;
    }

    @Override
    public int hashCode() {
        return Objects.hash(permisson, uuid);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ChatMember other = (ChatMember) obj;
        return permisson == other.permisson && Objects.equals(uuid, other.uuid);
    }

}
