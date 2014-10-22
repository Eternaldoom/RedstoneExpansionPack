package com.eternaldoom.redstonepack;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.eternaldoom.redstonepack.blocks.ModBlocks;
import com.eternaldoom.redstonepack.items.ModItems;
import com.eternaldoom.redstonepack.tileentity.TileEntities;

@Mod(modid = RedstoneExpansionPack.MODID, version = RedstoneExpansionPack.VERSION)
public class RedstoneExpansionPack
{
    public static final String MODID = "redstonepack";
    public static final String VERSION = "0.1";
    
    @SidedProxy(clientSide="com.eternaldoom.redstonepack.client.ClientProxy", serverSide="com.eternaldoom.redstonepack.CommonProxy")
    public static CommonProxy proxy;
    
    @Instance(MODID)
    public static RedstoneExpansionPack instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ModBlocks.init();
    	TileEntities.init();
    	ModItems.init();
    	proxy.preInit();
    	proxy.preInitClient();
    	NetworkRegistry.INSTANCE.registerGuiHandler(RedstoneExpansionPack.instance, new GUIHandler());
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init();
    	proxy.initClient();
    }
}
