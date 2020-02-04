package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.entity.EntityMagicNetEmpty;
import com.lothrazar.cyclic.entity.EntityTorchBolt;
import com.lothrazar.cyclic.item.boomerang.BoomerangEntity;
import com.lothrazar.cyclic.item.boomerang.BoomerangEntityCarry;
import com.lothrazar.cyclic.item.boomerang.BoomerangEntityDamage;
import com.lothrazar.cyclic.item.boomerang.BoomerangEntityStun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {

  @ObjectHolder(ModCyclic.MODID + ":magic_net")
  public static EntityType<EntityMagicNetEmpty> netball;
  @ObjectHolder(ModCyclic.MODID + ":torch_bolt")
  public static EntityType<EntityTorchBolt> torchbolt;
  @ObjectHolder(ModCyclic.MODID + ":boomerang_stun")
  public static EntityType<BoomerangEntity> boomerang_stun;
  @ObjectHolder(ModCyclic.MODID + ":boomerang_carry")
  public static EntityType<BoomerangEntity> boomerang_carry;
  @ObjectHolder(ModCyclic.MODID + ":boomerang_damage")
  public static EntityType<BoomerangEntity> boomerang_damage;

  @OnlyIn(Dist.CLIENT)
  @SubscribeEvent
  public static void registerModels(FMLClientSetupEvent event) {
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    //TODO: loop here
    RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.boomerang_stun, render -> new SpriteRenderer<>(render, Minecraft.getInstance().getItemRenderer()));
    RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.boomerang_carry, render -> new SpriteRenderer<>(render, Minecraft.getInstance().getItemRenderer()));
    RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.boomerang_damage, render -> new SpriteRenderer<>(render, Minecraft.getInstance().getItemRenderer()));
    RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.netball, render -> new SpriteRenderer<>(render, Minecraft.getInstance().getItemRenderer()));
    RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.torchbolt, render -> new SpriteRenderer<>(render, Minecraft.getInstance().getItemRenderer()));
  }

  @SubscribeEvent
  public static void registerEntity(RegistryEvent.Register<EntityType<?>> e) {
    IForgeRegistry<EntityType<?>> r = e.getRegistry();
    r.register(
        EntityType.Builder.<EntityMagicNetEmpty> create(EntityMagicNetEmpty::new, EntityClassification.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setUpdateInterval(1)
            .setTrackingRange(128)
            .size(.6f, .6f)
            .build("magic_net")
            .setRegistryName("magic_net"));
    r.register(
        EntityType.Builder.<EntityTorchBolt> create(EntityTorchBolt::new, EntityClassification.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setUpdateInterval(1)
            .setTrackingRange(128)
            .size(.6f, .6f)
            .build("torch_bolt")
            .setRegistryName("torch_bolt"));
    r.register(
        EntityType.Builder.<BoomerangEntityStun> create(BoomerangEntityStun::new, EntityClassification.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setUpdateInterval(1)
            .setTrackingRange(128)
            .size(.6f, .6f)
            .build("boomerang_stun")
            .setRegistryName("boomerang_stun"));
    r.register(
        EntityType.Builder.<BoomerangEntityCarry> create(BoomerangEntityCarry::new, EntityClassification.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setUpdateInterval(1)
            .setTrackingRange(128)
            .size(.6f, .6f)
            .build("boomerang_carry")
            .setRegistryName("boomerang_carry"));
    r.register(
        EntityType.Builder.<BoomerangEntityDamage> create(BoomerangEntityDamage::new, EntityClassification.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setUpdateInterval(1)
            .setTrackingRange(128)
            .size(.6f, .6f)
            .build("boomerang_damage")
            .setRegistryName("boomerang_damage"));
  }
}