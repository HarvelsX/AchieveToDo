package com.diskriminant.ahk.mixin;

import com.diskriminant.ahk.AchievementHardcoreMod;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BrewingStandBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingStandBlock.class)
public class BrewingStandBlockMixin {

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    public void onUseInject(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (!AchievementHardcoreMod.isAllowUsingBrewingStand) {
            cir.setReturnValue(ActionResult.FAIL);
        }
    }
}