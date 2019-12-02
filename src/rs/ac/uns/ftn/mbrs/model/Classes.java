package rs.ac.uns.ftn.mbrs.model;

public interface Classes {
    FMClass OBJECT = ClassFactory.fromClass(Object.class);
    FMClass STRING = ClassFactory.fromClass(String.class);
    FMClass INTEGER = ClassFactory.fromClass(Integer.class);
    FMClass DOUBLE = ClassFactory.fromClass(Double.class);
}
