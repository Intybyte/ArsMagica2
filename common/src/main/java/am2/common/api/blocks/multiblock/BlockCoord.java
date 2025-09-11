package am2.common.api.blocks.multiblock;

import lombok.Getter;

@Getter
public class BlockCoord implements Comparable<BlockCoord>{
	public int x;
	public int y;
	public int z;

	public BlockCoord(int offsetX, int offsetY, int offsetZ){
		this.x = offsetX;
		this.y = offsetY;
		this.z = offsetZ;
	}

	@Override
	public boolean equals(Object obj){
		if (obj instanceof BlockCoord){
			return this.x == ((BlockCoord)obj).x && this.y == ((BlockCoord)obj).y && this.z == ((BlockCoord)obj).z;
		}
		return false;
	}

	@Override
	public int hashCode(){
		return this.x + this.y + this.z;
	}


	@Override
	public String toString(){
		return String.format("BlockCoord: %d, %d, %d", x, y, z);
	}

	@Override
	public int compareTo(BlockCoord o){
		return this.z > o.z ? 1 : this.z < o.z ? -1 : this.x > o.x ? 1 : this.x < o.x ? -1 : this.y > o.y ? 1 : this.y < o.y ? -1 : 0;
	}
}
