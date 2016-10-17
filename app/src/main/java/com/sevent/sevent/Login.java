package com.sevent.sevent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.sevent.sevent.DAO.LoginDao;
import com.sevent.sevent.DAO.UserDao;

public class Login extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private EditText username, password;

    private String user, pass;

    UserDao userDao;

    TextView SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        SignUp = (TextView) findViewById(R.id.newaccount);
    }

    public void onLogin(View view) {
        user = username.getText().toString();
        pass = password.getText().toString();

        new BackgroundTask().execute();
    }

    public void onNewAccount(View view) {
        Intent i = new Intent(Login.this, SignUp.class);
        startActivity(i);
    }

    private class BackgroundTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Login.this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String url = "http://tosteng.hol.es/user.php?username="+user+"&password="+pass;
            Log.d("url", url);
            String reader = new ServiceHandler().makeServiceCall(url, ServiceHandler.GET);

            if (reader == null) return null;
            LoginDao login = new GsonBuilder().create().fromJson(reader, LoginDao.class);

            Log.d("info","message "+ login.getMessage());


            if (login.getData() != null) {
                userDao = login.getData();
                Log.d("info", "username " + login.getData().getUsername());
                Log.d("info", "id_user " + login.getData().getId_user());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.hide();
            if (userDao !=null) {
                Intent i = new Intent(Login.this, MainActivity.class);
                i.putExtra("nama", userDao.getUsername());
                startActivity(i);
            } else {
                Toast.makeText(Login.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
