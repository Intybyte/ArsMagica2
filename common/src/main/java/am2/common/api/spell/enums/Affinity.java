package am2.common.api.spell.enums;

import am2.common.base.NSKey;
import lombok.Getter;

public enum Affinity {
	NONE(0xFFFFFF, "lens_flare", "lights"),
	ARCANE(0xb935cd, "arcane", "symbols"),
	WATER(0x0b5cef, "water_ball", "water_hand"),
	FIRE(0xef260b, "explosion_2", "smoke"),
	EARTH(0x61330b, "rock", "earth_hand"),
	AIR(0x777777, "wind", "air_hand"),
	LIGHTNING(0xdece19, "lightning_hand", "lightning_hand"),
	ICE(0xd3e8fc, "ember", "snowflakes"),
	NATURE(0x228718, "plant", "leaf"),
	LIFE(0x34e122, "sparkle", "sparkle2"),
	ENDER(0x3f043d, "pulse", "ghost");

	public final int ID;
	public final int color;
	@Getter
	private final String mainParticle;
	@Getter
	private final String secondaryParticle;
	public NSKey representItem;
	public int representMeta;

	private Affinity directOpposingAffinity;
	@Getter
	private Affinity[] majorOpposingAffinities;
	@Getter
	private Affinity[] minorOpposingAffinities;
	@Getter
	private Affinity[] adjacentAffinities;

	Affinity(int color, String mainParticle, String secondaryParticle) {
		this.mainParticle = mainParticle;
		this.secondaryParticle = secondaryParticle;

		this.ID = ordinal();
		this.color = color;
	}

	private void init(Affinity directOpposingAffinity, Affinity[] majorOppositions, Affinity[] minorOppositions, Affinity[] adjacentAffinities) {
		this.directOpposingAffinity = directOpposingAffinity;
		this.majorOpposingAffinities = majorOppositions;
		this.minorOpposingAffinities = minorOppositions;
		this.adjacentAffinities = adjacentAffinities;
	}

	static {
		NONE.init(null, new Affinity[]{}, new Affinity[]{}, new Affinity[]{});

		ARCANE.init(NATURE,
				new Affinity[]{LIFE, EARTH, WATER, ICE},
				new Affinity[]{AIR, ENDER},
				new Affinity[]{LIGHTNING, FIRE});

		WATER.init(FIRE,
				new Affinity[]{ICE, EARTH, ARCANE, ENDER},
				new Affinity[]{AIR, ICE},
				new Affinity[]{LIFE, NATURE});

		FIRE.init(WATER,
				new Affinity[]{AIR, ICE, NATURE, LIFE},
				new Affinity[]{EARTH, LIGHTNING},
				new Affinity[]{ENDER, ARCANE});

		EARTH.init(AIR,
				new Affinity[]{WATER, ARCANE, LIFE, LIGHTNING},
				new Affinity[]{NATURE, FIRE},
				new Affinity[]{ICE, ENDER});

		AIR.init(EARTH,
				new Affinity[]{NATURE, FIRE, ICE, ENDER},
				new Affinity[]{WATER, ARCANE},
				new Affinity[]{LIFE, LIGHTNING});

		LIGHTNING.init(ICE,
				new Affinity[]{WATER, ENDER, NATURE, EARTH},
				new Affinity[]{LIFE, FIRE},
				new Affinity[]{AIR, ARCANE});

		ICE.init(LIGHTNING,
				new Affinity[]{LIFE, FIRE, AIR, ARCANE},
				new Affinity[]{WATER, ENDER},
				new Affinity[]{NATURE, EARTH});

		NATURE.init(ARCANE,
				new Affinity[]{AIR, ENDER, LIGHTNING, FIRE},
				new Affinity[]{LIFE, EARTH},
				new Affinity[]{WATER, ICE});

		LIFE.init(ENDER,
				new Affinity[]{ARCANE, ICE, FIRE, EARTH},
				new Affinity[]{NATURE, LIGHTNING},
				new Affinity[]{WATER, AIR});

		ENDER.init(LIFE,
				new Affinity[]{NATURE, LIGHTNING, WATER, AIR},
				new Affinity[]{ARCANE, ICE},
				new Affinity[]{EARTH, FIRE});
	}

	public Affinity getOpposingAffinity() {
		return directOpposingAffinity != null ? directOpposingAffinity : NONE;
	}

	public void setRepresentItem(NSKey representItem, int meta) {
		if (this.representItem == null) {
			this.representItem = representItem;
			this.representMeta = meta;
		}
	}

	public static Affinity getByID(int ID) {
		Affinity[] values = Affinity.values();
		if (values.length <= ID){
			return NONE;
		}

		return values[ID];
	}

	public static Affinity[] getOrderedAffinities() {
		return new Affinity[]{
				AIR,
				LIGHTNING,
				ARCANE,
				FIRE,
				ENDER,
				EARTH,
				ICE,
				NATURE,
				WATER,
				LIFE
		};
	}

	public int getAffinityMask() {
		switch (this) {
		case AIR:
			return 0x1;
		case ARCANE:
			return 0x2;
		case EARTH:
			return 0x4;
		case ENDER:
			return 0x8;
		case FIRE:
			return 0x10;
		case ICE:
			return 0x20;
		case LIFE:
			return 0x40;
		case LIGHTNING:
			return 0x80;
		case NATURE:
			return 0x100;
		case WATER:
			return 0x200;
		case NONE:
		default:
			return 0;
		}
	}
}
