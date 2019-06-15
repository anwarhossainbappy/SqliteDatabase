package bd.ac.cbiu.sqlite.sqlite.Activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bd.ac.cbiu.sqlite.sqlite.R;
import bd.ac.cbiu.sqlite.sqlite.adapter.Adapter;
import bd.ac.cbiu.sqlite.sqlite.adapter.DatabaseHelper;
import bd.ac.cbiu.sqlite.sqlite.model.model;

public class AllStudentActivity extends AppCompatActivity {

    ListView lv;
    DatabaseHelper mydatabasehelper;
    Adapter myadapter;
    ArrayList<model> listdata1;

    TextView error;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student);

        error =findViewById(R.id.error);
        lv = findViewById(R.id.mylistview);
        mydatabasehelper = new DatabaseHelper(this);
        customlistcall();

    }

    private void customlistcall() {

        listdata1 = new ArrayList<>();
        final Cursor cursor = mydatabasehelper.displayData();
        if (cursor.getCount() == 0)
        {
            /// no data found
        }
        else
        {
            while (cursor.moveToNext())
            {
                listdata1.add(new model(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)

                ));

            }
        }

        myadapter = new Adapter(this,listdata1);
        lv.setAdapter(myadapter);
        lv.setEmptyView(error);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"You Clicked on: "+position, Toast.LENGTH_LONG).show();

            }
        });



    }

}
