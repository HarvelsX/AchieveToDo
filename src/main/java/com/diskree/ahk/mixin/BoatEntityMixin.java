package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import com.diskree.ahk.BlockedAction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatEntity.class)
public class BoatEntityMixin {

    @Inject(method = "canAddPassenger", at = @At("HEAD"), cancellable = true)
    public void canAddPassengerInject(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        if (passenger instanceof PlayerEntity && AchievementHardcoreMod.isActionBlocked(BlockedAction.USING_BOAT)) {
            cir.setReturnValue(false);
        }
    }
}
