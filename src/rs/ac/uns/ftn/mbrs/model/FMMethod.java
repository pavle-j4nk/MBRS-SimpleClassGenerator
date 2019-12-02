package rs.ac.uns.ftn.mbrs.model;

import java.util.Arrays;
import java.util.List;

public class FMMethod extends FMNamedElement {
    private List<FMModifier> modifiers;
    private FMType returnType;
    private List<FMParameter> parameters;

    private String implementation;

    public FMMethod(String name, FMType returnType, List<FMParameter> parameters, FMModifier ... modifiers) {
        super(name);

        this.returnType = returnType;
        this.parameters = parameters;
        this.modifiers = Arrays.asList(modifiers);
    }

    public List<FMModifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<FMModifier> modifiers) {
        this.modifiers = modifiers;
    }

    public FMType getReturnType() {
        return returnType;
    }

    public void setReturnType(FMType returnType) {
        this.returnType = returnType;
    }

    public List<FMParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<FMParameter> parameters) {
        this.parameters = parameters;
    }

    public String getImplementation() {
        return implementation;
    }

    public void setImplementation(String implementation) {
        this.implementation = implementation;
    }
}
