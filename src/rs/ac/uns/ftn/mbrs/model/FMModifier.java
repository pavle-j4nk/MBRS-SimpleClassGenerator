package rs.ac.uns.ftn.mbrs.model;

public enum FMModifier {
    PUBLIC("public"),
    PROTECTED("protected"),
    PRIVATE("private"),

    STATIC("static"),
    ABSTRACT("abstract"),
    FINAL("final");

    private final String code;

    FMModifier(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
