package com.github.vfyjxf.nee.network;

import com.github.vfyjxf.nee.NotEnoughEnergistics;
import com.github.vfyjxf.nee.network.packet.*;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NEENetworkHandler {

    private static final SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(NotEnoughEnergistics.MODID);
    private static int packId = 0;

    public static SimpleNetworkWrapper getInstance() {
        return INSTANCE;
    }

    private static int nextID() {
        return packId++;
    }

    public static void init() {
        NEENetworkHandler.getInstance().registerMessage(PacketRecipeTransfer.class, PacketRecipeTransfer.class, nextID(), Side.SERVER);
        NEENetworkHandler.getInstance().registerMessage(PacketStackCountChange.class, PacketStackCountChange.class, nextID(), Side.SERVER);
        NEENetworkHandler.getInstance().registerMessage(PacketSlotStackChange.class, PacketSlotStackChange.class, nextID(), Side.SERVER);
        NEENetworkHandler.getInstance().registerMessage(PacketCraftingRequest.class, PacketCraftingRequest.class, nextID(), Side.SERVER);
        NEENetworkHandler.getInstance().registerMessage(PacketOpenGui.class, PacketOpenGui.class, nextID(), Side.SERVER);
        NEENetworkHandler.getInstance().registerMessage(PacketOpenCraftAmount.class, PacketOpenCraftAmount.class, nextID(), Side.SERVER);
    }

}
