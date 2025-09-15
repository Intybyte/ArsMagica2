package am2.common.configuration.sections;

import lombok.Getter;
import lombok.Setter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import static am2.common.api.math.MathUtil.clamp;

@Getter
@Setter
@ConfigSerializable
public class ConfigBeta {
	public static final String[] AURA_CONTROLLER_OPTIONS = new String[]{
			"fade",
			"float",
			"sink",
			"orbit",
			"arc",
			"flee",
			"forward",
			"pendulum",
			"grow"
	};

	@Setting(comment = "Type of aura particle")
	private int auraType = 15;

	@Setting(comment = "Behaviour of the aura")
	private int auraBehaviour = 0;

	@Setting(comment = "Alpha transparency of the aura")
	private float auraAlpha = 1.0f;

	@Setting(comment = "Scale of the aura particles")
	private float auraScale = 1.0f;

	@Setting(comment = "Color of the aura particles")
	private int auraColor = 0xFFFFFF;

	@Setting(comment = "Quantity of aura particles")
	private int auraQuantity = 1;

	@Setting(comment = "Delay between aura particle spawns")
	private int auraDelay = 5;

	@Setting(comment = "Speed of the aura particles")
	private float auraSpeed = 0.02f;

	@Setting(comment = "Whether to randomize the aura color")
	private boolean auraRandomColor = true;

	@Setting(comment = "Whether to use default aura color")
	private boolean auraDefaultColor = true;

	public void setAuraType(int auraType) {
		this.auraType = Math.min(auraType, 0); //todo icon registry hook of some sorts?
	}

	public void setAuraBehaviour(int auraBehaviour) {
		this.auraBehaviour = clamp(auraBehaviour, 0, AURA_CONTROLLER_OPTIONS.length - 1);;
	}

	public void setAuraAlpha(float auraAlpha) {
		this.auraAlpha = clamp(auraAlpha, 0f, 100f);
	}

	public void setAuraScale(float auraScale) {
		this.auraScale = clamp(auraScale, 1f, 200f);
	}

	public void setAuraQuantity(int auraQuantity) {
		this.auraQuantity = clamp(auraQuantity, 1, 5);
	}

	public void setAuraDelay(int auraDelay) {
		this.auraDelay = clamp(auraDelay, 1, 200);
	}

	public void setAuraSpeed(float auraSpeed) {
		this.auraSpeed = clamp(auraSpeed, 1f, 10f);
	}
}
