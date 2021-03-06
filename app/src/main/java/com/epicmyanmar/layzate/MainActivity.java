package com.epicmyanmar.layzate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import butterknife.ButterKnife;
import butterknife.InjectView;
import entity.Flight;
import model.Dal;


public class MainActivity extends Activity {
    private static final String URL_STRING_REQ = "http://www.flightstats.com/go/weblet?guid=34b64945a69b9cac:a51bccf:12d54dfa33f:-5bfe&weblet=status&action=AirportFlightStatus&airportCode=RGN";
//   / private String TAG = MainActivity.class.getSimpleName();

    private String tag_string_req = "string_req";
    FlightListFragment flightListFragment;
    /*
    * txt_status will be notifier of all status of app  like no connection,no flight status etc
    * */
    public static   TextView txt_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ColorDrawable colorDrawable = new ColorDrawable(Color.WHITE);

        super.onCreate(savedInstanceState);
        Intent intent= getIntent();
        String airportQueryTimePeriod=intent.getStringExtra("airportQueryTimePeriod");
        String airportQueryType=intent.getStringExtra("airportQueryType");
        String Airport=intent.getStringExtra("Airport");

        String port_name=intent.getStringExtra("txt_portname");
        String query_type=intent.getStringExtra("txt_querytype");

        setContentView(R.layout.activity_main);
       txt_status=(TextView) findViewById(R.id.txt_status);




        if(savedInstanceState==null){
            //passing values to bundle
            Bundle bundle=new Bundle();

            bundle.putString("airportQueryTimePeriod",airportQueryTimePeriod);
            bundle.putString("airportQueryType",airportQueryType);
            bundle.putString("Airport",Airport);
            bundle.putString("port_name",port_name);
            bundle.putString("query_type",query_type);

            flightListFragment=new FlightListFragment();
            flightListFragment.setArguments(bundle);

          getFragmentManager().beginTransaction().add(R.id.container,flightListFragment).commit();
        }

          // makeStringReq(URL_STRING_REQ);
          // postStringReq(URL_STRING_REQ);
    }




        /**
         * Making json object request
         * */

    /**
    *
    * This Method Make Get Request with Volley & Manipulate Response with Jsoup
    * */
    private void makeStringReq(String url) {
        //showProgressDialog();

        RequestQueue queue = Volley.newRequestQueue(getApplication());
        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            List<Flight> flist=new ArrayList<Flight>();

            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());

            }
        });

        // Adding request to request queue
        queue.add(strReq);

    }

    /**
     *
     * This Method Make Post Request with some URL parameter with volley & Manipulate Response with Jsoup
     * */
    private void postStringReq(String url) {
        //showProgressDialog();

        RequestQueue queue = Volley.newRequestQueue(getApplication());
        StringRequest strReq = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {

            //call back function from Google volley
            @Override
            public void onResponse(String response) {
                       //getting data from flightlist



            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());

            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("language","English");
                params.put("startAction","AirportFlightStatus");
                params.put("airportQueryTimePeriod", "5");
                params.put("imageColor","orange");
                params.put("airportQueryType","0");

                return params;
            }


        };

        // Adding request to request queue
        queue.add(strReq);

    }


}
