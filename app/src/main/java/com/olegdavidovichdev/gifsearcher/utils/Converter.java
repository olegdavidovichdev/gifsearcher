package com.olegdavidovichdev.gifsearcher.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class Converter {

    public static String convertBToMB(String gifSize) { // TODO check math
        int sizeInB = Integer.parseInt(gifSize);

        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##", dfs);
        double sizeInMB = sizeInB / 1024.0 / 1024.0;

        return df.format(sizeInMB);
    }

}