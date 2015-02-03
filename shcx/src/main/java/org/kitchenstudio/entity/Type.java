package org.kitchenstudio.entity;

public enum Type {

	STEEL_PIPE("STEEL_PIPE"), // 钢管
	FASTENER("FASTENER"), // 扣件
	SLEEVE("SLEEVE"), // 套筒
	;

	private final String name;

	public static Type forName(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null for type");
		}
		switch (name.toUpperCase()) {
		case "STEEL_PIPE":
			return STEEL_PIPE;
		case "FASTENER":
			return FASTENER;
		case "SLEEVE":
			return SLEEVE;
		default:
			throw new IllegalArgumentException("Name \"" + name
					+ "\" does not correspond to any Type");
		}
	}

	private Type(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return getName();
	}

}
