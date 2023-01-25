package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author Ashutosh Mishra (nityagautam)
 * @created 25 Jan 2023
 * @lastModified 25 Jan 2023
 * @Desc 
 * 		Reads the provided JSON file and returns the JSON Object
 *
 */
@SuppressWarnings("unchecked")
public class JSONReader {
	Object jsonFileObject;
	JSONObject jsonObject;
	JSONArray jsonArray;
	JSONParser jsonParser;
	
	
	/*
	 * --------------------------------------------------------------------
	 * Constructor Methods
	 * --------------------------------------------------------------------
	 */
	
	/**
	 * Constructor
	 * @param file
	 */
	public JSONReader(String file) {
		//JSON parser object to parse read file
        this.jsonParser = new JSONParser(); 
        try (FileReader reader = new FileReader(file))
        {
            //Read JSON file
            this.jsonFileObject = jsonParser.parse(reader);
            // Convert to the JSON Object (Treating entire json file as object; i.e start with {} )
            this.jsonObject = (JSONObject) this.jsonFileObject;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Overloaded Constructor
	 * @param file
	 * @param asList
	 */
	public JSONReader(String file, boolean asList) {
		//JSON parser object to parse read file
        this.jsonParser = new JSONParser(); 
        try (FileReader reader = new FileReader(file))
        {
            //Read JSON file
            this.jsonFileObject = jsonParser.parse(reader);
            // Convert to the JSON Object (Treating entire json file as Array/List; i.e starts with [] )
            this.jsonArray = (JSONArray) this.jsonFileObject;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	/*
	 * --------------------------------------------------------------------
	 * Getter Methods
	 * --------------------------------------------------------------------
	 */
	
	/**
	 * Returns a string value from given key
	 * 
	 * @param key
	 * @return String
	 */
	public String get(String key) {
		//Get value from a key
        return (String) this.jsonObject.get(key);
	}
	
	/**
	 * Returns a string value from given key and a JSON Object
	 * 
	 * @param key
	 * @param obj
	 * @return
	 */
	public String get(String key, JSONObject obj) {
		//Get value from a key
        return (String) obj.get(key);
	}
	
	/**
	 * Returns a list of object as JSONArray from a given key
	 * 
	 * @param key
	 * @return
	 */
	public JSONArray getList(String key) {
		//Get employee object within list
        JSONArray arrayObject = (JSONArray) this.jsonObject.get(key);
		return arrayObject;
	}
	
	/**
	 * Prints the object's string value from a JSONArray object
	 * 
	 * @param obj
	 */
	public void showTheListData(JSONArray obj) {
        //Iterate over array to print its object as string
        obj.forEach( data -> { System.out.println(( (JSONObject) data ));} );
	}
	
}
