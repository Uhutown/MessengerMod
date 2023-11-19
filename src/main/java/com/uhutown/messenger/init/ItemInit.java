package com.uhutown.messenger.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.uhutown.messenger.MessengerModMain;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemInit {

    public static ArrayList<Item> registeredItems = new ArrayList<>();

    public static void init() {
        final Field[] fields = ItemInit.class.getFields();
        for (final Field field : fields) {
            final int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)
                    && Modifier.isPublic(modifiers)) {
                final String name = field.getName().toLowerCase().replace("_", "");
                try {
                    final Item item = (Item) field.get(null);
                    item.setRegistryName(new ResourceLocation(MessengerModMain.MODID, name));
                    item.setUnlocalizedName(name);
                    registeredItems.add(item);
                } catch (final IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
