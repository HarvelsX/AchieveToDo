package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardInput.class)
public class KeyboardInputMixin {

    @Inject(method = "tick", at = @At("RETURN"))
    public void tickInject(boolean slowDown, float f, CallbackInfo ci) {
        if (!AchievementHardcoreMod.isAllowSneak && ((Input) ((Object) this)).sneaking) {
            ((Input) ((Object) this)).sneaking = false;
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowSneak);
        }
    }
}
