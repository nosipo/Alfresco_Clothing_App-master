package com.nosipo.alfrescoclothing.domain.dresses;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FlaredDress implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long _id;
    private String name;
    private String colour;
    private String price;



    public FlaredDress(Builder builder) {
        this._id = builder._id;
        this.name = builder.name;
        this.name = builder.colour;
        this.price = builder.price;
    }

    public FlaredDress()
    {

    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() { return colour; }

    public void setColour(String colour) { this.colour = colour; }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return (int) (_id ^ (_id >>> 32));
    }

    public static class Builder
    {
        private long _id;
        private String name;
        private String price;

        public Builder id(long value)
        {
            this._id=value;
            return this;
        }

        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder colour(String value)
        {
            this.colour = value;
            return this;
        }

        public Builder price(String value)
        {
            this.price = value;
            return this;
        }

        public Builder copy(FlaredDress value)
        {
            this._id = value._id;
            this.name = value.name;
            this.name = value.colour;
            this.price = value.price;
            return this;
        }

        public FlaredDress build()
        {
            return new FlaredDress(this);
        }
    }
}
