package com.diskree.ahk.mixin;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.PlayerAdvancementTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAdvancementTracker.class)
public class PlayerAdvancementTrackerMixin {

    @Inject(method = "canSee", at = @At("HEAD"), cancellable = true)
    public void canSeeInject(Advancement advancement, CallbackInfoReturnable<Boolean> cir) {
        if (advancement.getId().getNamespace().equals("blazeandcave") && advancement.getId().getPath().startsWith("ahk/") && !advancement.getId().getPath().equals("ahk/root")) {
            cir.setReturnValue(true);
        }
    }
}
