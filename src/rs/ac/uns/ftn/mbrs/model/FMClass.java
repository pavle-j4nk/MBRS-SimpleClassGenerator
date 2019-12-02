package rs.ac.uns.ftn.mbrs.model;

import java.util.*;

public class FMClass extends FMType {
    private Set<FMModifier> modifiers;
    private List<FMProperty> properties;
    private List<FMMethod> methods;
    private FMClass superClass;

    public FMClass(String classPackage, String name, FMClass superClass, FMModifier... modifiers) {
        super(classPackage, name);

        this.superClass = superClass;

        this.modifiers = new LinkedHashSet<>(Arrays.asList(modifiers));
        this.properties = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    public FMClass(String classPackage, String name, FMModifier... modifiers) {
        this(classPackage, name, null, modifiers);
    }

    public void addModifies(FMModifier... newModifiers) {
        modifiers.addAll(Arrays.asList(newModifiers));
    }

    public void addProperties(FMProperty... newProperty) {
        properties.addAll(Arrays.asList(newProperty));
    }

    public void addMethods(FMMethod... newMethods) {
        methods.addAll(Arrays.asList(newMethods));
    }


    public Set<FMModifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(Set<FMModifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<FMProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<FMProperty> properties) {
        this.properties = properties;
    }

    public List<FMMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<FMMethod> methods) {
        this.methods = methods;
    }

    public FMClass getSuperClass() {
        return superClass;
    }

    public void setSuperClass(FMClass superClass) {
        this.superClass = superClass;
    }
}
