package com.eternaldoom.redstonepack.crafting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;

public class SmelterRecipes {
	
	private static Map<Set<ItemStack>, ItemStack> recipes = new HashMap<Set<ItemStack>, ItemStack>();
	
	public static ItemStack getOutputForIngredients(ItemStack i1, ItemStack i2, ItemStack i3){
		Set<ItemStack> recipe = new HashSet<ItemStack>();
		recipe.add(i1);
		recipe.add(i2);
		recipe.add(i3);
		if(recipes.containsKey(recipe)){
			return recipes.get(recipe);
		}
		return null;
	}
	
	public static void addRecipe(ItemStack i1, ItemStack i2, ItemStack i3, ItemStack output){
		HashSet<ItemStack> recipe = new HashSet<ItemStack>();
		recipe.add(i1);
		recipe.add(i2);
		recipe.add(i3);
		recipes.put(recipe, output);
	}

}
