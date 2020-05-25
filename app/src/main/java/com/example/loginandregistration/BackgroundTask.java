package com.example.loginandregistration;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, String, String> {
    Context context;
    BackgroundTask(Context ctx){
        context=ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        String type=strings[0];
        String loginURL="http://mat.sandeepraskar.com/login.php";
        String regURL="http://mat.sandeepraskar.com/reg.php";
        if(type.equals("reg")){
            String name= strings[1];
            String MName=strings[2];
            String LName= strings[3];
            String address=strings[4];
            String gender=strings[5];
            String Caste=strings[6];
            String subCaste= strings[7];
            String otherCaste=strings[8];
            String Dob=strings[9];
            String marStatus=strings[10];
            String Qualification= strings[11];
            String Phone=strings[12];
            String Expectation=strings[13];
            String Height=strings[14];
            String email= strings[15];
            String username=strings[16];
            String password=strings[17];
            try{
                URL url= new URL(regURL);
                try{
                    HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream= httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String insert_data = URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name, "UTF-8")+
                            "&"+URLEncoder.encode("MName", "UTF-8")+"="+URLEncoder.encode(MName, "UTF-8")+
                            "&"+URLEncoder.encode("LName", "UTF-8")+"="+URLEncoder.encode(LName, "UTF-8")+
                            "&"+URLEncoder.encode("address", "UTF-8")+"="+URLEncoder.encode(address, "UTF-8")+
                            "&"+URLEncoder.encode("gender", "UTF-8")+"="+URLEncoder.encode(gender, "UTF-8")+
                            "&"+URLEncoder.encode("caste", "UTF-8")+"="+URLEncoder.encode(Caste, "UTF-8")+
                            "&"+URLEncoder.encode("subCaste", "UTF-8")+"="+URLEncoder.encode(subCaste, "UTF-8")+
                            "&"+URLEncoder.encode("otherCaste", "UTF-8")+"="+URLEncoder.encode(otherCaste, "UTF-8")+
                            "&"+URLEncoder.encode("dob", "UTF-8")+"="+URLEncoder.encode(Dob, "UTF-8")+
                            "&"+URLEncoder.encode("marStatus", "UTF-8")+"="+URLEncoder.encode(marStatus, "UTF-8")+
                            "&"+URLEncoder.encode("qualification", "UTF-8")+"="+URLEncoder.encode(Qualification, "UTF-8")+
                            "&"+URLEncoder.encode("mobile", "UTF-8")+"="+URLEncoder.encode(Phone, "UTF-8")+
                            "&"+URLEncoder.encode("expectation", "UTF-8")+"="+URLEncoder.encode(Expectation, "UTF-8")+
                            "&"+URLEncoder.encode("height", "UTF-8")+"="+URLEncoder.encode(Height, "UTF-8")+
                            "&"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+
                            "&"+URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username, "UTF-8")+
                            "&"+URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream= httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result="";
                    String line="";
                    StringBuilder stringBuilder= new StringBuilder();
                    while ((line=bufferedReader.readLine())!=null){
                        stringBuilder.append(line).append("\n");

                    }
                    result=stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else if(type.equals("login")) {
            String user_name = strings[1];
            String pass_word = strings[2];
            try {
                URL url = new URL(loginURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String login_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") +
                            "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass_word, "UTF-8");
                    bufferedWriter.write(login_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");

                    }
                    result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
//super.onPostExecute(s);
    }

}
