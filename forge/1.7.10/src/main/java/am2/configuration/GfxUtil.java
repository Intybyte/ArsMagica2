package am2.configuration;

import net.minecraft.client.Minecraft;

public class GfxUtil {
	public static int get() {
		return  2 - Minecraft.getMinecraft().gameSettings.particleSetting;
	}
}
