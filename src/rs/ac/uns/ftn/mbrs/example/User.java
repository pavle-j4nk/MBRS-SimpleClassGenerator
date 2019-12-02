package rs.ac.uns.ftn.mbrs.example;

import rs.ac.uns.ftn.mbrs.model.*;

import java.util.List;

public class User {

    public static FMClass getUserClass() {
        FMClass user = new FMClass("rs.ac.uns.ftn.mbrs.example.generated", "User", Classes.OBJECT, FMModifier.PUBLIC);

        user.addProperties(getFirstNameProperty(), getLastNameProperty());
        user.addMethods(getCreateMethod(user));

        return user;
    }

    public static FMProperty getFirstNameProperty() {
        FMProperty name = new FMProperty("firstName", Classes.STRING, FMModifier.PRIVATE);
        name.setGetter(true);
        name.setSetter(true);
        return name;
    }

    public static FMProperty getLastNameProperty() {
        FMProperty name = new FMProperty("lastName", Classes.STRING, FMModifier.PRIVATE);
        name.setGetter(true);
        name.setSetter(true);
        return name;
    }

    public static FMProperty getAddressProperty() {
        FMProperty description = new FMProperty("address", Classes.STRING, FMModifier.PRIVATE);
        description.setGetter(true);
        description.setSetter(true);
        return description;
    }

    public static FMMethod getCreateMethod(FMClass productClass) {
        FMMethod create =
                new FMMethod(
                        "create", productClass,
                        List.of(
                                new FMParameter("firstName", Classes.STRING),
                                new FMParameter("lastName", Classes.STRING)
                        ),
                        FMModifier.PUBLIC, FMModifier.STATIC
                );
        return create;
    }


}
