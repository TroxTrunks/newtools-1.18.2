package com.newtools.items;

import com.newtools.utils.EmeraldToolMaterial;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.particle.ParticleTypes;

public class EmeraldSword extends SwordItem {

    public EmeraldSword(Settings settings) {
        super(EmeraldToolMaterial.INSTANCE, 3, -2.4F, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) attacker;
            // Check for critical hit (attacking while falling)
            if (player.fallDistance > 0.0F && !player.isOnGround()) {
                World world = attacker.getEntityWorld();
                AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(world, target.getX(), target.getY(), target.getZ());
                areaEffectCloudEntity.setRadius(3.0F);
                areaEffectCloudEntity.setDuration(600);
                areaEffectCloudEntity.setParticleType(ParticleTypes.DRAGON_BREATH);
                areaEffectCloudEntity.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));
                world.spawnEntity(areaEffectCloudEntity);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
