package com.nosipo.alfrescoclothing.factories.tops;
import com.nosipo.alfrescoclothing.domain.tops.CropTop;

public class CropTopFactory
{
    public static CropTop getCropTop(String name, String colour, String price)
    {
        CropTop cropTop = new CropTop.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return cropTop;
    }
}
