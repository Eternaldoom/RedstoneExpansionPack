package com.eternaldoom.redstonepack.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntities {
	
	public static void init(){
		GameRegistry.registerTileEntity(TileEntitySmelter.class, "RedstonePackSmelter");
	}

}
