package cu.gd.mic.widget;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;

import cu.gd.mic.R;

public class FileClass extends FrameLayout implements View.OnClickListener {
    public String Url;
    DownloadManager dm;
    AppCompatTextView txt1, txt2, txt3;
    AppCompatImageButton imgbtn;
    public  FileClass(Context ctx, AttributeSet attrs){
        super(ctx, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.file_view, this, true);
        TypedArray attributes = ctx.obtainStyledAttributes(attrs, R.styleable.FileClass);
        Url=attributes.getString(R.styleable.FileClass_url);
        dm = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
        txt1 = findViewById(R.id.file_title);
        txt1.setText(attributes.getString(R.styleable.FileClass_ftitle));
        txt2 = findViewById(R.id.file_autor);
        txt2.setText(attributes.getString(R.styleable.FileClass_author));
        txt3 = findViewById(R.id.file_size);
        txt3.setText(attributes.getString(R.styleable.FileClass_size));
        imgbtn = findViewById(R.id.file_down);
        imgbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*
        if(v.getId() == R.id.file_down){
            Uri uri = Uri.parse(Url);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setTitle(txt1.getText());
            request.setDescription(txt2.getText());
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, txt1.getText().toString()+".pdf");
            dm.enqueue(request);
        }*/
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(Url));
        getContext().startActivity(i);
    }
}
