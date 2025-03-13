package net.migueljb.testiumMod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.migueljb.testiumMod.item.ModArmorMaterials;
import net.migueljb.testiumMod.util.ModTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.TESTIUM_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(MobEffects.JUMP, 200, 1, false, false),
                                    new MobEffectInstance(MobEffects.GLOWING, 200, 1, false, false)))
                    .build();

    public ModArmorItem(ArmorMaterial material, ArmorType type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player && !level.isClientSide() && hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<ArmorMaterial, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn( player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Player player) {
        // Check if all armor slots contain ArmorItem instances
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        // Retrieve each armor piece using EquipmentSlot
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        // Check if all armor pieces match the specified material
        return boots.is(ModTags.Items.TESTIUM_ARMOR) && leggings.is(ModTags.Items.TESTIUM_ARMOR)
                && chestplate.is(ModTags.Items.TESTIUM_ARMOR) && helmet.is(ModTags.Items.TESTIUM_ARMOR);
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}