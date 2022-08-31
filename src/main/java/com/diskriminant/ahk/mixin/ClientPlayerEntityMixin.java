package com.diskriminant.ahk.mixin;

import com.diskriminant.ahk.AchievementHardcoreMod;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {

    @Inject(method = "isSneaking", at = @At("HEAD"), cancellable = true)
    public void isSneakingInject(CallbackInfoReturnable<Boolean> cir) {
        if (!AchievementHardcoreMod.isAllowSneak) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "setSprinting", at = @At("HEAD"), cancellable = true)
    public void setSprintingInject(boolean sprinting, CallbackInfo ci) {
        if (!AchievementHardcoreMod.isAllowSprint && !((PlayerEntity) ((Object) this)).isTouchingWater()) {
            ci.cancel();
        }
    }
}
