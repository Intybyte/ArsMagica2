package am2.common.configuration;

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
import java.util.HashMap;

@ConfigSerializable
public class SkillConfiguration {
	private static HoconConfigurationLoader loader;
	private static final TypeToken<SkillConfiguration> typeToken = new TypeToken<SkillConfiguration>() {};

	@Getter
	private static SkillConfiguration instance;

	public static void init(File file) {
		TypeSerializerCollection serializerCollection = TypeSerializerCollection.create()
				.register(new TypeToken<Class<?>>() {}, new ClassSerializer());

		loader = HoconConfigurationLoader.builder()
				.setFile(file)
				.setDefaultOptions(opts -> opts.withSerializers(serializerCollection))
				.build();

		try {
			instance = new SkillConfiguration();
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
	private HashMap<String, Boolean> general = new HashMap<>();

	public boolean isSkillEnabled(String identifier){
		Boolean value = general.get(identifier);
		if (value != null)
			return value;

		general.put(identifier, true);
		return true;
	}
}
