package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ConfigManager;
import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.enchant.EnchantBeheading;
import com.lothrazar.cyclic.enchant.EnchantExcavation;
import com.lothrazar.cyclic.enchant.EnchantLaunch;
import com.lothrazar.cyclic.enchant.EnchantLifeLeech;
import com.lothrazar.cyclic.enchant.EnchantMagnet;
import com.lothrazar.cyclic.enchant.EnchantMultishot;
import com.lothrazar.cyclic.enchant.EnchantQuickdraw;
import com.lothrazar.cyclic.enchant.EnchantReach;
import com.lothrazar.cyclic.enchant.EnchantStep;
import com.lothrazar.cyclic.enchant.EnchantVenom;
import com.lothrazar.cyclic.enchant.EnchantXp;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnchantRegistry {

  @ObjectHolder(ModCyclic.MODID + ":excavate")
  public static EnchantExcavation excavate;
  @ObjectHolder(ModCyclic.MODID + ":experience_boost")
  public static EnchantXp experience_boost;
  @ObjectHolder(ModCyclic.MODID + ":life_leech")
  public static EnchantLifeLeech life_leech;
  @ObjectHolder(ModCyclic.MODID + ":launch")
  public static Enchantment launch;
  @ObjectHolder(ModCyclic.MODID + ":magnet")
  public static EnchantMagnet magnet;
  @ObjectHolder(ModCyclic.MODID + ":multishot")
  public static EnchantMultishot multishot;
  @ObjectHolder(ModCyclic.MODID + ":quickshot")
  public static Enchantment quickshot;
  @ObjectHolder(ModCyclic.MODID + ":reach")
  public static EnchantReach reach;
  @ObjectHolder(ModCyclic.MODID + ":venom")
  public static EnchantVenom venom;

  @SubscribeEvent
  public static void onEnchantRegister(final RegistryEvent.Register<Enchantment> event) {
    IForgeRegistry<Enchantment> r = event.getRegistry();
    if (ConfigManager.ENCHANTMENTS.get()) {
      r.register(new EnchantBeheading(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND).setRegistryName("beheading"));
      r.register(new EnchantExcavation(Enchantment.Rarity.RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND).setRegistryName("excavate"));
      r.register(new EnchantXp(Enchantment.Rarity.RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND).setRegistryName("experience_boost"));
      r.register(new EnchantLaunch(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_FEET, EquipmentSlotType.FEET).setRegistryName("launch"));
      r.register(new EnchantLifeLeech(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND).setRegistryName("life_leech"));
      r.register(new EnchantMagnet(Enchantment.Rarity.RARE, EnchantmentType.ALL, EquipmentSlotType.MAINHAND).setRegistryName("magnet"));
      r.register(new EnchantMultishot(Enchantment.Rarity.RARE, EnchantmentType.BOW, EquipmentSlotType.MAINHAND).setRegistryName("multishot"));
      r.register(new EnchantQuickdraw(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND).setRegistryName("quickshot"));
      r.register(new EnchantReach(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_CHEST, EquipmentSlotType.CHEST).setRegistryName("reach"));
      r.register(new EnchantVenom(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND).setRegistryName("venom"));
      r.register(new EnchantStep(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_LEGS, EquipmentSlotType.MAINHAND).setRegistryName("step"));
      // HarvestDropsEvent broken in 1.15 
      // r.register(new EnchantAutoSmelt(Enchantment.Rarity.RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND).setRegistryName("smelting"));
    }
  }
}