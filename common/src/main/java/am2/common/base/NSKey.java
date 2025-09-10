package am2.common.base;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NSKey{
	public final String namespace;
	public final String key;

	@Override
	public String toString() {
		return namespace + ":" + key;
	}
}
