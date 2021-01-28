package com.lothrazar.cyclic.compat.jei;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.crafter.ContainerCrafter;
import com.lothrazar.cyclic.block.melter.ContainerMelter;
import com.lothrazar.cyclic.block.melter.RecipeMelter;
import com.lothrazar.cyclic.block.melter.ScreenMelter;
import com.lothrazar.cyclic.block.solidifier.ContainerSolidifier;
import com.lothrazar.cyclic.block.solidifier.RecipeSolidifier;
import com.lothrazar.cyclic.block.solidifier.ScreenSolidifier;
import com.lothrazar.cyclic.block.workbench.ContainerWorkbench;
import com.lothrazar.cyclic.item.crafting.CraftingBagContainer;
import com.lothrazar.cyclic.item.craftingsimple.CraftingStickContainer;
import com.lothrazar.cyclic.registry.BlockRegistry;
import com.lothrazar.cyclic.registry.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;

@JeiPlugin
public class CyclicPluginJEI implements IModPlugin {

  private static final int PLAYER_INV_SIZE = 4 * 9;
  private static final ResourceLocation id = new ResourceLocation(ModCyclic.MODID, "jei");

  @Override
  public ResourceLocation getPluginUid() {
    return id;
  }

  @Override
  public void registerCategories(IRecipeCategoryRegistration registry) {
    IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
    registry.addRecipeCategories(new MelterRecipeCategory(guiHelper));
    registry.addRecipeCategories(new SolidifierRecipeCategory(guiHelper));
  }

  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    registration.addRecipeCatalyst(new ItemStack(BlockRegistry.crafter.asItem(), 1), VanillaRecipeCategoryUid.CRAFTING);
    registration.addRecipeCatalyst(new ItemStack(ItemRegistry.crafting_bag, 1), VanillaRecipeCategoryUid.CRAFTING);
    registration.addRecipeCatalyst(new ItemStack(ItemRegistry.crafting_stick, 1), VanillaRecipeCategoryUid.CRAFTING);
    registration.addRecipeCatalyst(new ItemStack(BlockRegistry.workbench.asItem(), 1), VanillaRecipeCategoryUid.CRAFTING);
    registration.addRecipeCatalyst(new ItemStack(BlockRegistry.melter.asItem(), 1), MelterRecipeCategory.ID);
    registration.addRecipeCatalyst(new ItemStack(BlockRegistry.solidifier.asItem(), 1), SolidifierRecipeCategory.ID);
  }

  @Override
  public void registerRecipes(IRecipeRegistration registry) {
    registry.addRecipes(RecipeMelter.RECIPES, MelterRecipeCategory.ID);
    registry.addRecipes(RecipeSolidifier.RECIPES, SolidifierRecipeCategory.ID);
  }

  @Override
  public void registerGuiHandlers(IGuiHandlerRegistration registry) {
    registry.addRecipeClickArea(ScreenMelter.class,
        75, 20,
        40, 26, MelterRecipeCategory.ID);
    registry.addRecipeClickArea(ScreenSolidifier.class,
        75, 20,
        40, 26, SolidifierRecipeCategory.ID);
  }

  @Override
  public void registerRecipeTransferHandlers(IRecipeTransferRegistration registry) {
    registry.addRecipeTransferHandler(ContainerMelter.class, MelterRecipeCategory.ID,
        0, 2, //recipeSLotStart, recipeSlotCount
        2, PLAYER_INV_SIZE); // inventorySlotStart, inventorySlotCount
    registry.addRecipeTransferHandler(ContainerSolidifier.class, SolidifierRecipeCategory.ID,
        0, 3, //recipeSLotStart, recipeSlotCount
        4, PLAYER_INV_SIZE); // inventorySlotStart, inventorySlotCount
    registry.addRecipeTransferHandler(ContainerCrafter.class, VanillaRecipeCategoryUid.CRAFTING,
        10, 9, //recipeSLotStart, recipeSlotCount
        30, PLAYER_INV_SIZE); // inventorySlotStart, inventorySlotCount
    registry.addRecipeTransferHandler(CraftingBagContainer.class, VanillaRecipeCategoryUid.CRAFTING,
        1, 9, //recipeSLotStart, recipeSlotCount
        10, PLAYER_INV_SIZE); // inventorySlotStart, inventorySlotCount
    registry.addRecipeTransferHandler(CraftingStickContainer.class, VanillaRecipeCategoryUid.CRAFTING,
        1, 9, //recipeSLotStart, recipeSlotCount
        10, PLAYER_INV_SIZE); // inventorySlotStart, inventorySlotCount
    registry.addRecipeTransferHandler(ContainerWorkbench.class, VanillaRecipeCategoryUid.CRAFTING,
        1, 9, //recipeSLotStart, recipeSlotCount
        10, PLAYER_INV_SIZE); // inventorySlotStart, inventorySlotCount
  }
}
