package com.example.homework3;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
public class ex1 extends AppCompatActivity {
    private LottieAnimationView animationView;
    private CheckBox CheckBox;
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);
        animationView = findViewById(R.id.animation_view);
        CheckBox = findViewById(R.id.checkbox);
        seekBar = findViewById(R.id.seekbar);
        CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    animationView.playAnimation();
                    seekBar.setEnabled(false);
                } else {
                    animationView.pauseAnimation();
                    seekBar.setEnabled(true);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                animationView.setProgress((progress+0.0f)/seekBar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
