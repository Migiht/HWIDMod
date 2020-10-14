package hwid.server.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;

public class CommandGuard extends CommandBase {

    @Override
    public String getCommandName() {
        return "guard";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/guard on - вкл. защиту аккаунта. /guard off <код> - выкл. защиту";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length > 2) {
            switch (args[1]) {
                case "on": {
                    String key = RandomStringUtils.randomAlphanumeric(8);
                    sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Вы включили защиту аккаунта"));
                    sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Ваш ключ : " + key));
                    sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Для входа в аккаунт с другого компьютера, выключите защиту"));
                    break;
                }
                case "off": {
                    if (args.length >= 3) {

                    }
                    break;
                }
                default:
                    sender.addChatMessage(new ChatComponentText(""));
            }
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
    }
    }
}
