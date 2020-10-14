package hwid.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HWIDServer {
    private static Config config = new Config();
    private static final File banned = new File("banned hwids.cfg");


    public static void start(FMLServerStartingEvent event) {
        try {

            config = new Gson().fromJson(FileUtils.readFileToString(banned), Config.class);
        } catch (IOException e) {
            FMLLog.bigWarning("Cannot read banned hwids");
        }
    }

    public static void stop(FMLServerStoppingEvent event) {
        try {
            FileUtils.write(banned, new GsonBuilder().setPrettyPrinting().create().toJson(config));
        } catch (IOException e) {
            FMLLog.bigWarning("Cannot save banned hwids");
        }
    }
}
