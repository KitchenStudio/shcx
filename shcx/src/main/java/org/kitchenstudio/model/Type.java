package org.kitchenstudio.model;


public enum Type {
    
    STEEL_PIPE("STEEL_PIPE"), 
    FASTENER("FASTENER");
    
    private final String name;

    
    public static Type forName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null for type");
        }
        if (name.equals("STEEL_PIPE")) {
            return STEEL_PIPE;
        } else if (name.equals("FASTENER")) {
            return FASTENER;
        }
        throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Type");
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
