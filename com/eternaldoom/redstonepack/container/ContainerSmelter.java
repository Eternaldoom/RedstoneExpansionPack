package com.eternaldoom.redstonepack.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerSmelter extends Container
{
    private final IInventory tileFurnace;
    private int field_178152_f;
    private int field_178153_g;
    private int burntime;
    private int currentitemburntime;

    public ContainerSmelter(InventoryPlayer playerinv, IInventory furnaceInventory)
    {
        this.tileFurnace = furnaceInventory;
        this.addSlotToContainer(new Slot(furnaceInventory, 0, 22, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(furnaceInventory, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(playerinv.player, furnaceInventory, 2, 149, 35));
        this.addSlotToContainer(new Slot(furnaceInventory, 3, 56, 17));
        this.addSlotToContainer(new Slot(furnaceInventory, 4, 90, 17));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerinv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(playerinv, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting listener)
    {
        super.addCraftingToCrafters(listener);
        listener.func_175173_a(this, this.tileFurnace);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.field_178152_f != this.tileFurnace.getField(2))
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tileFurnace.getField(2));
            }

            if (this.burntime != this.tileFurnace.getField(0))
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
            }

            if (this.currentitemburntime != this.tileFurnace.getField(1))
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tileFurnace.getField(1));
            }

            if (this.field_178153_g != this.tileFurnace.getField(3))
            {
                icrafting.sendProgressBarUpdate(this, 3, this.tileFurnace.getField(3));
            }
        }

        this.field_178152_f = this.tileFurnace.getField(2);
        this.burntime = this.tileFurnace.getField(0);
        this.currentitemburntime = this.tileFurnace.getField(1);
        this.field_178153_g = this.tileFurnace.getField(3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tileFurnace.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.tileFurnace.isUseableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 5, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0 && index != 3 && index != 4)
            {
                if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (index >= 5 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 5, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 5, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }
}