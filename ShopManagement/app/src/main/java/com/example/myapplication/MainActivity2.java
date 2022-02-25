package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    DrawerLayout drawerLayout;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        drawerLayout = findViewById(R.id.drawer_layout);


    }

    public void clickMenu(View view)
    {
        openDrawer(drawerLayout);
    }

    private static  void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);

    }
    public void ClickLogo(View view)
    {
        closeDrawer(drawerLayout);
    }

    private  static void closeDrawer(DrawerLayout drawerLayout) {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        recreate();
    }
    public void ClickAddCust(View view){
        redirectActivity(this,Add_Cust_Activity.class);
    }
    public void ClickViewCustomer(View view){redirectActivity(this,show_cust.class);}
   // public void  ClickCheckStock(View view){redirectActivity(this,Check_Stock_Activity.class);}
    public void  ClickCheckStock(View view){redirectActivity(this,MainActivity3.class);}
   // public void  ClickAddStock(View view){redirectActivity(this,Add_Stock_Activity.class);}
    public void ClickAddWorker(View view){redirectActivity(this,MainActivity4.class);}
    public void ClickCheckWorker(View view){redirectActivity(this,ShowActivity.class);}



    private static void redirectActivity(Activity activity,Class aclass) {

        Intent intent = new Intent(activity,aclass);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

  //  public void Click_Add_List(View view){
       // redirectActivity(this,Add_List_Activity.class);
    //}
    //public void ClickViewList(View view){
        //redirectActivity(this,View_List_Activity.class);
    //}
    public void  ClickContacts(View view)
    {
        redirectActivity(this,Important_Contacts.class);
    }
}