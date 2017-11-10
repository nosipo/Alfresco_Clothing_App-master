package com.nosipo.alfrescoclothing.factories.tops;
import com.nosipo.alfrescoclothing.domain.tops.SweetheartTop;

public class SweetheartTopFactory
{
    public static SweetheartTop getSweetheartTop(String name, String colour, String price)
    {
        SweetheartTop sweetheartTop = new SweetheartTop.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return sweetheartTop;
    }
}
