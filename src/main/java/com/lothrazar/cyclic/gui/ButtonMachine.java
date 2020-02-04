package com.lothrazar.cyclic.gui;

import net.minecraftforge.fml.client.gui.widget.ExtendedButton;
import org.lwjgl.opengl.GL11;
import com.lothrazar.cyclic.registry.TextureRegistry;
import net.minecraft.client.Minecraft;

public class ButtonMachine extends ExtendedButton {

  private TextureEnum textureId;
  private String tooltip;

  public ButtonMachine(int xPos, int yPos, int width, int height, String displayString, IPressable handler) {
    super(xPos, yPos, width, height, displayString, handler);
  }

  public void setTextureId(TextureEnum id) {
    this.textureId = id;
  }

  @Override
  public void renderButton(int mouseX, int mouseY, float partial) {
    super.renderButton(mouseX, mouseY, partial);
    Minecraft minecraft = Minecraft.getInstance();
    minecraft.getTextureManager().bindTexture(TextureRegistry.WIDGETS);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, this.alpha);
    GL11.glEnable(GL11.GL_BLEND);
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    if (textureId != null) {
      this.blit(this.x, this.y,
          textureId.getX(), textureId.getY(),
          width, height);
    }
    this.renderBg(minecraft, mouseX, mouseY);
  }

  public String getTooltip() {
    return tooltip;
  }

  public void setTooltip(String tooltip) {
    this.tooltip = tooltip;
  }
}
