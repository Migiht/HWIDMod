package info;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import info.client.ClientInfo;
import net.minecraftforge.common.MinecraftForge;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@Mod(modid = "Info")
public class InfoMod {
    public static final Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ClientInfo());
    }
}
