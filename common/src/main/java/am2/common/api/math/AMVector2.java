package am2.common.api.math;

import lombok.NoArgsConstructor;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@NoArgsConstructor
@ConfigSerializable
public class AMVector2{
	@Setting
	public double x;

	@Setting
	public double y;

	public transient int iX;
	public transient int iY;

	public AMVector2(double x, double y){
		this.x = x;
		this.y = y;
		this.iX = (int)x;
		this.iY = (int)y;
	}

	public AMVector2 subtract(AMVector2 vec){
		return new AMVector2(this.x - vec.x, this.y - vec.y);
	}

	public AMVector2 add(AMVector2 vec){
		return new AMVector2(this.x + vec.x, this.y + vec.y);
	}

	public AMVector2 multiply(AMVector2 vec){
		return new AMVector2(this.x * vec.x, this.y * vec.y);
	}

	public AMVector2 divide(AMVector2 vec){
		return new AMVector2(this.x / vec.x, this.y / vec.y);
	}
}
