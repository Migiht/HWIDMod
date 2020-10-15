package hwid;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import hwid.client.HWIDClient;
import hwid.network.PacketHWIDResponce;
import hwid.server.HWIDServer;

@Mod(modid = "HWID")
public class HWIDMod {
    public static final SimpleNetworkWrapper network = new SimpleNetworkWrapper("debil");

    @Mod.EventHandler
    public void start(FMLServerStartingEvent event) {
        HWIDServer.start(event);
    }

    @Mod.EventHandler
    public void server(FMLServerStoppingEvent event) {
        HWIDServer.stop(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        network.registerMessage(HWIDMod::receiveHWID, PacketHWIDResponce.class, 0, Side.CLIENT);
    }

    private static IMessage receiveHWID(PacketHWIDResponce hwid, MessageContext context) {
        HWIDServer.receiveHWID(hwid, context);
        return null;
    }

    private static IMessage receiveRequest(PacketHWIDResponce hwid, MessageContext context) {
        HWIDClient.receiveRequest(hwid);
        return null;
    }
}
