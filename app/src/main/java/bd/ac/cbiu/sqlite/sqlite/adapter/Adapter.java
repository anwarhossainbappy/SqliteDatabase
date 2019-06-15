package bd.ac.cbiu.sqlite.sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.ArrayList;

import bd.ac.cbiu.sqlite.sqlite.R;
import bd.ac.cbiu.sqlite.sqlite.model.model;

public class Adapter extends ArrayAdapter<model> {


    private Context context;
    private ArrayList<model> person;

    public Adapter(Context context, ArrayList<model> person)  {
        super(context, R.layout.custom_layout_custom, person);
        this.context = context;
        this.person = person;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.custom_layout_custom,parent,false);
        TextView t0 = convertView.findViewById(R.id.mytextviews0);
        TextView t1 = convertView.findViewById(R.id.mytextviews1);
        TextView t2 = convertView.findViewById(R.id.mytextviews2);
        TextView t3 = convertView.findViewById(R.id.mytextviews3);

        t0.setText(person.get(position).getId());
        t1.setText("Name: "+person.get(position).getName());
        t2.setText("Batch: "+person.get(position).getBatch()+"th");
        t3.setText("Student ID: "+person.get(position).getStudent_id());

        return convertView;
    }
}
