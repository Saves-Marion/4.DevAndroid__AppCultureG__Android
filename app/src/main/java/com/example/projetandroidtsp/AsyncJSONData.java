package com.example.projetandroidtsp;

import android.os.AsyncTask;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroidtsp.Controller.MesparaActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AsyncJSONData extends AsyncTask<String, Void, JSONObject> {

    private AppCompatActivity myActivity;

    public AsyncJSONData(AppCompatActivity Activity) {
        myActivity = Activity;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {

        URL url = null;
        HttpURLConnection urlConnection = null;
        String result = null;
        try {
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            InputStream in = new BufferedInputStream(urlConnection.getInputStream()); // Stream

            result = readStream(in); // Read stream
        }
        catch (MalformedURLException e) { e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }

        JSONObject json = null;
        try {
            assert result != null;
            json = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("lol","coucou"+json.toString());
        return json; // returns the result
    }

    protected void onPostExecute(JSONObject json) {
        String[] quest={"","","","","","","","","",""};
        String[] reponses={"a", "a","a", "c", "e", "d", "f", "g", "h", "i", "j","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d"};
        try {
            JSONArray items = json.getJSONArray("results");
            for (int i = 0; i<items.length(); i++)
            {
                JSONObject item=items.getJSONObject(i);
                String question =item.getString("question");
                quest[i]=question;

                int j=i*4;
                String rep =item.getString("correct_answer");
                reponses[j]=rep;
                String rep_f = item.getString("incorrect_answers");
                rep_f=rep_f.replace("[","");
                rep_f=rep_f.replace("]","");
                rep_f=rep_f.replaceAll("\"","");
                String[] rep_f_=rep_f.split(",");
                reponses[j+1]=rep_f_[0];
                reponses[j+2]=rep_f_[1];
                reponses[j+3]=rep_f_[2];
                //String item = items.getString(i);
                //String[] itemm=item.split(",");

                //String questionn=itemm[3];
                //String[] q= questionn.split(":");
                /*String question=q[1];
                quest[i]=question;

                int j=i*4;
                String repp=itemm[4];
                String[] r=repp.split(":");
                //reponses[j]=r[0];
                Log.i("lol",r[0].toString());

                String repp1=itemm[5];
                String[] re=repp1.split(":");
                //reponses[j+1]=re[1];
              //  reponses[j+2]=re[1];
               // reponses[j+3]=re[1];*/

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MesparaActivity.questions =quest;
        MesparaActivity.reponses=reponses;
    }

        private String readStream(InputStream is) {
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                int i = is.read();
                while(i != -1) {
                    bo.write(i);
                    i = is.read();
                }
                return bo.toString();
            } catch (IOException e) {
                return "";
            }
        }
}
