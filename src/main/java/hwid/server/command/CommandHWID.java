package hwid.server.command;

import hwid.client.HWIDClient;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandHWID extends CommandBase {
    @Override
    public String getCommandName() {
        return "hwid";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "hwid help";
    }

    @Override
    public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {
        p_71515_1_.addChatMessage(new ChatComponentText(HWIDClient.getHWID()));
    }
}
