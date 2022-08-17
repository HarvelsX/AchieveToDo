package com.diskriminant.ahk.mixin;

import com.diskriminant.ahk.ExampleMod;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScoreboardPlayerScore.class)
public class ScoreboardMixin {

    @Shadow @Final @Nullable private ScoreboardObjective objective;

    @Inject(method = "setScore", at = @At("HEAD"))
    public void setScoreInject(int score, CallbackInfo ci) {
        if (this.objective != null && this.objective.getName().equals("bac_advancements")) {
            ExampleMod.allowEnchantingTable = score > 20;
            ExampleMod.allowVillagerTrades = score > 9;
            ExampleMod.allowTotemDrop = score > 23;
        }
    }
}
