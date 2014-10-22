package com.eternaldoom.redstonepack.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static List<String> blocksList = new ArrayList<String>();
	
	public static BaseBlock magnesium_ore;
	public static BlockSmelter smelter;
	public static BlockSmelter smelter_on;
	
	public static void init(){
		magnesium_ore = new BaseBlock(Material.rock, "oreMagnesium", 6.5f, 10f, Block.soundTypePiston).register("magnesium_ore");
		smelter = new BlockSmelter(false).register("smelter");
		smelter_on = new BlockSmelter(true).register("smelter_on");
	}
	
	public static void registerBlock(Block b, String name){
		GameRegistry.registerBlock(b, name);
		blocksList.add(name);
	}

}