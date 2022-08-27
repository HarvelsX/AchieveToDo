package com.diskriminant.ahk.mixin;

import com.diskriminant.ahk.AchievementHardcoreMod;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.village.TradeOfferList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MerchantEntity.class)
public class MerchantEntityMixin {

    @Inject(method = "getOffers", at = @At("HEAD"), cancellable = true)
    private void getOffersInject(CallbackInfoReturnable<TradeOfferList> cir) {
        if (!AchievementHardcoreMod.allowVillagerTrades) {
            cir.setReturnValue(new TradeOfferList());
        }
    }
}