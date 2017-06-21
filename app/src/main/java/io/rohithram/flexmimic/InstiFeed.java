package io.rohithram.flexmimic;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;




public class InstiFeed extends AppCompatActivity {
    RecyclerView rv_list;
    CardView cv_content;
    TextView tv_maindate;
    TextView tv_briefdes;
    TextView tv_des;
    Adapter customAdapter;
    List<String> cardcontent;
    List<String> carddate;
    List<String> cardtime;
    List<String> cardloc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);

        rv_list = (RecyclerView)findViewById(R.id.rv_list);
        rv_list.setItemAnimator(new DefaultItemAnimator());
        rv_list.setLayoutManager(new LinearLayoutManager(this));

        tv_briefdes = (TextView)findViewById(R.id.tv_briefdes);
        tv_maindate = (TextView)findViewById(R.id.tv_maindate);
        tv_des = (TextView)findViewById(R.id.tv_des);
        cv_content = (CardView)findViewById(R.id.cv_content);

        cardcontent = new ArrayList<>();
        carddate = new ArrayList<>();
        cardtime = new ArrayList<>();
        cardloc = new ArrayList<>();

        carddate.add("Thurs Jun 15,2017");
        carddate.add("Fri Jun 16,2017");
        carddate.add("Sat Jun 17,2017");
        carddate.add("Mon Jun 19,2017");
        carddate.add("Tues Jun 20,2017");
        carddate.add("Wed Jun 21,2017");

        cardtime.add("10.00 AM");
        cardtime.add("11.00 AM");
        cardtime.add("5.00 PM");
        cardtime.add("10.00 AM");
        cardtime.add("4.00 pM");
        cardtime.add("10.00 AM");

        cardloc.add("SAC");
        cardloc.add("CLT");
        cardloc.add("CRC 101");
        cardloc.add("HSB Hall");
        cardloc.add("ICSR");
        cardloc.add("CLT");


        cardcontent.add("UG/DD:TUM Summer School 'Engineering and Geodesy'");
        cardcontent.add("Mentor For Interns (MFI) 2017");
        cardcontent.add("Call for applications ||| Saathi Events Coordinators 2017-18");
        cardcontent.add("Atma Yoga classes");
        cardcontent.add("CSIE IIT Madras is Hiring - Call for Applications 2017-18");
        cardcontent.add("Endsem collection drive");





        customAdapter = new Adapter(this,cardcontent,carddate,cardtime,cardloc);
        rv_list.setAdapter(customAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spinner, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        return true;
    }
}
