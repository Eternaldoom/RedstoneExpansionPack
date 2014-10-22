package com.eternaldoom.redstonepack;

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
