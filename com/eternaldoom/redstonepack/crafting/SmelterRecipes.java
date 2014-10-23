package com.eternaldoom.redstonepack.crafting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;

public class SmelterRecipes {
	
	private static Set<Recipe> recipes = new HashSet<Recipe>();
	
	public static ItemStack getOutputForIngredients(ItemStack i1, ItemStack i2, ItemStack i3){
		for(Recipe r : recipes){
			if(ItemStack.areItemsEqual(r.stack1, i1) && ItemStack.areItemsEqual(r.stack2, i2) && ItemStack.areItemsEqual(r.stack3, i3))return r.output;
		}
		return null;
	}
	
	public static void addRecipe(ItemStack i1, ItemStack i2, ItemStack i3, ItemStack output){
		Recipe recipe = new Recipe(i1, i2, i3, output);
		recipes.add(recipe);
	}
	
	public static class Recipe{
		public ItemStack stack1, stack2, stack3, output;
		public Recipe(ItemStack i1, ItemStack i2, ItemStack i3, ItemStack output){
			stack1 = i1;
			stack2 = i2;
			stack3 = i3;
			this.output = output;
		}
	}

}
