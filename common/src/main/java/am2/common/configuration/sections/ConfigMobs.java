package am2.common.configuration.sections;

import lombok.Getter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class ConfigMobs {
	@Getter
	@Setting(comment = "Set this to false if you don't want dryads to despawn.")
	private boolean canDryadsDespawn = true;

	@Setting
	private int hecateSpawnRate = 2;

	@Setting
	private int mageSpawnRate = 1;

	@Setting
	private int waterElementSpawnRate = 3;

	@Setting
	private int manaElementalSpawnRate = 2;

	@Setting
	private int dryadSpawnRate = 5;

	@Setting
	private int manaCreeperSpawnRate = 3;

	@Setting
	private int darklingSpawnRate = 5;

	@Setting
	private int earthElementalSpawnRate = 2;

	@Setting
	private int fireElementalSpawnRate = 2;

	@Setting
	private int flickerSpawnRate = 4;

	public int getHecateSpawnRate() {
		return Math.max(hecateSpawnRate, 0);
	}

	public int getMageSpawnRate() {
		return Math.max(mageSpawnRate, 0);
	}

	public int getWaterElementSpawnRate() {
		return Math.max(waterElementSpawnRate, 0);
	}

	public int getManaElementalSpawnRate() {
		return Math.max(manaElementalSpawnRate, 0);
	}

	public int getDryadSpawnRate() {
		return Math.max(dryadSpawnRate, 0);
	}

	public int getManaCreeperSpawnRate() {
		return Math.max(manaCreeperSpawnRate, 0);
	}

	public int getDarklingSpawnRate() {
		return Math.max(darklingSpawnRate, 0);
	}

	public int getEarthElementalSpawnRate() {
		return Math.max(earthElementalSpawnRate, 0);
	}

	public int getFireElementalSpawnRate() {
		return Math.max(fireElementalSpawnRate, 0);
	}

	public int getFlickerSpawnRate() {
		return Math.max(flickerSpawnRate, 0);
	}
}
