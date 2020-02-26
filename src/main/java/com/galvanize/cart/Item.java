package com.galvanize.cart;

public class Item {
/*
*Immutable type representing a store item
*
* Rep Invariant:
*       cost > 0
* Abstraction Function:
*       AF(name,cost,onSale) = an item with a name, cost, sale status.
* Thread Safety Argument:
*       This class is threadsafe because it's immutable:
*           - all properties are encapsulated in this object and never changed after construction.
 */

    private String name;
    private double cost;
    private boolean onSale=false;

    public Item(String name, double cost){
    /*
    *creates an item with specified name and cost and is not on sale.
    *
    *@params
    *   name - name to be displayed by list
    *   cost - cost in  currency
    */
        this.name=name;
        this.cost=cost;
    }


    public Item(String name, double cost, boolean onSale){
    /*
     *creates an item with specified name, cost and sale status.
     *
     *@params
     *   name - name to be displayed by list
     *   cost - cost in currency
     *   onSale - indicates if the item is on sale
     */
        this(name,cost);
        this.onSale=onSale;
    }

    public double getCost(){
    /*
    * returns item cost
     */
        return this.cost;
    }

    public String getName(){
    /*
    * returns item name
     */
        return this.name;
    }

    public boolean getSaleStatus(){
    /*
    * returns item sale status
     */
        return this.onSale;
    }
}
