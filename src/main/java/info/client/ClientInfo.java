package info.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import info.InfoMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import java.util.Calendar;

public class ClientInfo {

    @SubscribeEvent
    public void tooltip(ItemTooltipEvent event) {
        NBTTagCompound tag = event.itemStack.stackTagCompound;
        if (tag != null && tag.hasKey("CTime")) {
            Calendar calendar = InfoMod.calendar;
            calendar.setTimeInMillis(tag.getLong("CTime"));

            event.toolTip.add(EnumChatFormatting.GOLD + calendar.getTime().toString());
        }
    }
}
