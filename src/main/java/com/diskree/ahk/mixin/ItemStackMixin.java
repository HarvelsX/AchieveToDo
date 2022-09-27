package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void useOnBlockInject(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (!AchievementHardcoreMod.isAllowPlaceBlocks) {
            AchievementHardcoreMod.showPreventUsage(AchievementHardcoreMod.countForAllowPlaceBlocks);
            cir.setReturnValue(ActionResult.PASS);
        }
    }
}
