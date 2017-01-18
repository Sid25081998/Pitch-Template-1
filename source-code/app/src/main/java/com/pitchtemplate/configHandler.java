package com.pitchtemplate;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sid on 1/12/17.
 */

public class configHandler {
    static template readConfigFile(Context context){
        try {
            Gson jsonSerializer = new Gson();
            InputStreamReader configStream = new InputStreamReader(context.getAssets().open("config.json"));
            BufferedReader configReader = new BufferedReader(configStream);
            StringBuilder configJson = new StringBuilder();
            String line;
            while ((line = configReader.readLine()) != null) {
                configJson.append(line);
            }
            template data =jsonSerializer.fromJson(configJson.toString(), new TypeToken<template>() {}.getType());
            return data;
        }
        catch (IOException e){
            //EXCEPTION WILL NEVER BE CAUGHT
        }
        return null;
    }
}
