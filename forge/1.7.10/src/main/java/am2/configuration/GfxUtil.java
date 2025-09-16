package am2.configuration;

import net.minecraft.client.Minecraft;

public class GfxUtil {
	public static int get() {
		return 2 - Minecraft.getMinecraft().gameSettings.particleSetting;
	}

	public static boolean isFull(){
		return get() == 2;
	}

	public static boolean isLow(){
		return get() == 1;
	}

	public static boolean isNo(){
		return get() == 0;
	}
}
