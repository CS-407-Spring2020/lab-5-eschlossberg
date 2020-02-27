package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        EditText usernameField = (EditText) findViewById(R.id.text_username);
        String username = usernameField.getText().toString();
        login(username);
    }

    public void login(String str) {
        Intent intent = new Intent(this, S2.class);
        intent.putExtra("username", str);
        startActivity(intent);
        finish();
    }
}
