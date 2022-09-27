package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {

    @Inject(method = "moveToWorld", at = @At("HEAD"), cancellable = true)
    public void moveToWorldInject(ServerWorld destination, CallbackInfoReturnable<Entity> cir) {
        if (!AchievementHardcoreMod.isAllowMoveToNetherDimension && destination != null && destination.getRegistryKey() == World.NETHER) {
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowMoveToNetherDimension);
            cir.setReturnValue((Entity) (Object) this);
        } else if (!AchievementHardcoreMod.isAllowMoveToEnderDimension && destination != null && destination.getRegistryKey() == World.END) {
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowMoveToEnderDimension);
            cir.setReturnValue((Entity) (Object) this);
        }
    }
}
