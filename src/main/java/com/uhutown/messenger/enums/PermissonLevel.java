package com.uhutown.messenger.enums;

public enum PermissonLevel {

    LEVEL0("watcher"), LEVEL1("member"), LEVEL2("moderator"), LEVEL3("admin"), LEVEL4("owner");

    private final String name;

    private PermissonLevel(final String name) {
        this.name = name;
    }

    public boolean isMember() {
        return this == LEVEL1 || isModerator();
    }

    public boolean isModerator() {
        return this == LEVEL2 || isAdmin();
    }

    public boolean isAdmin() {
        return this == LEVEL3 || isOwner();
    }

    public boolean isOwner() {
        return this == LEVEL4;
    }

    public String getName() {
        return name;
    }

}
