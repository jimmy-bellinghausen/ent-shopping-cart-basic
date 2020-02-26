package com.galvanize.cart;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

public class Cart {
/*
*Mutable type that represents a shopping cart
*
* Abstraction Function:
*       AF(items,cachedTotal) = shopping cart with a list of items and a total cost of what's inside
*
* Not Threadsafe
 */
    private ArrayList<Item> items;
    private double cachedTotal;

    public Cart(){
    /*
    * creates an empty cart
     */
        items = new ArrayList<Item>();
        cachedTotal=0;
    }

    public ArrayList<String> ItemQuantities(){
    /*
    * returns list of item quantities in shopping cart
     */
        TreeMap<String,Integer> tracker = new TreeMap<String, Integer>();
        for(Item item : items){
            tracker.compute(item.getName(), (key,value) -> (value==null) ? 1 : value + 1 );
        }
        ArrayList<String> quantitativeList = new ArrayList<String>();
        for(Map.Entry<String, Integer> item : tracker.entrySet()){
            quantitativeList.add(item.getKey()+" - "+item.getValue());
        }
        return quantitativeList;
    }

    public ArrayList<String> ItemizedList(){
    /*
     * returns itemized list of items in shopping cart
     */
        TreeMap<String,Double> tracker = new TreeMap<String, Double>();
        for(Item item : items){
            tracker.put(item.getName(),item.getCost());
        }
        ArrayList<String> itemizedList = new ArrayList<String>();
        for(Map.Entry<String, Double> item : tracker.entrySet()){
            itemizedList.add(item.getKey()+" - $"+item.getValue());
        }
        return itemizedList;
    }

    public ArrayList<String> OnSaleItems(){
    /*
     * returns list of items on sale in shopping cart
     */
        TreeMap<String,Double> tracker = new TreeMap<String, Double>();
        for(Item item : items){
            if(item.getSaleStatus()) {
                tracker.put(item.getName(), item.getCost());
            }
        }
        ArrayList<String> itemizedList = new ArrayList<String>();
        for(Map.Entry<String, Double> item : tracker.entrySet()){
            itemizedList.add(item.getKey()+" - $"+item.getValue());
        }
        return itemizedList;
    }

    public void AddItem(Item item){
    /*
    * Adds item to shopping cart
    *
    * @params
    *       item - Item to be added
     */
        this.items.add(item);
        this.cachedTotal+=item.getCost();
    }

    public void AddItem(Item item, int quantity){
    /*
     * Adds specified quantity of items to shopping cart
     *
     * @params
     *      item - Item to be added
     *      quantity - how many items to be added
     */
        for(int x=0;x<quantity;x++){
            this.items.add(item);
        }
        this.cachedTotal+=(item.getCost()*quantity);
    }

    public ArrayList<Item> getItems(){
    /*
    * returns list of items in shopping cart
     */
        return this.items;
    }

    public double getTotalPrice(){
    /*
    * returns total price of items in cart
     */
        return this.cachedTotal;
    }
}
