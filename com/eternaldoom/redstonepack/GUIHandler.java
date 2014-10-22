package com.eternaldoom.redstonepack;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.eternaldoom.redstonepack.container.ContainerSmelter;
import com.eternaldoom.redstonepack.gui.GUISmelter;
import com.eternaldoom.redstonepack.tileentity.TileEntitySmelter;

public class GUIHandler implements IGuiHandler{

	public static int guiID = 0;
    public static int smelter = guiID++;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		
		if(ID == smelter){
			return new ContainerSmelter(player.inventory, (TileEntitySmelter)entity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));

		if(ID == smelter){
			return new GUISmelter(player.inventory, (TileEntitySmelter)entity);
		}
		return null;
	}

}