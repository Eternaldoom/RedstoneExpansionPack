package com.eternaldoom.redstonepack.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static List<String> blocksList = new ArrayList<String>();
	
	public static void init(){
		
	}
	
	public static void registerBlock(Block b, String name){
		GameRegistry.registerBlock(b, name);
		blocksList.add(name);
	}

}