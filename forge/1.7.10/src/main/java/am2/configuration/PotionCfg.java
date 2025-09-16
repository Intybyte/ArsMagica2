package am2.configuration;

import am2.LogHelper;
import am2.common.configuration.AMConfig;
import net.minecraft.potion.Potion;

public class PotionCfg {
	// Gets the first available potion ID
	// returns -1 if there are no available IDs
	private static int getNextFreePotionID(){
		int freeID = -1;
		for(int i = 1; i < Potion.potionTypes.length; i++){
			if(Potion.potionTypes[i] == null){
				freeID = i;
				break;
			}
		}
		return freeID;
	}

	public static int getConfigurablePotionID(String id){
		int defaultValue = AMConfig.getInstance().getPotions().getIds().get(id);
		if(Potion.potionTypes[defaultValue] != null) {
			return defaultValue;
		}

		int val = getNextFreePotionID();

		if(val == -1) {
			LogHelper.error("Cannot find a free potion ID for the %s effect. This will cause severe problems!", id);
			LogHelper.error("Effect %s has been assigned to a default of potion ID 1 (movement speed). Erroneous behaviour *will* result.", id);
			val = 1;
		}

		return val;
	}
}
