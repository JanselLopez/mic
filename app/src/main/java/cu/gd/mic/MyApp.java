package cu.gd.mic;

import com.activeandroid.ActiveAndroid;

public class MyApp extends com.activeandroid.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
