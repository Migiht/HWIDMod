package hwid.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class PacketHWIDRequest implements IMessage {
    public int key;

    public PacketHWIDRequest(int key) {
        this.key = key;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        buf.writeInt(key);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        key = buf.readInt();
    }
}
