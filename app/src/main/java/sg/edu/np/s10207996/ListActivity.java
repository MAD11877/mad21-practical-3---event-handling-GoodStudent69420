package sg.edu.np.s10207996;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView profileImg = findViewById(R.id.profileImg);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListActivity.this);
        alertDialog.setTitle("Profile");
        alertDialog.setMessage("MADness");
        alertDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setPositiveButton("View", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Random rand = new Random();
                String theNum = "";
                for (int i = 0; i < 10; i++){
                    int ranInt = rand.nextInt(10);
                    theNum += String.valueOf(ranInt);
                }

                Intent in = new Intent(ListActivity.this, MainActivity.class);
                in.putExtra("idNum", theNum);
                startActivity(in);
            }
        });

        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
    }
}