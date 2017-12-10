package com.example.beam.easywallet.model;

/**
 * Created by Beam on 12/10/2017.
 */

public class Walllet {

    public final int id;
    public final String name;
    public final String price;
    public final String image;


    public Walllet(int id , String name , String price , String image){

        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }


}
