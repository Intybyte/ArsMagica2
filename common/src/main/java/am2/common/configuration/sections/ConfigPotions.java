package am2.common.configuration.sections;

import lombok.Getter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@Getter
@ConfigSerializable
public class ConfigPotions {

	@Setting
	private int agility = 40;

	@Setting
	private int astraldistortion = 43;

	@Setting
	private int burnoutredux = 55;

	@Setting
	private int charmed = 31;

	@Setting
	private int chronoanchor = 33;

	@Setting
	private int clarity = 53;

	@Setting
	private int entangled = 35;

	@Setting
	private int epicmanarestoration = 49;

	@Setting
	private int featherfall = 26;

	@Setting
	private int flight = 25;

	@Setting
	private int frostslow = 32;

	@Setting
	private int fury = 45;

	@Setting
	private int gravitywell = 51;

	@Setting
	private int greatermanarestoration = 48;

	@Setting
	private int haste = 27;

	@Setting
	private int illuminated = 47;

	@Setting
	private int leap = 41;

	@Setting
	private int legendarymanarestoration = 50;

	@Setting
	private int levitation = 52;

	@Setting
	private int magicshield = 30;

	@Setting
	private int manaboost = 42;

	@Setting
	private int manaregen = 34;

	@Setting
	private int manashield = 44;

	@Setting
	private int regeneration = 29;

	@Setting
	private int scramblesynapses = 46;

	@Setting
	private int shrunken = 54;

	@Setting
	private int silence = 38;

	@Setting
	private int spellreflect = 37;

	@Setting
	private int swiftswim = 39;

	@Setting
	private int truesight = 28;

	@Setting
	private int waterbreathing = 24;

	@Setting
	private int waterygrave = 36;
}
