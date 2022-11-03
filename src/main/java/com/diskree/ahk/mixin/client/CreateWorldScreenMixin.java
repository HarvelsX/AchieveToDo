package com.diskree.ahk.mixin.client;

import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {

    @Shadow private CyclingButtonWidget<CreateWorldScreen.Mode> gameModeSwitchButton;

    @Shadow private CreateWorldScreen.Mode currentMode;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void setDefaultHardcore(CallbackInfo ci) {
        currentMode = CreateWorldScreen.Mode.HARDCORE;
    }

    @Inject(method = {"init", "setMoreOptionsOpen(Z)V"}, at = @At("TAIL"))
	private void disableGameModSwitching(CallbackInfo ci) {
		gameModeSwitchButton.active = false;
	}

}
