package com.bottle.alan.messageinabottle;
        import android.os.*;
        import android.os.Process;
        import android.util.Log;

        import org.apache.http.HttpEntity;
        import org.apache.http.HttpResponse;
        import org.apache.http.NameValuePair;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.message.BasicNameValuePair;

        import java.io.BufferedReader;
        import java.io.DataOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.ProtocolException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;

        import javax.xml.transform.Result;

public class Test extends AsyncTask<String, String, String>{
    // Create a new HttpClient and Post Header
   public  Integer personid = null;

    public Integer getPersonId(){
        return personid;
    }
    public Test(){
        Log.d("calling con of t", "true");
        }


    protected String doInBackground(String... params) {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://messageinbottle.org:8002/bottle/initial/");

        try {
            //add data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
                nameValuePairs.add(new BasicNameValuePair("hi", params[0]));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            //execute http post
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                String s = (convertStreamToString(instream));
                Integer newResult = Integer.parseInt((s.substring(s.indexOf(":") + 1,s.lastIndexOf("}"))).trim());
                instream.close();
                personid = newResult;
                Log.d("PersonId:", personid.toString());
                return newResult.toString();
            }

        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }
        return null;
    }

    protected void onPostExecute(HttpResponse result) throws IOException {
        Log.d("on post is happening:", "true");

    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d("String: ", sb.toString());
        return sb.toString();
    }
}