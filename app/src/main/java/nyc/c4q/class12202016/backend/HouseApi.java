package nyc.c4q.class12202016.backend;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import nyc.c4q.class12202016.helpers.Consumer;

public class HouseApi {
    private static final String URL = "http://jsjrobotics.nyc/cgi-bin/class_12_20_2016.pl";

    public static Request<String> buildDataRequest(Consumer<HouseResponse> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
                buildSuccessListener(listener),
                buildErrorListenr()
        );
        return request;
    }

    private static Response.ErrorListener buildErrorListenr() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Saw an error");
            }
        };
    }

    private static Response.Listener<String> buildSuccessListener(final Consumer<HouseResponse> listener) {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                HouseResponse result = HouseResponse.parse(response);
                listener.accept(result);
            }
        };
    }
}
