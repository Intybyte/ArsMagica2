package am2.common.configuration.datatypes;

import lombok.*;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ConfigSerializable
public class ConfigurableVein {
	@Setting(comment = "The minimum height for the ore to generate.")
	private int minHeight;

	@Setting(comment = "The maximum height for the ore to generate.")
	private int maxHeight;

	@Setting(comment = "The number of blocks in a vein of ore.")
	private int veinSize;

	@Setting(comment = "The number of ore veins generated per chunk.")
	private int frequency;
}
