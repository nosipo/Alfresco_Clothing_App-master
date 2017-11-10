package com.nosipo.alfrescoclothing.factories.tops;
import com.nosipo.alfrescoclothing.domain.tops.AsymmetricalTop;

public class AsymmetricalTopFactory
{
    public static AsymmetricalTop getAsymmetricalTop(String name, String colour, String price)
    {
        AsymmetricalTop asymmetricalTop = new AsymmetricalTop.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return asymmetricalTop;
    }
}
