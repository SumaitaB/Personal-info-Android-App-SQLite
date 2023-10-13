package com.example.labfinal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText registrationEditText;
    private EditText phoneEditText;
    private EditText adressEditText;
    private EditText emailEditText;
    private EditText passwordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        firstNameEditText = findViewById(R.id.fnid);
        lastNameEditText = findViewById(R.id.lnid);
        registrationEditText = findViewById(R.id.regid);
        phoneEditText = findViewById(R.id.pnid);
        adressEditText = findViewById(R.id.adrsid);
        emailEditText = findViewById(R.id.mailid);
        passwordEditText = findViewById(R.id.passid);

        Button saveButton = findViewById(R.id.saveid);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });



    }

    private void saveData() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserDataContract.UserDataEntry.COLUMN_FIRST_NAME, firstNameEditText.getText().toString());
        values.put(UserDataContract.UserDataEntry.COLUMN_LAST_NAME, lastNameEditText.getText().toString());
        values.put(UserDataContract.UserDataEntry.COLUMN_REGISTRATION_NO, registrationEditText.getText().toString());
        values.put(UserDataContract.UserDataEntry.COLUMN_PHONE_NO, phoneEditText.getText().toString());
        values.put(UserDataContract.UserDataEntry.COLUMN_ADDRESS, adressEditText.getText().toString());
        values.put(UserDataContract.UserDataEntry.COLUMN_USER_EMAIL, emailEditText.getText().toString());
        values.put(UserDataContract.UserDataEntry.COLUMN_PASSWORD, passwordEditText.getText().toString());
        // Add values for other data fields

        long newRowId = db.insert(UserDataContract.UserDataEntry.TABLE_NAME, null, values);

        if (newRowId != -1) {
            // Data inserted successfully
            showToast("Data saved successfully");
        } else {
            // Error occurred during insertion
            showToast("Failed to save data");
        }
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

