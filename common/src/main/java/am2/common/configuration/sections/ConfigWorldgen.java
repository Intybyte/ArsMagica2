package am2.common.configuration.sections;

import am2.common.configuration.datatypes.ConfigurableVein;
import lombok.Getter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@Getter
@ConfigSerializable
public class ConfigWorldgen {
	@Setting(comment = "Set this to true to enable retroactive worldgen for Ars Magica structures and ores.  *WARNING* This may break your save!  Do a backup first!  Note: This will automatically turn off after running the game once.")
	private boolean retroactiveWorldgen;

	//region Witchforest
	@Setting(comment = "The biome ID for Witchwood Forests. Change this if you run into issues with other mods that add biomes.")
	private int witchwoodForestID = 100;

	@Setting(comment = "Disable this if you experience low FPS in witchwood forests")
	private boolean witchwoodLeafParticles = true;

	@Setting(comment = "Disable this if you prefer the witchwood forest to not generate")
	private boolean enableWitchwoodForest = true;

	@Setting(comment = "Sets how rare witchwood forests are. Lower is more rare.")
	private int witchwoodForestRarity = 6;
	//endregion

	//region POIs
	@Setting(comment = "The chance of a witchwood tree generating. Lower numbers give more trees.")
	private int witchwoodFrequency = 35;

	@Setting(comment = "The chance of an etherium pool generating. Lower numbers give more pools.")
	private int poolFrequency = 25;

	@Setting(comment = "The chance of a wakebloom generating. Lower numbers give more wakeblooms, and anything less than 7 will attempt to generate in every ocean chunk.")
	private int wakebloomFrequency = 10;

	@Setting(comment = "The number of flower generation attempts made per chunk. Higher numbers give more flowers, but can slow worldgen.")
	private int flowerGenAttempts = 8;
	//endregion

	//region ores
	@Setting
	private ConfigurableVein vinteum = new ConfigurableVein(10, 45, 4, 6);

	@Setting
	private ConfigurableVein chimerite = new ConfigurableVein(10, 80, 6, 8);

	@Setting
	private ConfigurableVein topaz = new ConfigurableVein(10, 80, 6, 8);

	@Setting
	private ConfigurableVein sunstone = new ConfigurableVein(5, 120, 3, 20);
	//endregion
}
