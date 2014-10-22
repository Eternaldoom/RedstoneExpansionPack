package com.eternaldoom.redstonepack.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BaseBlock extends Block{

	public BaseBlock(Material mat, String name, float hardness, float resistance, SoundType sound) {
		super(mat);
		setUnlocalizedName(name);
		setStepSound(sound);
		setHardness(hardness);
		setResistance(resistance);
		setCreativeTab(CreativeTabs.tabBlock);//TODO: change when forge comes out
	}
	
	public BaseBlock register(String name){
		GameRegistry.registerBlock(this, name);
		return this;
	}

}
