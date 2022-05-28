package sg.edu.c346.id21010771.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtHeader;
    ImageView imgBanks;

    ImageView imgDBS;
    TextView txtDBS;

    ImageView imgOCBC;
    TextView txtOCBC;

    ImageView imgUOB;
    TextView txtUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHeader = findViewById(R.id.tvHeader);
        imgBanks = findViewById(R.id.ivBanks);

        imgDBS = findViewById(R.id.ivDBS);
        txtDBS = findViewById(R.id.tvDBS);

        imgOCBC = findViewById(R.id.ivOCBC);
        txtOCBC = findViewById(R.id.tvOCBC);

        imgUOB = findViewById(R.id.ivUOB);
        txtUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(txtDBS);
        registerForContextMenu(txtOCBC);
        registerForContextMenu(txtUOB);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");
    }

    @Override
    public boolean onContextItemSelected(MenuItem itemDBS) {
        if(itemDBS.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Intent dbsWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(dbsWeb);

            return true; //menu item successfully handled
        }
        else if(itemDBS.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Intent dbsDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18001111111l));
            startActivity(dbsDial);

            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(itemDBS); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            txtHeader.setText("Choose Bank");
            txtDBS.setText("DBS ");
            txtOCBC.setText("OCBC ");
            txtUOB.setText("UOB ");

            return true;
        } else if (id == R.id.chineseSelection) {
            txtHeader.setText("选择银行");
            txtDBS.setText("星展银行");
            txtOCBC.setText("华侨银行 ");
            txtUOB.setText("大华银行 ");
            return true;

        } else if (id == R.id.toggleFavourite) {
            txtDBS.setTextColor(#000000);
            return true;
        } else {
            txtHeader.setText("Error Translation");
            txtDBS.setText("Error translation");
            txtOCBC.setText("Error translation");
            txtUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
    
}