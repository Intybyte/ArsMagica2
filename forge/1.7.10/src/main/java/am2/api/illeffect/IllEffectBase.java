package am2.api.illeffect;

import am2.common.api.illeffect.IllEffectSeverity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.Map;

/**
 * Base class for all ill effects.
 *
 * @author Mithion
 */
public abstract class IllEffectBase implements IIllEffect{

	@Override
	public final int compareTo(Object o){
		if (!(o instanceof IIllEffect)) return 0;
		IIllEffect right = (IIllEffect)o;
		int myOrdinal = this.GetSeverity().ordinal();
		int theirOrdinal = right.GetSeverity().ordinal();

		return Integer.compare(myOrdinal, theirOrdinal);
	}

	@Override
	public abstract IllEffectSeverity GetSeverity();

	@Override
	public abstract String getDescription(EntityPlayer player, Object metadata);

	@Override
	public abstract Map<EntityPlayer, Object> ApplyIllEffect(World world, int x, int y, int z);

}
