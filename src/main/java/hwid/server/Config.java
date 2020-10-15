package hwid.server;

import com.mojang.realmsclient.util.Pair;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Map;

public class Config {
    public Object2ObjectMap<String, ImmutablePair<String, String>> guard = new Object2ObjectOpenHashMap<>(64);
    public Object2ObjectMap<String, String> lastKnown = new Object2ObjectOpenHashMap<>(64);
}