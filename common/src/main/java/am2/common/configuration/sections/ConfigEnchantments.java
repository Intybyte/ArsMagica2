package am2.common.configuration.sections;

import lombok.Getter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.HashMap;

@Getter
@ConfigSerializable
public class ConfigEnchantments {

	@Setting
	private HashMap<String, Integer> ids = new HashMap<String, Integer>() {{
		put("magic_resist", 100);
		put("soulbound", 101);
	}};
}
