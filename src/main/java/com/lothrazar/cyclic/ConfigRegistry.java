package com.lothrazar.cyclic;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.cyclic.block.anvil.TileAnvilAuto;
import com.lothrazar.cyclic.block.beaconpotion.TilePotion;
import com.lothrazar.cyclic.block.collectfluid.TileFluidCollect;
import com.lothrazar.cyclic.block.crafter.TileCrafter;
import com.lothrazar.cyclic.block.disenchant.TileDisenchant;
import com.lothrazar.cyclic.block.dropper.TileDropper;
import com.lothrazar.cyclic.block.eye.TileEye;
import com.lothrazar.cyclic.block.eyetp.TileEyeTp;
import com.lothrazar.cyclic.block.forester.TileForester;
import com.lothrazar.cyclic.block.harvester.TileHarvester;
import com.lothrazar.cyclic.block.melter.TileMelter;
import com.lothrazar.cyclic.block.miner.TileMiner;
import com.lothrazar.cyclic.block.peatfarm.TilePeatFarm;
import com.lothrazar.cyclic.block.shapebuilder.TileStructure;
import com.lothrazar.cyclic.block.solidifier.TileSolidifier;
import com.lothrazar.cyclic.block.uncrafter.TileUncraft;
import com.lothrazar.cyclic.block.user.TileUser;
import com.lothrazar.cyclic.enchant.EnchantAutoSmelt;
import com.lothrazar.cyclic.enchant.EnchantBeekeeper;
import com.lothrazar.cyclic.enchant.EnchantBeheading;
import com.lothrazar.cyclic.enchant.EnchantCurse;
import com.lothrazar.cyclic.enchant.EnchantDisarm;
import com.lothrazar.cyclic.enchant.EnchantExcavation;
import com.lothrazar.cyclic.enchant.EnchantGrowth;
import com.lothrazar.cyclic.enchant.EnchantLaunch;
import com.lothrazar.cyclic.enchant.EnchantLifeLeech;
import com.lothrazar.cyclic.enchant.EnchantMagnet;
import com.lothrazar.cyclic.enchant.EnchantMultishot;
import com.lothrazar.cyclic.enchant.EnchantPearl;
import com.lothrazar.cyclic.enchant.EnchantQuickdraw;
import com.lothrazar.cyclic.enchant.EnchantReach;
import com.lothrazar.cyclic.enchant.EnchantStep;
import com.lothrazar.cyclic.enchant.EnchantTraveller;
import com.lothrazar.cyclic.enchant.EnchantVenom;
import com.lothrazar.cyclic.enchant.EnchantXp;
import com.lothrazar.cyclic.item.TeleporterWandItem;
import com.lothrazar.cyclic.item.transporter.TileTransporterEmptyItem;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class ConfigRegistry {

  private static List<String> defaultBeheading = new ArrayList<>();
  private static List<String> defaultUnc = new ArrayList<>();
  private static List<String> defaultTransportSack = new ArrayList<>();
  private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
  private static ForgeConfigSpec COMMON_CONFIG;
  public static IntValue PEATERICHPOWER;
  public static IntValue PEATPOWER;
  public static DoubleValue PEATCHANCE;
  public static BooleanValue COMMANDNBT;
  public static BooleanValue COMMANDGETHOME;
  public static BooleanValue COMMANDHEALTH;
  public static BooleanValue COMMANDHOME;
  public static BooleanValue COMMANDHUNGER;
  public static BooleanValue COMMANDPINGNETHER;
  public static BooleanValue COMMANDWORLDSPAWN;
  public static BooleanValue COMMANDGETHELP;
  private static ConfigValue<List<String>> BEHEADING_SKINS;
  public static BooleanValue LOGINFO;
  public static IntValue HEARTXPMINUS;

  private static void buildDefaults() {
    //http://minecraft.gamepedia.com/Player.dat_format#Player_Heads
    //mhf https://twitter.com/Marc_IRL/status/542330244473311232  https://pastebin.com/5mug6EBu
    //other https://www.planetminecraft.com/blog/minecraft-playerheads-2579899/
    //NBT image data from  http://www.minecraft-heads.com/custom/heads/animals/6746-llama
    //TODO config file for extra mod support 
    defaultBeheading.add("minecraft:blaze:MHF_Blaze");
    defaultBeheading.add("minecraft:cat:MHF_Ocelot");
    defaultBeheading.add("minecraft:cave_spider:MHF_CaveSpider");
    defaultBeheading.add("minecraft:chicken:MHF_Chicken");
    defaultBeheading.add("minecraft:cow:MHF_Cow");
    defaultBeheading.add("minecraft:enderman:MHF_Enderman");
    defaultBeheading.add("minecraft:ghast:MHF_Ghast");
    defaultBeheading.add("minecraft:iron_golem:MHF_Golem");
    defaultBeheading.add("minecraft:magma_cube:MHF_LavaSlime");
    defaultBeheading.add("minecraft:mooshroom:MHF_MushroomCow");
    defaultBeheading.add("minecraft:ocelot:MHF_Ocelot");
    defaultBeheading.add("minecraft:pig:MHF_Pig");
    defaultBeheading.add("minecraft:zombie_pigman:MHF_PigZombie");
    defaultBeheading.add("minecraft:sheep:MHF_Sheep");
    defaultBeheading.add("minecraft:slime:MHF_Slime");
    defaultBeheading.add("minecraft:spider:MHF_Spider");
    defaultBeheading.add("minecraft:squid:MHF_Squid");
    defaultBeheading.add("minecraft:villager:MHF_Villager");
    defaultBeheading.add("minecraft:witch:MHF_Witch");
    defaultBeheading.add("minecraft:wolf:MHF_Wolf");
    defaultBeheading.add("minecraft:guardian:MHF_Guardian");
    defaultBeheading.add("minecraft:elder_guardian:MHF_Guardian");
    defaultBeheading.add("minecraft:snow_golem:MHF_SnowGolem");
    defaultBeheading.add("minecraft:silverfish:MHF_Silverfish");
    defaultBeheading.add("minecraft:endermite:MHF_Endermite");
    //
    // uncrafter defaults for balance
    //
    //most of these are ported direct from 1.12 defaults, idk if these mods or items exist anymore
    defaultUnc.add("minecraft:elytra");
    defaultUnc.add("minecraft:beacon");
    defaultUnc.add("minecraft:magma");//potion balance
    defaultUnc.add("minecraft:tipped_arrow");
    defaultUnc.add("minecraft:cobweb");//mods like botania add recipes
    defaultUnc.add("minecraft:*_dye");//getting flowers etc feels bad
    //    defaultUnc.add("minecraft:*_banner");
    defaultUnc.add("minecraft:stick");//block cheaty way to get bamboo
    defaultUnc.add("minecraft:netherite_ingot");
    defaultUnc.add("cyclic:gem_*");
    defaultUnc.add("forge:bucketfilled");
    defaultUnc.add("progressiveautomation:*");
    defaultUnc.add("spectrite:spectrite_arrow");
    defaultUnc.add("spectrite:spectrite_arrow_special");
    defaultUnc.add("techreborn:uumatter");
    defaultUnc.add("projecte:*");
    //
    //bag cannot pickup these. 
    defaultTransportSack.add("minecraft:spawner");
    defaultTransportSack.add("parabox:parabox");
    defaultTransportSack.add("extracells:fluidcrafter");
    defaultTransportSack.add("extracells:ecbaseblock");
    defaultTransportSack.add("extracells:fluidfiller");
  }

  static {
    buildDefaults();
    initConfig();
  }

  private static void initConfig() {
    final String WALL = "####################################################################################";
    //    final String WALLSM = "################"; //    CFG.translation(translationKey)
    CFG.comment(WALL,
        "Features with configurable properties are split into categories", WALL)
        .push(ModCyclic.MODID);
    //
    CFG.comment(WALL, " Enchantment related configs", WALL)
        .push("enchantment");
    //
    EnchantAutoSmelt.CFG = CFG.comment("Set false to disable enchantment").define(EnchantAutoSmelt.id, true);
    EnchantBeekeeper.CFG = CFG.comment("Set false to disable enchantment").define(EnchantBeekeeper.id, true);
    EnchantBeheading.CFG = CFG.comment("Set false to disable enchantment").define(EnchantBeheading.id, true);
    EnchantCurse.CFG = CFG.comment("Set false to disable enchantment").define(EnchantCurse.id, true);
    EnchantDisarm.CFG = CFG.comment("Set false to disable enchantment").define(EnchantDisarm.id, true);
    EnchantExcavation.CFG = CFG.comment("Set false to disable enchantment").define(EnchantExcavation.id, true);
    EnchantGrowth.CFG = CFG.comment("Set false to disable enchantment").define(EnchantGrowth.id, true);
    EnchantLaunch.CFG = CFG.comment("Set false to disable enchantment").define(EnchantLifeLeech.id, true);
    EnchantLifeLeech.CFG = CFG.comment("Set false to disable enchantment").define(EnchantMagnet.id, true);
    EnchantMagnet.CFG = CFG.comment("Set false to disable enchantment").define(EnchantMultishot.id, true);
    EnchantMultishot.CFG = CFG.comment("Set false to disable enchantment").define(EnchantPearl.id, true);
    EnchantPearl.CFG = CFG.comment("Set false to disable enchantment").define(EnchantQuickdraw.id, true);
    EnchantQuickdraw.CFG = CFG.comment("Set false to disable enchantment").define(EnchantReach.id, true);
    EnchantReach.CFG = CFG.comment("Set false to disable enchantment").define(EnchantStep.id, true);
    EnchantStep.CFG = CFG.comment("Set false to disable enchantment").define(EnchantStep.id, true);
    EnchantTraveller.CFG = CFG.comment("Set false to disable enchantment").define(EnchantTraveller.id, true);
    EnchantVenom.CFG = CFG.comment("Set false to disable enchantment").define(EnchantVenom.id, true);
    EnchantXp.CFG = CFG.comment("Set false to disable enchantment").define(EnchantXp.id, true);
    BEHEADING_SKINS = CFG.comment("Beheading enchant add player skin head drop, add any mob id and any skin").define("beheadingEntityMHF", defaultBeheading);
    CFG.pop();//enchantment
    //
    CFG.comment(WALL, " Edit the permissions of all commands added by the mod.  false means anyone can use, true means only OP players can use  ", WALL)
        .push("command");
    //
    COMMANDGETHOME = CFG.comment("True means only players with OP can use this /cyclic command").define("gethome", false);
    COMMANDGETHELP = CFG.comment("True means only players with OP can use this /cyclic command").define("help", false);
    COMMANDHEALTH = CFG.comment("True means only players with OP can use this /cyclic command").define("health", true);
    COMMANDHOME = CFG.comment("True means only players with OP can use this /cyclic command").define("home", true);
    COMMANDHUNGER = CFG.comment("True means only players with OP can use this /cyclic command").define("hunger", true);
    COMMANDNBT = CFG.comment("True means only players with OP can use this /cyclic command").define("nbtprint", false);
    COMMANDPINGNETHER = CFG.comment("True means only players with OP can use this /cyclic command").define("pingnether", false);
    COMMANDWORLDSPAWN = CFG.comment("True means only players with OP can use this /cyclic command").define("worldspawn", true);
    CFG.pop();//command
    //
    CFG.comment(WALL, " Logging related configs", WALL)
        .push("logging");
    //
    LOGINFO = CFG.comment("Unblock info logs; very spammy; can be useful for testing certain issues").define("info", false);
    CFG.pop();//logging 
    //
    CFG.comment(WALL, " Energy related configs for machines and items", WALL)
        .push("energy");
    //
    CFG.comment(WALL, " Fuel gained by consuming items", WALL).push("fuel");
    PEATPOWER = CFG.comment(" Power gained burning one of this")
        .defineInRange("peat_fuel", 256, 1, 64000);
    PEATERICHPOWER = CFG.comment("Power gained burning one of this")
        .defineInRange("peat_fuel_enriched", 256 * 4, 1, 64000);
    CFG.pop();//fuel
    CFG.comment(WALL, "Energy cost for various machines, either per use of an action or per tick (twenty ticks per second).", WALL)
        .push("cost");
    TileDisenchant.POWERCONF = CFG.comment("Power per use disenchanter").defineInRange("disenchanter", 1500, 0, 64000);
    TileUser.POWERCONF = CFG.comment("Power per use user").defineInRange("user", 50, 0, 64000);
    TileAnvilAuto.POWERCONF = CFG.comment("Power per repair anvil").defineInRange("anvil", 250, 0, 64000);
    TileMelter.POWERCONF = CFG.comment("Power per recipe melter").defineInRange("melter", 5000, 0, 64000);
    TileSolidifier.POWERCONF = CFG.comment("Power per recipe solidifier").defineInRange("solidifier", 5000, 0, 64000);
    TileDropper.POWERCONF = CFG.comment("Power per use dropper").defineInRange("dropper", 50, 0, 64000);
    TileForester.POWERCONF = CFG.comment("Power per use forester").defineInRange("forester", 50, 0, 64000);
    TileHarvester.POWERCONF = CFG.comment("Power per use harvester").defineInRange("harvester", 250, 0, 64000);
    TilePotion.POWERCONF = CFG.comment("Power per tick beacon").defineInRange("beacon", 10, 0, 64000);
    TileMiner.POWERCONF = CFG.comment("Power per use miner").defineInRange("miner", 10, 0, 64000);
    TileUncraft.POWERCONF = CFG.comment("Power per use uncraft").defineInRange("uncraft", 1000, 0, 64000);
    TileFluidCollect.POWERCONF = CFG.comment("Power per use collector_fluid").defineInRange("collector_fluid", 500, 0, 64000);
    TilePeatFarm.POWERCONF = CFG.comment("Power per use peat_farm").defineInRange("peat_farm", 500, 0, 64000);
    TileCrafter.POWERCONF = CFG.comment("Power per use crafter").defineInRange("crafter", 500, 0, 64000);
    TileStructure.POWERCONF = CFG.comment("Power per tick while in use").defineInRange("structure", 10, 0, 64000);
    CFG.pop();//cost
    CFG.pop();//energy
    //
    CFG.comment(WALL, " Item specific configs", WALL).push("items");
    //
    CFG.comment("Wand settings").push("teleport_wand");
    TeleporterWandItem.RANGE = CFG.comment("Maximum distance to activate").defineInRange("range", 128, 16, 256);
    CFG.pop();
    //
    CFG.comment("Sack of Holding settings").push("tile_transporter");
    TileTransporterEmptyItem.IGNORELIST = CFG.comment("Block these from being picked up")
        .define("disable_pickup", defaultTransportSack);
    CFG.pop();
    //
    CFG.comment("Peat blocks").push("peat");
    PEATCHANCE = CFG.comment("Chance that Peat Bog converts to Peat when wet (is multiplied by the number of surrounding water blocks)")
        .defineInRange("conversionChance",
            0.08000000000000F,
            0.0010000000000F, 1F);
    CFG.pop();//peat
    CFG.comment("Heart items").push("heart");
    HEARTXPMINUS = CFG.comment("Experience given when eating a poisoned heart")
        .defineInRange("experience", 500, 0, 99999);
    CFG.pop();//heart
    CFG.pop();//items
    //
    CFG.comment(WALL, " Block specific configs", WALL)
        .push("blocks");
    //
    CFG.comment("Ender Anchor settings").push("eye_teleport");
    TileEyeTp.RANGE = CFG.comment("Maximum distance to activate").defineInRange("range", 32, 2, 256);
    TileEyeTp.HUNGER = CFG.comment("Hunger cost on teleport").defineInRange("hunger", 1, 0, 20);
    TileEyeTp.EXP = CFG.comment("Exp cost on teleport").defineInRange("exp", 0, 0, 500);
    TileEyeTp.FREQUENCY = CFG.comment("Tick delay between checks, faster checks can consume server resources (1 means check every tick; 20 means only check once per second)").defineInRange("frequency", 5, 1, 20);
    CFG.pop();
    CFG.comment("Ender Trigger settings").push("eye_redstone");
    TileEye.RANGE = CFG.comment("Maximum distance to activate").defineInRange("range", 32, 2, 256);
    TileEye.FREQUENCY = CFG.comment("Tick delay between checks, faster checks can consume server resources (1 means check every tick; 20 means only check once per second)").defineInRange("frequency", 5, 1, 20);
    CFG.pop();
    //
    CFG.comment("Uncrafter settings").push("uncrafter");
    TileUncraft.IGNORE_NBT = CFG.comment("When searching for a recipe, does it ignore all NBT values (such as enchantments, RepairCost, Damage, etc).  For example, if false it will not uncraft damaged or enchanted items")
        .define("nbt_ignored", true);
    TileUncraft.IGNORELIST = CFG.comment("Block these from being un-crafted").define("ignore_list", defaultUnc);
    TileUncraft.TIMER = CFG.comment("Ticks used for each uncraft").defineInRange("ticks", 60, 1, 9999);
    CFG.pop();//uncrafter
    CFG.pop();//blocks
    //
    CFG.pop();//ROOT
    COMMON_CONFIG = CFG.build();
  }

  public static void setup(Path path) {
    final CommentedFileConfig configData = CommentedFileConfig.builder(path)
        .sync()
        .autosave()
        .writingMode(WritingMode.REPLACE)
        .build();
    configData.load();
    COMMON_CONFIG.setConfig(configData);
  }

  public static Map<String, String> getMappedBeheading() {
    Map<String, String> mappedBeheading = new HashMap<String, String>();
    for (String s : BEHEADING_SKINS.get()) {
      try {
        String[] stuff = s.split(":");
        String entity = stuff[0] + ":" + stuff[1];
        String skin = stuff[2];
        mappedBeheading.put(entity, skin);
      }
      catch (Exception e) {
        ModCyclic.LOGGER.error("Beheading Enchantment: Invalid config entry " + s);
      }
    }
    return mappedBeheading;
  }
}
