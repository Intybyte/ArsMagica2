package am2.common.api.math;

public class MathUtil {
	public static <T extends Number & Comparable<T>> T clamp(T value, T min, T max) {
		if (value.compareTo(min) < 0) return min;
		if (value.compareTo(max) > 0) return max;

		return value;
	}
}
