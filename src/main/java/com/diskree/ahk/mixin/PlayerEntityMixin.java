package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    public void jumpInject(CallbackInfo ci) {
        if (!AchievementHardcoreMod.isAllowJump && !((PlayerEntity) (Object) this).isTouchingWater()) {
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowJump);
            ci.cancel();
        }
    }

    @Inject(method = "canPlaceOn", at = @At("HEAD"), cancellable = true)
    public void canPlaceOnInject(BlockPos pos, Direction facing, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!AchievementHardcoreMod.isAllowPlaceBlocks || !AchievementHardcoreMod.isAllowUsingWaterBucket && stack != null && stack.isOf(Items.WATER_BUCKET)) {
            cir.setReturnValue(false);
        }
    }
}
