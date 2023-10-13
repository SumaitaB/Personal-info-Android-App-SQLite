package com.example.labfinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class DisplayDataActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        dbHelper = new DBHelper(this);
        listView = findViewById(R.id.listView);

        // Retrieve data from the database
        Cursor cursor = getDataFromDatabase();

        // Specify the columns you want to display
        String[] fromColumns = {
                UserDataContract.UserDataEntry.COLUMN_FIRST_NAME,
                UserDataContract.UserDataEntry.COLUMN_LAST_NAME,
                UserDataContract.UserDataEntry.COLUMN_REGISTRATION_NO,
                UserDataContract.UserDataEntry.COLUMN_PHONE_NO,
                UserDataContract.UserDataEntry.COLUMN_USER_EMAIL,
                UserDataContract.UserDataEntry.COLUMN_ADDRESS,
                // Add other column names here
        };

        // Specify the View IDs in the layout
        int[] toViews = {
                R.id.tvfn,
                R.id.tvln,
                R.id.tvreg,
                R.id.tvpn,
                R.id.tvmail,
                R.id.tvadrs,
                // Add other TextView IDs here
        };

        // Create a SimpleCursorAdapter to display the data
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, fromColumns, toViews, 0);

        listView.setAdapter(adapter);
    }

    private Cursor getDataFromDatabase() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define the columns you want to retrieve (you can also use null for all columns)
        String[] projection = {
                UserDataContract.UserDataEntry.COLUMN_FIRST_NAME,
                UserDataContract.UserDataEntry.COLUMN_LAST_NAME,
                UserDataContract.UserDataEntry.COLUMN_REGISTRATION_NO,
                UserDataContract.UserDataEntry.COLUMN_PHONE_NO,
                UserDataContract.UserDataEntry.COLUMN_USER_EMAIL,
                UserDataContract.UserDataEntry.COLUMN_ADDRESS,
                // Add other column names here
        };

        // You can add conditions or sorting as needed
        String sortOrder = UserDataContract.UserDataEntry.COLUMN_FIRST_NAME + " ASC";

        return db.query(
                UserDataContract.UserDataEntry.TABLE_NAME,  // The table to query
                projection,                             // The columns to return
                null,                                   // The columns for the WHERE clause
                null,                                   // The values for the WHERE clause
                null,                                   // Don't group the rows
                null,                                   // Don't filter by row groups
                sortOrder                                // The sort order
        );
    }
}

