package com.lothrazar.cyclic.block.breaker;

import com.lothrazar.cyclic.base.ContainerBase;
import com.lothrazar.cyclic.registry.BlockRegistry;
import com.lothrazar.cyclic.registry.ContainerScreenRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerBreaker extends ContainerBase {

  protected TileBreaker tile;

  public ContainerBreaker(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
    super(ContainerScreenRegistry.breaker, windowId);
    tile = (TileBreaker) world.getTileEntity(pos);
    this.playerEntity = player;
    this.playerInventory = playerInventory;
    layoutPlayerInventorySlots(8, 84);
    trackEnergy(tile);
    this.trackAllIntFields(tile, TileBreaker.Fields.values().length);
  }

  @Override
  public boolean canInteractWith(PlayerEntity playerIn) {
    return isWithinUsableDistance(IWorldPosCallable.of(tile.getWorld(), tile.getPos()), playerEntity, BlockRegistry.breaker);
  }
}
