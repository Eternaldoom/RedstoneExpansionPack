package com.eternaldoom.redstonepack.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class RedstoneUtils {
	
	private static BlockPos origin = BlockPos.ORIGIN;
	
	private String[][] toolPatterns = {{"XX ", "XS ", " S "}, {"XXX", " S ", " S "}, {"X", "X", "S"}, {"X", "S", "S"}};
	
	public static void setBlock(World w, int x, int y, int z, Block b){
		w.setBlockState(origin.add(x, y, z), b.getDefaultState());
	}
	
	public static void setBlock(World w, int x, int y, int z, Block b, int meta, int flag){
		w.setBlockState(origin.add(x, y, z), b.getStateFromMeta(meta), flag);
	}
	
	public static IBlockState getBlock(World w, int x, int y, int z){
		return w.getBlockState(origin.add(x, y, z));
	}
	
}
