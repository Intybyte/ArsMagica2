package am2.common.configuration.sections;

import am2.common.configuration.datatypes.ConfigurableIdentifier;
import lombok.Getter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@Getter
@ConfigSerializable
public class ConfigEnchantments {

	@Setting
	private ConfigurableIdentifier magic_resist = new ConfigurableIdentifier(100);

	@Setting
	private ConfigurableIdentifier soulbound = new ConfigurableIdentifier(101);

}
