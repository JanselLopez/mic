package cu.gd.mic.principal_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cu.gd.mic.R;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
    }
    public  void showAcercaDe(View v){
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }

    public  void cerrarActivity(View v){
       finish();
    }
}
