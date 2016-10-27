package mobile_proto_16.com.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

import butterknife.BindView;
import butterknife.ButterKnife;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.button) Button button;
    @BindView(R.id.input) EditText input;
    @BindView(R.id.price) TextView price;

    private final String TAG = this.getClass().getName();

    //response listener takes the raw string response, takes off a couple of slashes, sends the
    //result to get parsed in the extractPriceFromJSON function, and sets the textview to the response
    private Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                JSONArray j = new JSONArray(response.substring(3));
                String p = extractPriceFromJSON(j);
                price.setText(p);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    //error listener logs the errors so you can figure out the problem.
    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, "A VolleyError occurred.");
            error.printStackTrace();
        }
    };

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //makes a url from the input text, makes a stringRequest, adds it to the request queue.
                String url = buildSearchURL(input.getText().toString());

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        responseListener, errorListener);

                MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
                }
            });

        return view;
    }

    private String buildSearchURL(String companyTicker) {
        // Uses UriBuilder to make a url. There's only one parameter we care about right now, so
        // string concatenation would probably work, but this is best practices or whatever (and it's
        //a lot easier to change if more parameters were added)

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("finance.google.com")
                .appendPath("finance")
                .appendPath("info")
                .appendQueryParameter("client", "iq")
                .appendQueryParameter("q", companyTicker);

        return builder.build().toString();
    }

    private String extractPriceFromJSON(JSONArray array) throws JSONException {
        //get the JSON object from the JSONArray, then get the value of the key "l"
        JSONObject o = array.getJSONObject(0);
        return o.getString("l");
    }

}
