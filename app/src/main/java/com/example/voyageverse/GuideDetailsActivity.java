package com.example.voyageverse;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GuideDetailsActivity extends AppCompatActivity {

    private TextView guideDetailsTextView;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_details);

        guideDetailsTextView = findViewById(R.id.guideDetailsTextView);

        dbHelper = new DatabaseHelper(this);


        displayGuideDetails();
    }

    private void displayGuideDetails() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_EMAIL,
                DatabaseHelper.COLUMN_AREA
                // Add other columns as needed
        };

        Cursor cursor = db.query(
                DatabaseHelper.TABLE_PROFILE,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        StringBuilder details = new StringBuilder();

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_EMAIL));
            String area = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_AREA));

            details.append("Name: ").append(name).append(", Phone: ").append(email).append(", Area: ").append(area).append("\n");

        }

        cursor.close();
        db.close();


        guideDetailsTextView.setText(details.toString());
    }
}
