package am2.configuration;

import am2.LogHelper;
import am2.common.configuration.AMConfig;
import am2.common.configuration.sections.ConfigEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.potion.Potion;

public class EnchantCfg {
	// Gets the first available potion ID
	// returns -1 if there are no available IDs
	private static int getNextFreeEnchantmentID(){
		int freeID = -1;
		for(int i = 1; i < Enchantment.enchantmentsList.length; i++){
			if(Enchantment.enchantmentsList[i] == null){
				freeID = i;
				break;
			}
		}

		return freeID;
	}

	//return -1 on failure
	public static int getConfigurableEnchantmentID(String enchantmentName){
		ConfigEnchantments ench = AMConfig.getInstance().getEnchantments();
		int defaultValue = ench.getIds().get(enchantmentName);
		if(Potion.potionTypes[defaultValue] != null) {
			LogHelper.info("Found place for enchant!");
			return defaultValue;
		}

		int val = getNextFreeEnchantmentID();

		if(val == -1) {
			LogHelper.error("All enchantment IDs are in use...can't find a free one to take!", enchantmentName);
			return -1;
		}

		LogHelper.info("Found place for enchant after search, and updating config!");
		ench.getIds().put(enchantmentName, val);
		AMConfig.save();
		return val;
	}
}
