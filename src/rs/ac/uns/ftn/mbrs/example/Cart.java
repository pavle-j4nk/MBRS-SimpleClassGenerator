package rs.ac.uns.ftn.mbrs.example;

import rs.ac.uns.ftn.mbrs.model.*;

import java.util.List;

public class Cart {
    private final static FMClass USER_CLASS = User.getUserClass();
    private final static FMClass PRODUCT_CLASS = Product.getProductClass();

    public static FMClass getCartClass() {
        FMClass cart = new FMClass("rs.ac.uns.ftn.mbrs.example.generated", "Cart", FMModifier.PUBLIC);

        cart.addProperties(getOwnerProperty(), getProductsProperty(), getTotalPriceProperty());
        cart.addMethods(getCreateEmptyMethod(cart), getAddToCartMethod(), getRemoveFromCartMethod(), getPurchaseMethod());
        return cart;
    }

    public static FMProperty getOwnerProperty() {
        FMProperty property = new FMProperty("owner", USER_CLASS, FMModifier.PRIVATE);
        property.setSetter(true);
        property.setGetter(true);
        return property;
    }

    public static FMProperty getProductsProperty() {
        FMProperty property = new FMProperty("products", USER_CLASS, 0, -1, FMModifier.PRIVATE);
        return property;
    }

    public static FMProperty getTotalPriceProperty() {
        FMProperty totalPrice = new FMProperty("totalPrice", Classes.DOUBLE, FMModifier.PRIVATE);
        totalPrice.setGetter(true);
        return totalPrice;
    }

    public static FMMethod getCreateEmptyMethod(FMClass productClass) {
        FMMethod createEmpty = new FMMethod("createEmpty", productClass, List.of(new FMParameter("owner", USER_CLASS)), FMModifier.PUBLIC, FMModifier.STATIC);
        return createEmpty;
    }

    public static FMMethod getAddToCartMethod() {
        FMMethod addToCart = new FMMethod("addToCart", null, List.of(new FMParameter("product", PRODUCT_CLASS)), FMModifier.PUBLIC);
        return addToCart;
    }

    public static FMMethod getRemoveFromCartMethod() {
        FMMethod removeFromCart = new FMMethod("removeFromCart", null, List.of(new FMParameter("product", PRODUCT_CLASS)), FMModifier.PUBLIC);
        return removeFromCart;
    }

    public static FMMethod getPurchaseMethod() {
        FMMethod removeFromCart = new FMMethod("purchase", null, List.of(), FMModifier.PUBLIC);
        return removeFromCart;
    }

}
