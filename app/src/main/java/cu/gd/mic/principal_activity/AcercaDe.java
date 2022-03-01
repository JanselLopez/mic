package cu.gd.mic.principal_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;

import cu.gd.mic.R;

public class AcercaDe extends AppCompatActivity {

    AppCompatTextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        tv1 = findViewById(R.id.acerca_de_link);
        tv1.setMovementMethod(LinkMovementMethod.getInstance());
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:micapk2022@gmail.com?subject=Lo contacto por"));
                startActivity(i);
            }
        });
    }
}
