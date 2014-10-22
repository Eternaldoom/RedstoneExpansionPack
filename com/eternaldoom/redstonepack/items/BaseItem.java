package com.eternaldoom.redstonepack.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaseItem extends Item{
	public BaseItem(String name){
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabs.tabBlock);//TODO: change this when forge comes out
	}
	
	public BaseItem register(String name){
		ModItems.registerItem(this, name);
		return this;
	}
}
