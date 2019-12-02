package rs.ac.uns.ftn.mbrs.example;

import rs.ac.uns.ftn.mbrs.model.*;

import java.util.List;

public class Product {
    public static FMClass getProductClass() {
        FMClass fmClass = new FMClass("rs.ac.uns.ftn.mbrs.example.generated", "Product", Classes.OBJECT, FMModifier.PUBLIC);

        fmClass.addProperties(getNameProperty(), getDescriptionProperty(), getPriceProperty());
        fmClass.addMethods(getCreateMethod(fmClass));

        return fmClass;
    }

    public static FMProperty getNameProperty() {
        FMProperty name = new FMProperty("name", Classes.STRING, FMModifier.PRIVATE);
        name.setGetter(true);
        name.setSetter(true);
        return name;
    }

    public static FMProperty getDescriptionProperty() {
        FMProperty description = new FMProperty("description", Classes.STRING, FMModifier.PRIVATE);
        description.setGetter(true);
        description.setSetter(true);
        return description;
    }

    public static FMProperty getPriceProperty() {
        FMProperty price = new FMProperty("price", Classes.DOUBLE, FMModifier.PRIVATE);
        price.setGetter(true);
        price.setSetter(true);
        return price;
    }

    public static FMMethod getCreateMethod(FMClass productClass) {
        FMMethod create =
                new FMMethod(
                        "create", productClass,
                        List.of(
                                new FMParameter("name", Classes.STRING),
                                new FMParameter("description", Classes.STRING),
                                new FMParameter("price", Classes.DOUBLE)
                        ),
                        FMModifier.PUBLIC, FMModifier.STATIC
                );

        return create;
    }

}
