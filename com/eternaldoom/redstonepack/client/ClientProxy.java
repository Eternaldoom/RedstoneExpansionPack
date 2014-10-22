package com.eternaldoom.redstonepack.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.eternaldoom.redstonepack.CommonProxy;
import com.eternaldoom.redstonepack.blocks.ModBlocks;
import com.eternaldoom.redstonepack.items.ModItems;

public class ClientProxy extends CommonProxy{

	@Override
	public void preInitClient(){
		
	}

	@Override
	public void initClient() {
		
		for(String name : ModBlocks.blocksList){
			Item i = GameRegistry.findItem("redstonepack", name);
			registerItem(i, "redstonepack:" + name);
		}
		
		for(String name : ModItems.itemsList){
			Item i = GameRegistry.findItem("redstonepack", name);
			registerItem(i, "redstonepack:" + name);
		}
	}
	
	public static void registerItem(Item item, int metadata, String itemName)
    {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(item, metadata, new ModelResourceLocation(itemName, "inventory"));
    }

    public static void registerBlock(Block block, int metadata, String blockName)
    {
        registerItem(Item.getItemFromBlock(block), metadata, blockName);
    }

    public static void registerBlock(Block block, String blockName)
    {
        registerBlock(block, 0, blockName);
    }

    public static void registerItem(Item item, String itemName)
    {
        registerItem(item, 0, itemName);
    }


}
