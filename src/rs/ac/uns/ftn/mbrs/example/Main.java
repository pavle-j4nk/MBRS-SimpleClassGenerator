package rs.ac.uns.ftn.mbrs.example;

import rs.ac.uns.ftn.mbrs.generator.ClassGenerator;

public class Main {

    public static void main(String[] args) {
        ClassGenerator generator = new ClassGenerator();
        generator.generate(User.getUserClass());
        generator.generate(Product.getProductClass());
        generator.generate(Cart.getCartClass());
    }

}
