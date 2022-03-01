package cu.gd.mic.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SwitchCompat;

import cu.gd.mic.R;

public class ConfigurationItem extends LinearLayoutCompat {
    AppCompatTextView titleView, descriptionView;
    SwitchCompat optionView;
    public ConfigurationItem(Context ctx, @Nullable AttributeSet attrs){
        super(ctx, attrs);
        TypedArray attributes = ctx.obtainStyledAttributes(attrs, R.styleable.ConfigurationItem);
        LayoutInflater.from(getContext()).inflate(R.layout.configuration_item, this, true);
        titleView=(AppCompatTextView)findViewById(R.id.configuration_item_title);
        descriptionView=(AppCompatTextView)findViewById(R.id.configuration_item_description);
        optionView=(SwitchCompat)findViewById(R.id.configuration_item_option);
        try{
            String title = attributes.getString(R.styleable.ConfigurationItem_title);
            String description = attributes.getString(R.styleable.ConfigurationItem_description);
            boolean state = attributes.getBoolean(R.styleable.ConfigurationItem_state, false);
            setTitle(title);
            setDescription(description);
            setOption(state);
        }catch (Exception e){

        }
    }
    public void setTitle(String title){
        titleView.setText(title);
    }
    public String getTitle(){
        return titleView.getText().toString();
    }
    public void setDescription(String description){
        descriptionView.setText(description);
    }
    public String getDescription(){
        return descriptionView.getText().toString();
    }
    public void setOption(boolean option){
        optionView.setChecked(option);
    }
    public boolean getOption(){
        return optionView.isChecked();
    }

}
