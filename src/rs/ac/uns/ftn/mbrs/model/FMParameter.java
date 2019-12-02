package rs.ac.uns.ftn.mbrs.model;

public class FMParameter extends FMNamedElement {
    private final FMType type;

    public FMParameter(String name, FMType type) {
        super(name);
        this.type = type;
    }

    public FMType getType() {
        return type;
    }
}
