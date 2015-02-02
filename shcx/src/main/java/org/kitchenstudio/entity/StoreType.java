package org.kitchenstudio.entity;

import java.io.Serializable;

public class StoreType implements Serializable {

	private static final long serialVersionUID = 411265795841464796L;

	private Type type;

	private String spec;

	public StoreType() { // For Hibernate
	}

	public StoreType(Type type, String spec) {
		this.type = type;
		this.spec = spec;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Override
	public int hashCode() {
		return (type.getName() + spec).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreType other = (StoreType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (spec == null) {
			if (other.spec != null)
				return false;
		} else if (!spec.equals(other.spec))
			return false;
		return true;
	}
}
