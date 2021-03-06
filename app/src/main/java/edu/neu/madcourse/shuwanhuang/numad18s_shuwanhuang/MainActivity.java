package edu.neu.madcourse.shuwanhuang.numad18s_shuwanhuang;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayVersionInfo();
    }

    private void displayVersionInfo() {
        String versionName = "";
        int versionCode = 1;
        try {
            versionName = getApplicationContext()
                            .getPackageManager().getPackageInfo(getApplicationContext()
                            .getPackageName(), 0).versionName;
            versionCode = getApplicationContext()
                    .getPackageManager().getPackageInfo(getApplicationContext()
                            .getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        TextView textView1 = findViewById(R.id.textView1);
        String text1 = "Version Code: " + versionCode;
        textView1.setText(text1);

        TextView textView2 = findViewById(R.id.textView2);
        String text2 = "Version Name: " + versionName;
        textView2.setText(text2);
    }

    /**
     * Called when the user taps the About button.
     * @param view the View object that was clicked
     */
    public void onClickAbout(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the Generate Error button.
     * @param view the View object that was clicked
     */
    public void onClickGenerateError(View view) {
        String testLabSetting =
                Settings.System.getString(getContentResolver(), "firebase.test.lab");
        if (testLabSetting != null && "true".equals(testLabSetting)) {
            TextView error = findViewById(R.id.error);
            error.setVisibility(View.VISIBLE);
        } else {
            throw new RuntimeException("This is a crash");
        }
    }

    /**
     * Called when the user taps the Dictionary button.
     * @param view the View object that was clicked
     */
    public void onClickDictionary(View view) {
        Intent intent = new Intent(this, DictionaryActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the Word Game button.
     * @param view the View object that was clicked
     */
    public void onClickWordGame(View view) {
        Intent intent = new Intent(
                this,
                edu.neu.madcourse.shuwanhuang.numad18s_shuwanhuang.wordgame.MainActivity.class);
        startActivity(intent);
    }
}
