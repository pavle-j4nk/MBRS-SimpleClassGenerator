package rs.ac.uns.ftn.mbrs.model;

public final class ClassFactory {

    public static FMClass fromClass(Class c) {
        return new FMClass(c.getPackageName(), c.getSimpleName());
    }

}
