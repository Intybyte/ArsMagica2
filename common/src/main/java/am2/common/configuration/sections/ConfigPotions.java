package am2.common.configuration.sections;

import lombok.Getter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.HashMap;
import java.util.Map;

@Getter
@ConfigSerializable
public class ConfigPotions {

	@Setting
	private Map<String, Integer> ids = new HashMap<String, Integer>() {{
		put("agility", 40);
		put("astraldistortion", 43);
		put("burnoutredux", 55);
		put("charmed", 31);
		put("chronoanchor", 33);
		put("clarity", 53);
		put("entangled", 35);
		put("epicmanarestoration", 49);
		put("featherfall", 26);
		put("flight", 25);
		put("frostslow", 32);
		put("fury", 45);
		put("gravitywell", 51);
		put("greatermanarestoration", 48);
		put("haste", 27);
		put("illuminated", 47);
		put("leap", 41);
		put("legendarymanarestoration", 50);
		put("levitation", 52);
		put("magicshield", 30);
		put("manaboost", 42);
		put("manaregen", 34);
		put("manashield", 44);
		put("regeneration", 29);
		put("scramblesynapses", 46);
		put("shrunken", 54);
		put("silence", 38);
		put("spellreflect", 37);
		put("swiftswim", 39);
		put("truesight", 28);
		put("waterbreathing", 24);
		put("waterygrave", 36);
	}};
}
