package am2.common.configuration.sections;

import am2.common.api.math.AMVector2;
import lombok.Getter;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@Getter
@ConfigSerializable
public class ConfigGui {
	@Setting
	private AMVector2 manaHudPosition = new AMVector2(0.7104166746139526, 0.9137254953384399);

	@Setting
	private AMVector2 burnoutHudPosition = new AMVector2(0.13333334028720856, 0.9176470637321472);

	@Setting
	private AMVector2 positiveBuffsPosition = new AMVector2(0.5145833492279053, 0.47843137383461);

	@Setting
	private AMVector2 negativeBuffsPosition = new AMVector2(0.46666666865348816, 0.47843137383461);

	@Setting
	private AMVector2 levelPosition = new AMVector2(0.49791666865348816, 0.8117647171020508);

	@Setting
	private AMVector2 affinityPosition = new AMVector2(0.9770833253860474, 0.9);

	@Setting
	private AMVector2 armorPositionChest = new AMVector2(0.004166666883975267, 0.5568627715110779);

	@Setting
	private AMVector2 armorPositionHead = new AMVector2(0.004166666883975267, 0.5176470875740051);

	@Setting
	private AMVector2 armorPositionLegs = new AMVector2(0.004166666883975267, 0.5960784554481506);

	@Setting
	private AMVector2 armorPositionBoots = new AMVector2(0.004166666883975267, 0.6352941393852234);

	@Setting
	private AMVector2 xpBarPosition = new AMVector2(0.31041666865348816, 0.7843137383460999);

	@Setting
	private AMVector2 contingencyPosition = new AMVector2(0.0020833334419876337, 0.9333333373069763);

	@Setting
	private AMVector2 manaNumericPosition = new AMVector2(0.7437499761581421, 0.8941176533699036);

	@Setting
	private AMVector2 burnoutNumericPosition = new AMVector2(0.21041665971279144, 0.9058823585510254);

	@Setting
	private AMVector2 XPNumericPosition = new AMVector2(0.47083333134651184, 0.7450980544090271);

	@Setting
	private AMVector2 SpellBookPosition = new AMVector2(0.0, 0.0);

	@Setting
	private boolean showHudMinimally = false;

	@Setting
	private boolean showArmorUI = true;

	@Setting
	private boolean showBuffs = true;

	@Setting
	private boolean showNumerics = false;

	@Setting
	private boolean showXPAlways = false;

	@Setting
	private boolean showHudBars = true;
}
