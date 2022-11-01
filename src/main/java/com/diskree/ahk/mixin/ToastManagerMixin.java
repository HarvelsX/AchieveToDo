package com.diskree.ahk.mixin;

import me.shedaniel.advancementsenlarger.gui.AHKAdvancementToast;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.ToastManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Deque;

@Mixin(ToastManager.class)
public class ToastManagerMixin {

    @Shadow
    @Final
    private Deque<Toast> toastQueue;

    @Inject(method = "add", at = @At("HEAD"), cancellable = true)
    public void addInject(Toast toast, CallbackInfo ci) {
        if (toast instanceof AHKAdvancementToast ahkToast) {
            for (Toast queueToast : toastQueue) {
                if (queueToast instanceof AHKAdvancementToast queueAhkToast) {
                    if (queueAhkToast.blockedAction == ahkToast.blockedAction) {
                        ci.cancel();
                    }
                }
            }
        }
    }
}
