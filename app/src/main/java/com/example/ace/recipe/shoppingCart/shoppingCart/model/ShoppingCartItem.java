package com.example.ace.recipe.shoppingCart.shoppingCart.model;

/**
 * Created by Jovan on 3/14/2015.
 */
public class ShoppingCartItem {

    private Long id;
    private String name;
    private String quantity;
    private boolean done;

    public ShoppingCartItem(Long _id, String _name, String _quantity, boolean _done){
        super();
        id = _id;
        name = _name;
        quantity = _quantity;
        done = _done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
