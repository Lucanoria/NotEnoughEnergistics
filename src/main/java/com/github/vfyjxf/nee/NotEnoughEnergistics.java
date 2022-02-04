package com.github.vfyjxf.nee;

import com.github.vfyjxf.nee.network.NEEGuiHandler;
import com.github.vfyjxf.nee.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = NotEnoughEnergistics.MODID,
        version = NotEnoughEnergistics.VERSION,
        name = NotEnoughEnergistics.NAME,
        dependencies = NotEnoughEnergistics.DEPENDENCIES,
        guiFactory = NotEnoughEnergistics.GUI_FACTORY,
        useMetadata = true)
public class NotEnoughEnergistics {
    public static final String MODID = "neenergistics";
    public static final String NAME = "NotEnoughEnergistics";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDENCIES = "required-after:jei;required-after:appliedenergistics2";
    public static final String GUI_FACTORY = "com.github.vfyjxf.nee.config.NEEConfigGuiFactory";
    public static final Logger logger = LogManager.getLogger("NotEnoughEnergistics");

    @Mod.Instance(MODID)
    public static NotEnoughEnergistics instance;

    @SidedProxy(clientSide = "com.github.vfyjxf.nee.proxy.ClientProxy", serverSide = "com.github.vfyjxf.nee.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new NEEGuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }


}
