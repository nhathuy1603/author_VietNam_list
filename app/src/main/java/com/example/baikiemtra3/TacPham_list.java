package com.example.baikiemtra3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.ImageView;



public class TacPham_list extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    ListView listView1;

    String arrname1[] = {"Tập thơ \"Từ ấy\"", "Tập thơ \"Việt Bắc\"", "Tập thơ \"Gió lộng\"", "Bài thơ \"Bác ơi!\" ", "Bài thơ \"Hoan hô chiến sĩ Điện Biên\""};

    int arrimage1[] = {R.drawable.tuay, R.drawable.vietbac, R.drawable.giolong, R.drawable.img, R.drawable.hoanho};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tac_pham_list);

        listView1 = findViewById(R.id.listview1);
        myadapter adapter1 = new myadapter(this, arrname1, arrimage1);
        listView1.setAdapter(adapter1);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(TacPham_list.this,user_profile.class);
                intent.putExtra("name",arrname1[position]);
                intent.putExtra("image",arrimage1[position]);
                startActivity(intent);

            }
        });


    }

    class myadapter extends ArrayAdapter<String> {

        Context context;
        String rname1[];
        String rstragename1[];
        String rnation1[];
        int rimg1[];

        public myadapter( Context context, String[] rname,  int[] rimg) {
            super(context,R.layout.row1,R.id.imageView1,rname);

            this.rname1 = rname;
            this.rimg1 = rimg;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.row1,parent,false);

            ImageView img=view.findViewById(R.id.imageView1);
            TextView username=view.findViewById(R.id.name1);

            username.setText(rname1[position]);
            img.setImageResource(rimg1[position]);

            return view;
        }
    }

}
