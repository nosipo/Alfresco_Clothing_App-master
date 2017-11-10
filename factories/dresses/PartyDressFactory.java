package com.nosipo.alfrescoclothing.factories.dresses;
import com.nosipo.alfrescoclothing.domain.dresses.PartyDress;

public class PartyDressFactory
{
    public static PartyDress getParyDress(String name, String colour, String price)
    {
        PartyDress partyDress = new PartyDress.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return partyDress;
    }
}
