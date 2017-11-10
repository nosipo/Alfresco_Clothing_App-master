package com.nosipo.alfrescoclothing.factories.tops;
import com.nosipo.alfrescoclothing.domain.tops.SplitSleevesTop;

public class SplitSleevesTopFactory
{
    public static SplitSleevesTop getSplitSleevesTop(String name, String colour, String price)
    {
        SplitSleevesTop splitSleevesTop = new SplitSleevesTop.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return splitSleevesTop;
    }
}
