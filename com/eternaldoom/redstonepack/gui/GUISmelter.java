package com.eternaldoom.redstonepack.gui;

import com.eternaldoom.redstonepack.container.ContainerSmelter;
import com.eternaldoom.redstonepack.tileentity.TileEntitySmelter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUISmelter extends GuiContainer
{
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("redstonepack:textures/gui/smelter.png");
    private final InventoryPlayer playerInv;
    private IInventory tileFurnace;

    public GUISmelter(InventoryPlayer p_i45501_1_, IInventory p_i45501_2_)
    {
        super(new ContainerSmelter(p_i45501_1_, p_i45501_2_));
        this.playerInv = p_i45501_1_;
        this.tileFurnace = p_i45501_2_;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (TileEntitySmelter.isBurning(this.tileFurnace))
        {
            i1 = this.getBurnTime(13);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
        }

        i1 = this.isBurning(24);
        this.drawTexturedModalRect(k + 112, l + 34, 176, 14, i1 + 1, 16);
    }

    private int isBurning(int p_175381_1_)
    {
        int j = this.tileFurnace.getField(2);
        int k = this.tileFurnace.getField(3);
        return k != 0 && j != 0 ? j * p_175381_1_ / k : 0;
    }

    private int getBurnTime(int p_175382_1_)
    {
        int j = this.tileFurnace.getField(1);

        if (j == 0)
        {
            j = 200;
        }

        return this.tileFurnace.getField(0) * p_175382_1_ / j;
    }
}