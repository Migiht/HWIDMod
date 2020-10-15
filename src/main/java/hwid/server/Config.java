package hwid.server;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class Config {
    public Int2ObjectMap<String> hwidByHash = new Int2ObjectOpenHashMap<>(128);
    public Object2ObjectMap<String, String> guard = new Object2ObjectOpenHashMap<>(64);
    public Object2ObjectMap<String, String> lastKnown = new Object2ObjectOpenHashMap<>(64);
}