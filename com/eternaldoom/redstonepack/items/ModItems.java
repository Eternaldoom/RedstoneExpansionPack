package com.eternaldoom.redstonepack.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static List<String> itemsList = new ArrayList<String>();
	
	public static void init(){
		
	}
	
	public static void registerItem(Item i, String name){
		GameRegistry.registerItem(i, name);
		itemsList.add(name);
	}
}
