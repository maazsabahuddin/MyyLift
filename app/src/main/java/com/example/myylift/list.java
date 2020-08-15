package com.example.myylift;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class list extends ArrayAdapter<String> {

    private String [] start;

    private String [] driver;
    private String [] end ;
    private Activity context;
    public static String s;
    public static String d;
    public static String e;



    public list(Activity context,String [] start  , String [] driver , String [] end) {
        super(context, R.layout.listt,start);

        this.context=context;
        this.start=start;
        this.driver=driver;
        this.end=end;






    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;
        viewholder v=null;

        if (r== null)
        {
            LayoutInflater l = context.getLayoutInflater();
            r = l.inflate(R.layout.listt,null,true);

            v = new viewholder(r);
            r.setTag(v);

        }
        else
        {
            v = (viewholder) r.getTag();

        }

        v.star.setText(start[position]);
        v.driverrr.setText(driver[position]);
        v.en.setText(end[position]);

        s=v.star.getText().toString();
        d=v.driverrr.getText().toString();
        e=v.en.getText().toString();




        return r;



    }


    class viewholder {

        TextView star;
        TextView driverrr;
        TextView en;
        ;

        viewholder(View v){
            star= (TextView) v.findViewById(R.id.startt);
            driverrr =(TextView) v.findViewById(R.id.driveridd);
            en =(TextView) v.findViewById(R.id.endl);





        }
    }

}
