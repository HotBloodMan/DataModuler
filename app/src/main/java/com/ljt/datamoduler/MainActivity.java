package com.ljt.datamoduler;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText message;
    private CheckBox age;
    private Button submit;
    private SharedPreferences formStore;

    boolean submitSuccess=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        message = (EditText) findViewById(R.id.message);
        age = (CheckBox) findViewById(R.id.age);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);

        formStore = getPreferences(Activity.MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        email.setText(formStore.getString("email",""));
        message.setText(formStore.getString("message",""));
        age.setChecked(formStore.getBoolean("age",false));

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(submitSuccess){
            formStore.edit().clear().commit();
        }else{
            SharedPreferences.Editor editor = formStore.edit();
            editor.putString("email",email.getText().toString());
            editor.putString("message",message.getText().toString());
            editor.putBoolean("age",age.isChecked());
            editor.commit();
        }
    }

    @Override
    public void onClick(View view) {
        submitSuccess=true;
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
