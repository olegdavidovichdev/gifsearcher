package com.example.gifsearcher;

import android.app.ProgressDialog;

/**
 * Created by Oleg on 30.09.2016.
 */
public abstract class DialogCreator {

    public static void onCreateDialog(ProgressDialog pg, String message) {
        pg.setMessage(message);
        pg.setIndeterminate(true);
        pg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pg.show();
    }
}
