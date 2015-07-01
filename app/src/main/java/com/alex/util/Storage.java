package com.alex.util;

import android.os.Environment;

/**
 * Created by alex on 15-7-1.
 * Storage common method
 */
public final class Storage {

    /**
     * Checks if external storage is available to at least read
     *
     * @return boolean
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    /**
     * Checks if external storage is available for read and write
     *
     * @return boolean
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }
}
