package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString("username", "").equals("")){
            String user = sharedPreferences.getString("username","");
            login(user);
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onButtonClick(View view) {
        EditText usernameField = (EditText) findViewById(R.id.text_username);
        String username = usernameField.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username).apply();

        login(username);
    }

    public void login(String str) {
        Intent intent = new Intent(this, S2.class);

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", str).apply();

        startActivity(intent);
        finish();
    }
}
