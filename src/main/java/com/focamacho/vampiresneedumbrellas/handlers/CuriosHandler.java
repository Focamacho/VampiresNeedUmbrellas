package com.focamacho.vampiresneedumbrellas.handlers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.CuriosAPI;
import top.theillusivec4.curios.api.imc.CurioIMCMessage;

public class CuriosHandler {
    public static void registerUmbrellaCurios() {
        InterModComms.sendTo("curios", "register_type", () -> (new CurioIMCMessage("umbrella")).setSize(1).setEnabled(true).setHidden(false));
        InterModComms.sendTo("curios", "register_icon", () -> new Tuple("umbrella", new ResourceLocation("vampiresneedumbrellas", "textures/curios.png")));
    }

    public static boolean isUmbrellaEquipped(ItemStack umbrella, PlayerEntity player) {
        return CuriosAPI.getCurioEquipped(umbrella.getItem(), (LivingEntity)player).isPresent();
    }
}