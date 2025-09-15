package am2.common.configuration.serializers;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ClassSerializer implements TypeSerializer<Class<?>> {
	@Override
	public @Nullable Class<?> deserialize(@NonNull TypeToken<?> type, @NonNull ConfigurationNode value) throws ObjectMappingException {
		String className = value.getString();
		if (className == null) {
			return null;
		}
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new ObjectMappingException("Class not found: " + className, e);
		}
	}

	@Override
	public void serialize(@NonNull TypeToken<?> type, @Nullable Class<?> obj, @NonNull ConfigurationNode value) throws ObjectMappingException {
		if(obj == null) {
			value.setValue("");
			return;
		}

		value.setValue(obj.getName());
	}
}
