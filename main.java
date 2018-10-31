//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import java.io.FileReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;

//import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {

    public static void main(String[] args) {
//======================LOAD USING ORG.JSON.SIMPLE========================
//        JSONParser parser = new JSONParser();

        try {
//======================LOAD USING ORG.JSON.SIMPLE========================

//            Object obj = parser.parse(new FileReader("./src/drug-enforcement-0001-of-0001.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//            Object msg = jsonObject.get("meta");
//            JSONObject param1 = (JSONObject) msg;
//            Object msg2 = param1.get("license");
//            System.out.println(msg2.toString());

//======================LOAD USING ORG.JSON========================
//            String contents = new String(Files.readAllBytes(Paths.get("./src/drug-enforcement-0001-of-0001.json")));
//            JSONObject tomJsonObject = new JSONObject(contents);
//            Object msg = tomJsonObject.get("meta");
//            System.out.println(msg);s
//            JSONObject param1 = (JSONObject) msg;
//            Object msg2 = param1.get("license");
//            System.out.println(msg2.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){

        }catch (JSONException e){

        }

    }

}