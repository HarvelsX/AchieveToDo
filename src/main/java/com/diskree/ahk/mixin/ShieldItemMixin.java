package com.diskree.ahk.mixin;

import com.diskree.ahk.AchievementHardcoreMod;
import com.diskree.ahk.BlockedAction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShieldItem.class)
public class ShieldItemMixin {

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void useInject(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (AchievementHardcoreMod.isActionBlocked(BlockedAction.USING_SHIELD)) {
            cir.setReturnValue(TypedActionResult.fail(user.getStackInHand(hand)));
        }
    }
}
