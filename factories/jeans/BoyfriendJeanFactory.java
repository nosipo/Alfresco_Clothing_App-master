package com.nosipo.alfrescoclothing.factories.jeans;
import com.nosipo.alfrescoclothing.domain.jeans.BoyfriendJean;

public class BoyfriendJeanFactory
{
    public static BoyfriendJean getBoyfriendJean(String name, String colour, String price)
    {
        BoyfriendJean boyfriendJean = new BoyfriendJean.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return boyfriendJean;
    }
}
