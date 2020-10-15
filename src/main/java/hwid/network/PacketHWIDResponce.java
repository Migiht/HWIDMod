package hwid.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class PacketHWIDResponce implements IMessage {
    public int key;
    public String hwid;
    public int hash;

    public PacketHWIDResponce(String hwid, int key) {
        this.hwid = hwid;
        this.hash = hwid.hashCode();
        this.key = key;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        hwid = ByteBufUtils.readUTF8String(buf);
        hash = buf.readInt();
        key = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, hwid);
        buf.writeInt(hash);
        buf.writeInt(key);
    }
}
