package cu.gd.mic.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import cu.gd.mic.R;

public class Autor extends LinearLayoutCompat {
    private AppCompatImageView img;
    private AppCompatTextView txt1, txt2;
    public Autor(Context ctx, AttributeSet attrs){
        super(ctx,attrs);
        TypedArray attributes = ctx.obtainStyledAttributes(attrs, R.styleable.Autor);
        LayoutInflater.from(getContext()).inflate(R.layout.autor_view, this, true);
        img = findViewById(R.id.autor_img);
        txt1 = findViewById(R.id.autor_name);
        txt2 = findViewById(R.id.autor_cargo);
        setImage(attributes.getInt(R.styleable.Autor_img, R.drawable.estrella));
        setName(attributes.getString(R.styleable.Autor_nombre));
        setCargo(attributes.getString(R.styleable.Autor_cargo));
    }

    public Drawable getImage(){
        return img.getDrawable();
    }
    public void setImage(Drawable drawable){
        img.setImageDrawable(drawable);
    }
    public void setImage(int resource){
        img.setImageDrawable(getResources().getDrawable(resource));
    }
    public String getName(){
        return txt1.getText().toString();
    }
    public void setName(String name){
        txt1.setText(name);
    }
    public String getCargo(){
        return txt2.getText().toString();
    }
    public  void setCargo(String cargo){
        txt2.setText(cargo);
    }
}
