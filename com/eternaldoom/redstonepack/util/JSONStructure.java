package com.eternaldoom.redstonepack.util;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import scala.util.parsing.json.JSONObject;

public class JSONStructure {
	public static void importStructure(String jsonFile) {
		
		try {
			Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "UTF-8");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    	JSONObject[] data = gson.fromJson(reader, JSONObject[].class);
	    	/*
	    	 * TODO
	    	 * Process and Register the structure. xv435 will code it but needs to do some research first
	    	 */
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
