package rs.ac.uns.ftn.mbrs.model;

import java.util.*;

public class FMProperty extends FMNamedElement {
    private Set<FMModifier> modifiers;
    private FMType type;
    private Integer lower;
    private Integer upper;
    private Boolean getter;
    private Boolean setter;

    public FMProperty(String name, FMType type, int lower, int upper, FMModifier... modifiers) {
        super(name);
        this.type = type;

        this.lower = lower;
        this.upper = upper;

        this.modifiers = new HashSet<>(Arrays.asList(modifiers));
    }

    public FMProperty(String name, FMType type, FMModifier... modifiers) {
        this(name, type, 0, 1, modifiers);
    }

    public FMType getType() {
        return type;
    }

    public void setType(FMType type) {
        this.type = type;
    }

    public Integer getLower() {
        return lower;
    }

    public void setLower(Integer lower) {
        this.lower = lower;
    }

    public Integer getUpper() {
        return upper;
    }

    public void setUpper(Integer upper) {
        this.upper = upper;
    }

    public Set<FMModifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(Set<FMModifier> modifiers) {
        this.modifiers = modifiers;
    }

    public Boolean getGetter() {
        return getter;
    }

    public void setGetter(Boolean getter) {
        this.getter = getter;
    }

    public Boolean getSetter() {
        return setter;
    }

    public void setSetter(Boolean setter) {
        this.setter = setter;
    }
}
