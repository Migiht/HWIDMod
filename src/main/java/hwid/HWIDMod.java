package hwid;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import hwid.server.HWIDServer;

@Mod(modid = "HWID")
public class HWIDMod {


    @Mod.EventHandler
    public void start(FMLServerStartingEvent event) {
        HWIDServer.start(event);
    }

    @Mod.EventHandler
    public void server(FMLServerStoppingEvent event) {
        HWIDServer.stop(event);
    }
}
