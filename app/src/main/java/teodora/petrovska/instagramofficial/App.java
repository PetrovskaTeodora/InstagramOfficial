package teodora.petrovska.instagramofficial;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("DzSNr50EnHzLX3BhRZMx4CPSyDS1VtFaY8BP9f9j")
                // if defined
                .clientKey("OoOCHvvl26ysTozpfdP9095pfDhiJBP4PGB2PKpW")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
