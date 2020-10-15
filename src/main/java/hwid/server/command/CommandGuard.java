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
        return "/guard help";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length >= 1) {
            switch (args[0]) {
                case "on": {
                    String key = RandomStringUtils.randomAlphanumeric(8);
                    sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Вы включили защиту аккаунта"));
                    sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Ваш ключ : " + key + ". Сохраните его!"));
                    sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Для входа в аккаунт с другого компьютера, отключите защиту на этом"));
                    return;
                }
                case "off": {
                    if (args.length >= 2) {
                        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Защита аккаунта отключена."));
                    }
                    return;
                }
            }

        }
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "/guard on - включить защиту аккаунта."));
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "/guard off <код> - отключить защиту аккаунта."));
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "При входе с другого ПК, отключите защиту на этом."));
    }
}
