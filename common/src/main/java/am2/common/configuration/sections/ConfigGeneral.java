package am2.common.configuration.sections;

import lombok.Getter;
import lombok.Setter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ConfigSerializable
public class ConfigGeneral {

	@Setting(comment = "Set to false to prevent terrain damage from player-casted spells.")
	private boolean playerSpellsDamageTerrain = true;

	@Setting(comment = "Set to false to prevent terrain damage from NPC-casted spells.")
	private boolean npcSpellsDamageTerrain = false;

	@Setting(comment = "How much the damage in Ars Magica is scaled.")
	private float damageMultiplier = 1f;

	@Setting(comment = "Render spell effects on equipped scrolls rather than the scroll itself (only applies to the in-game one, the one on your hotbar remains unchanged)")
	private boolean useSpecialRenderers = true;

	@Setting(comment = "This will toggle mana display on and off in your inventory.  Default 'O' key in game.")
	private boolean displayManaInInventory = false;

	private boolean imbueEnchantEnabled; //todo see where this would make sense later

	@Setting(comment = "Sets how far a player may progress into secondary skill trees.")
	private int secondarySkillTreeTierCap = 99;

	@Setting
	private int mageVillagerProfessionID = 29;

	@Setting(comment = "Disable this to prevent spell effects on creative players")
	private boolean allowCreativeTargets = true;

	@Setting(comment = "Should moonstone meteors destroy terrain when landing? Keep in mind they will never land on anything other than grass.")
	private boolean moonstoneMeteorsDestroyTerrain = true;

	@Setting(comment = "Set this to true to allow AM2 to get random spell names from Seventh Sanctum, and suggest them when naming spells. An internet connection is required. Generated names may not always be family friendly.")
	private boolean suggestSpellNames = true;

	@Setting(comment = "Set this to true to have the forge component smelt villagers into emeralds. This counts as an attack and lowers your reputation.")
	private boolean forgeSmeltsVillagers = true;

	@Setting(comment = "The time taken, in ticks, for an everstone to repair after breaking.")
	private int everstoneRepairRate = 180;

	@Setting(comment = "Set this to false to have the compendium show everything, and not unlock as you go.")
	private boolean stagedCompendium = true;

	@Setting(comment = "Set this to true to have AM2 list out colours for skill points and essence types rather than showing them as a colour.")
	private boolean colourblindMode = false;

	@Setting(comment = "Set this to false to disable candles being able to act as roving lights, which improves performance.")
	private boolean candlesAreRovingLights = true;

	@Setting(comment = "If true, AM2 will automatically download compendium updates when available for your mod version.")
	private boolean allowCompendiumUpdates = true;

	@Setting(comment = "If true, AM2 will notify you via the compendium when new versions are available. It will not spam chat on login.")
	private boolean allowVersionChecks = true;

	@Setting(comment = "You must reach this magic level before Moonstone meteors will fall near you.")
	private int meteorMinSpawnLevel = 10;

	@Setting(comment = "Set this to false in order to disable gateways sending you partial distances if you don't have enough power.")
	private boolean hazardousGateways = true;

	@Setting(comment = "Alter this to change the rate at which armor XP infuses.")
	private double armorXPInfusionFactor = 1.0;

	@Setting(comment = "If false, disarm won't work on players.")
	private boolean disarmAffectsPlayers = true;

	@Setting(comment = "Sets the maximum mana a player can have (0 for no cap).")
	private double manaCap = 0.0;

	@Setting(comment = "Can the dig component break blocks that have a tile entity?")
	private boolean digBreaksTileEntities = true;

	@Setting(comment = "Set this to false if you are experiencing tick lag due to AM2 saving power data alongside the world save. Data will be cached in memory and saved later. Improves performance but has more risk.")
	private boolean savePowerDataOnWorldSave = true;

	// Affinity ability cooldown
	@Setting(comment = "Set this to the number of ticks between ender affinity teleports.")
	private int enderAffinityAbilityCooldown = 100;

	@Setting(comment = "List of block IDs that dig cannot break. Avoid listing unbreakable blocks like bedrock. Used for fine-tuning.")
	private List<String> digBlacklist = new ArrayList<>();

	@Setting(comment = "List of world names where AM2 should not generate any worldgen features. " +
			"Use world names like 'overworld', 'the_nether', 'custom_world'.")
	private List<String> worldgenBlacklist = new ArrayList<>(Arrays.asList("DIM-27", "DIM-28", "DIM-29"));

	@Setting(comment = "List of block IDs that appropriation cannot pick up")
	private List<String> appropriationBlockBlacklist = new ArrayList<>();

	@Setting(comment = "list of *fully qualified* Entity class names that appropriation cannot pick up - example, am2.entities.EntityDryad.  They are case sensitive.")
	private List<Class<?>> appropriationMobBlacklist = new ArrayList<>();

}
