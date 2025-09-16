package am2.enchantments;

import am2.LogHelper;
import am2.configuration.EnchantCfg;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

public class AMEnchantments{
	public static EnchantMagicResist magicResist = registerEnchantment(EnchantMagicResist.class, 5, "magic_resist");
	public static EnchantmentSoulbound soulbound = registerEnchantment(EnchantmentSoulbound.class, 5, "soulbound");

	public void Init(){
		Enchantment.addToBookList(magicResist);
		Enchantment.addToBookList(soulbound);

		LanguageRegistry.instance().addStringLocalization("enchantment.magicresist", "en_US", "Magic Resistance");
		LanguageRegistry.instance().addStringLocalization("enchantment.soulbound", "en_US", "Soulbound");
	}

	private static <T extends Enchantment> T registerEnchantment(Class<? extends Enchantment> enchantmentClass, int weight, String configID){
		int enchID = EnchantCfg.getConfigurableEnchantmentID(configID);
		if (enchID == -1){
			throw new ArrayIndexOutOfBoundsException("All enchantment IDs are in use...can't find a free one to take!");
		}

		try{
			T ench = (T)enchantmentClass.getConstructor(int.class, int.class).newInstance(enchID, weight);
			LogHelper.info("Successfully registered enchanment!");
			return ench;
		}catch (Throwable t){
			LogHelper.error("Failed to register enchantment %s!", configID);
			t.printStackTrace();
		}
		return null;
	}

	public static int GetEnchantmentLevelSpecial(int enchID, ItemStack stack){
		/*if (enchID == imbuedArmor.effectId || enchID == imbuedBow.effectId || enchID == imbuedWeapon.effectId){
			if (baseEnchLvl > 3)
				return (baseEnchLvl & 0x6000) >> 13;
		}*/
		return EnchantmentHelper.getEnchantmentLevel(enchID, stack);
	}
}
