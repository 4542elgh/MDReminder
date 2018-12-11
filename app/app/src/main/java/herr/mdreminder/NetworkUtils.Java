package herr.mdreminder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class NetworkUtils {

    final static String BASE_URL = "https://api.fda.gov/drug/label.json?";

    // get api key @https://open.fda.gov/apis/authentication/
    final static String apiKey = "kYUL8C4ZdJ9baxinXqh6w3gP1b2EHvwVhTQkKQGo";

    // searchable fields
    final static String[] searchableFields = {"indications_and_usage"};

    static String url = "";


    // use URLEncoder to format url Strings
    public static String generateUrl(String field) {
        for(int i = 0; i < searchableFields.length; i++) {
            if(searchableFields[i] == field) {
                try {
                    url = BASE_URL + "api_key=" + apiKey + "&search=" + URLEncoder.encode(searchableFields[i], "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return url;
        }
        return "There is not result.";
    }

}