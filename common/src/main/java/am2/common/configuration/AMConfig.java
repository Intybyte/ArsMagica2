package am2.common.configuration;

import am2.common.configuration.sections.*;
import am2.common.configuration.serializers.ClassSerializer;
import com.google.common.reflect.TypeToken;
import lombok.Getter;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializerCollection;

import java.io.File;
import java.io.IOException;

@Getter
@ConfigSerializable
public class AMConfig {
	private static HoconConfigurationLoader loader;
	private static final TypeToken<AMConfig> typeToken = new TypeToken<AMConfig>() {};

	@Getter
	private static AMConfig instance;

	public static void init(File file) {
		TypeSerializerCollection serializerCollection = TypeSerializerCollection.create()
				.register(new TypeToken<Class<?>>() {}, new ClassSerializer());

		loader = HoconConfigurationLoader.builder()
				.setFile(file)
				.setDefaultOptions(opts -> opts.withSerializers(serializerCollection))
				.build();

		try {
			instance = new AMConfig();
			ConfigurationNode root;

			if (!file.exists()) {
				root = loader.createEmptyNode();
				root.setValue(typeToken, instance);
				loader.save(root);
			}

			root = loader.load();
			root.mergeValuesFrom(loader.createEmptyNode().setValue(typeToken, instance));

			instance = root.getValue(typeToken);
			loader.save(root);

		} catch(IOException | ObjectMappingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void save() {
		try {
			ConfigurationNode root = loader.load();

			root.setValue(typeToken, instance);

			loader.save(root);
		} catch (ObjectMappingException | IOException e) {
			throw new RuntimeException("Failed to save AMConfig", e);
		}
	}

	@Setting
	private ConfigGeneral general = new ConfigGeneral();

	@Setting(comment = "This applies to those who have beta auras unlocked only")
	private ConfigBeta beta = new ConfigBeta();

	@Setting(comment = "Allows control over various enchantments in the mod.")
	private ConfigEnchantments enchantments = new ConfigEnchantments();

	@Setting
	private ConfigGui gui = new ConfigGui();

	@Setting
	private ConfigPotions potions = new ConfigPotions();

	@Setting
	private ConfigWorldgen worldgen = new ConfigWorldgen();

	@Setting(comment = "Spawn control for different AM mobs.")
	private ConfigMobs mobs = new ConfigMobs();
}
