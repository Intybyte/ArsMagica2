package am2.common.configuration.datatypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ConfigSerializable
public class ConfigurableIdentifier {
	@Setting
	private int id;

}
