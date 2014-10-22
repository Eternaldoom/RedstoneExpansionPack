package com.eternaldoom.redstonepack.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static List<String> itemsList = new ArrayList<String>();
	
	public static BaseItem magnesium_ingot, magnesium_dust;
	public static BaseItem silicon_cone;
	
	public static void init(){
		
		magnesium_ingot = new BaseItem("ingotMagnesium").register("magnesium_ingot");
		magnesium_dust = new BaseItem("dustMagnesium").register("magnesium_dust");
		silicon_cone = new BaseItem("coneSilicon").register("silicon_cone");
		
	}
	
	public static void registerItem(Item i, String name){
		GameRegistry.registerItem(i, name);
		itemsList.add(name);
	}
}
