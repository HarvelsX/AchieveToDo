package com.diskree.ahk.mixin;

import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.resource.DataPackSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {

    @Shadow
    public boolean hardcore;

    @Shadow protected DataPackSettings dataPackSettings;

    @Inject(method = "createLevel", at = @At("HEAD"))
    public void applyDataPacksInject(CallbackInfo ci) {
        if (hardcore) {
            List<String> enabled = new ArrayList<>(dataPackSettings.getEnabled());
            enabled.add("globalOpt:BACAP_HC.zip");
            dataPackSettings = new DataPackSettings(enabled, new ArrayList<>());
        }
    }
}
