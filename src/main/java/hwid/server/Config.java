package hwid.server;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class Config {
    private static final Int2ObjectMap<String> hwidByHash = new Int2ObjectOpenHashMap<>(128);

}
