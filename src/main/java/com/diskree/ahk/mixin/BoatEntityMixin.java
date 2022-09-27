package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
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
        if (!AchievementHardcoreMod.isAllowUsingBoat && passenger instanceof PlayerEntity) {
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowUsingBoat);
            cir.setReturnValue(false);
        }
    }
}
