package com.nosipo.alfrescoclothing.factories.jeans;
import com.nosipo.alfrescoclothing.domain.jeans.SkinnyJean;

public class SkinnyJeanFactory
{
    public static SkinnyJean getSkinnyJean(String name, String colour, String price)
    {
        SkinnyJean skinnyJean = new SkinnyJean.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return skinnyJean;
    }
}
