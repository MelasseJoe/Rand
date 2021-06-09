package com.last.arnaud.rand;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity
{

    int i = 0;
    int max_rand = 101;

    Button random = null;
    Button reset = null;

    SeekBar barre = null;

    TextView appui = null;
    TextView result = null;
    TextView barre_value = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = (Button)findViewById(R.id.button);
        reset = (Button)findViewById(R.id.reset);
        result = (TextView)findViewById(R.id.result);
        appui = (TextView)findViewById(R.id.appui);
        barre = (SeekBar)findViewById(R.id.seekBar);
        barre_value = (TextView)findViewById(R.id.barre_value);

        random.setOnClickListener(randomListener);
        reset.setOnClickListener(resetListener);
        barre.setOnSeekBarChangeListener(barreListener);

    }

    private View.OnClickListener randomListener = new View.OnClickListener()
    {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(View v)
        {
            Random r = new Random();
            int rand = r.nextInt(max_rand);

            i = i + 1;
            appui.setText("Number of click : " + String.valueOf(i));

            int rgb = Color.HSVToColor(new float[]{rand, (float) 0.8, 1});

            result.setBackground(Drawable.createFromPath(""));
            result.setTextColor(rgb);
            result.setText(String.valueOf(rand));
        }
    };

    private View.OnClickListener resetListener = new View.OnClickListener()
    {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(View v)
        {
            result.setText(" ");
            result.setBackground(getResources().getDrawable(R.drawable.diceslogo));
            result.setTextColor(0xFFFFFFFF);
            appui.setText(" ");
            i=0;
            barre.setProgress(100);
        }
    };

    private SeekBar.OnSeekBarChangeListener barreListener = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            max_rand = progress + 1;
            barre_value.setText(String.valueOf(progress));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
