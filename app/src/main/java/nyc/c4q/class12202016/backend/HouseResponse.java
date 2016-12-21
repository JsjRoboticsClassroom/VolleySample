package nyc.c4q.class12202016.backend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HouseResponse {
    private static final String JSON_HOUSES = "houses";
    private static final String JSON_SUCCESS = "success";
    private static final String JSON_STYLE = "style";
    private static final String JSON_PRICE = "price";
    private static final String JSON_LOCATION = "location";
    private boolean success;
    private List<House> houses;

    public List<House> getHouses(){
        return houses;
    }

    public static HouseResponse parse(String response) {
        try {
            JSONObject json = new JSONObject(response);
            boolean successful = json.getBoolean(JSON_SUCCESS);
            JSONArray houseList = json.getJSONArray(JSON_HOUSES);

            HouseResponse result = new HouseResponse();
            result.success = successful;
            result.houses = parseHouseList(houseList);
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return buildFailureCase();
    }

    private static List<House> parseHouseList(JSONArray houseList) {
        List<House> result = new ArrayList<>();
        for (int index = 0; index < houseList.length(); index++){
            try {
                JSONObject current = houseList.getJSONObject(index);

                String style = current.getString(JSON_STYLE);
                String price = current.getString(JSON_PRICE);
                String location = current.getString(JSON_LOCATION);
                House newHouse = new House(style, price,location);
                result.add(newHouse);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static HouseResponse buildFailureCase() {
        HouseResponse result = new HouseResponse();
        result.success = false;
        result.houses = new ArrayList<>();
        return result;
    }
}
