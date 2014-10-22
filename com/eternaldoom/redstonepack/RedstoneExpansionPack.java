package com.eternaldoom.redstonepack;

import com.eternaldoom.redstonepack.blocks.ModBlocks;
import com.eternaldoom.redstonepack.items.ModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RedstoneExpansionPack.MODID, version = RedstoneExpansionPack.VERSION)
public class RedstoneExpansionPack
{
    public static final String MODID = "redstonepack";
    public static final String VERSION = "0.1";
    
    @SidedProxy(clientSide="com.eternaldoom.redstonepack.client.ClientProxy", serverSide="com.eternaldoom.redstonepack.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ModBlocks.init();
    	ModItems.init();
    	proxy.preInit();
    	proxy.preInitClient();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init();
    	proxy.initClient();
    }
}
