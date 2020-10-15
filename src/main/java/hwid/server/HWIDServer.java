package hwid.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import hwid.HWIDMod;
import hwid.network.PacketHWIDResponce;
import hwid.network.PacketHWIDRequest;
import hwid.server.command.CommandGuard;
import hwid.server.command.CommandHWID;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class HWIDServer {
    private static Config config = new Config();
    private static final File banned = new File("banned hw.cfg");
    private static final File lastKnown = new File("lastKnown.cfg");
    private static final Int2IntMap keys = new Int2IntOpenHashMap(64);

    public static void start(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandGuard());
        event.registerServerCommand(new CommandHWID());
        try {
            config = new Gson().fromJson(FileUtils.readFileToString(banned), Config.class);
        } catch (IOException e) {
            FMLLog.bigWarning("Cannot read banned hw");
        }
    }

    public static void stop(FMLServerStoppingEvent event) {
        try {
            FileUtils.write(banned, new GsonBuilder().setPrettyPrinting().create().toJson(config));
        } catch (IOException e) {
            FMLLog.bigWarning("Cannot save banned hw");
        }
    }

    public static void requestHWID(String name) {
        EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().func_152612_a(name);
        if (player != null) {
            int key = player.getRNG().nextInt();
            keys.put(player.getEntityId(), key);
            HWIDMod.network.sendTo(new PacketHWIDRequest(key), player);
        }
    }

    public static void receiveHWID(PacketHWIDResponce hwid, MessageContext context) {
        int key = keys.remove(context.getServerHandler().playerEntity.getEntityId());
        if (key == hwid.key && key != keys.defaultReturnValue()) {

        }
    }
}
