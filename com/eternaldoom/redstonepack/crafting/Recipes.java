package com.eternaldoom.redstonepack.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.eternaldoom.redstonepack.items.ModItems;

public class Recipes {
	
	public static void init(){
		SmelterRecipes.addRecipe(new ItemStack(Blocks.glass), new ItemStack(ModItems.magnesium_dust), new ItemStack(Blocks.glass), new ItemStack(ModItems.silicon_cone));
	}

}
