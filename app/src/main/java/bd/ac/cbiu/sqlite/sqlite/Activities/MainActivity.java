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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper databaseHelper;
    private EditText NAME, SID,BATCH;
    private Button SAVE,VIEW,UPDATE,DELETE;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        NAME = findViewById(R.id.studentname);
        SID = findViewById(R.id.studentid);
        BATCH = findViewById(R.id.studentbatch);
        SAVE = findViewById(R.id.insertbutton);
        VIEW = findViewById(R.id.viewbutton);
        UPDATE = findViewById(R.id.updatebutton);
        DELETE = findViewById(R.id.deletebutton);

        SAVE.setOnClickListener(this);
        VIEW.setOnClickListener(this);
        UPDATE.setOnClickListener(this);
        DELETE.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {

        String name = NAME.getText().toString();
        String sid = SID.getText().toString();
        String batch = BATCH.getText().toString();
        if (v.getId()==R.id.insertbutton)
        {

                if (name.isEmpty() || sid.isEmpty() || batch.isEmpty())
                {
                  Toast.makeText(getApplicationContext(),"All fields Must be Fill Up",Toast.LENGTH_SHORT).show();
                }else if (sid.length()!=12)
                    {
                        Toast.makeText(this, "Student Id must be 12 Digit", Toast.LENGTH_SHORT).show();
                    }
                else {
                    long rowId=  databaseHelper.insertData(name,batch,sid);

                    if (rowId == -1) {
                        Toast.makeText(this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Data Inserted Successfuly", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,AllStudentActivity.class));
                    }
                }
        }
        else if (v.getId()==R.id.viewbutton) {
           startActivity(new Intent(MainActivity.this,AllStudentActivity.class));
        }
        else if(v.getId()==R.id.updatebutton)
        {
            startActivity(new Intent(MainActivity.this, UpdateData.class));
        }
        else if (v.getId()==R.id.deletebutton)
        {
            startActivity(new Intent(MainActivity.this, DeleteData.class));
        }

    }


}

