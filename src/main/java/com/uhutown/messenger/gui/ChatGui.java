package com.uhutown.messenger.gui;

import com.troblecodings.guilib.ecs.ContainerBase;
import com.troblecodings.guilib.ecs.GuiBase;
import com.troblecodings.guilib.ecs.GuiInfo;

public class ChatGui extends GuiBase {

    public ChatGui(GuiInfo info) {
        super(info);
    }

    @Override
    public ContainerBase getNewGuiContainer(GuiInfo info) {
        return new ChatGuiContainer(info);
    }

}
