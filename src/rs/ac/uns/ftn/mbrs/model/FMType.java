package rs.ac.uns.ftn.mbrs.model;

public class FMType extends FMNamedElement {
    private String typePackage;

    public FMType(String typePackage, String name) {
        super(name);
        this.typePackage = typePackage;
    }

	public String getFullName() {
		return typePackage + "." + getName();
	}

	public String getTypePackage() {
		return typePackage;
	}

	public void setTypePackage(String typePackage) {
		this.typePackage = typePackage;
	}
}
