package bd.ac.cbiu.sqlite.sqlite.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bd.ac.cbiu.sqlite.sqlite.R;
import bd.ac.cbiu.sqlite.sqlite.adapter.DatabaseHelper;

public class UpdateData extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Button Update;
    EditText id,name,s_id,batch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Update = findViewById(R.id.update);
        id = findViewById(R.id.id);
        name = findViewById(R.id.studentname);
        s_id = findViewById(R.id.studentid);
        batch = findViewById(R.id.studentbatch);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id = id.getText().toString();
                String Name = name.getText().toString();
                String sid= s_id.getText().toString();
                String Batch= batch.getText().toString();

                Boolean isUpdated = databaseHelper.UpdateData(Id,Name,sid,Batch);
                if (isUpdated == true)
                {
                    Toast.makeText(getApplicationContext(),"DATA UPDATED SUCCEFULLY",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateData.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"DATA NOT UPDATED",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
