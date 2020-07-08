package com.example.homework3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

public class ex2 extends AppCompatActivity {
    private View target;
    private View ColorPicker_1;
    private View ColorPicker_2;
    private Button DurationEditor;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        target = findViewById(R.id.target);
        ColorPicker_1 = findViewById(R.id.color_picker_1);
        ColorPicker_2 = findViewById(R.id.color_picker_2);
        DurationEditor = findViewById(R.id.duration_editor);

        DurationEditor.setText(String.valueOf(1000));
        DurationEditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(ex2.this)
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .input(getString(R.string.duration_hint), DurationEditor.getText(), new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                                onDurationChanged(input.toString());
                            }
                        })
                        .show();
            }
        });

        ColorPicker_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPicker picker = new ColorPicker(ex2.this);
                picker.setColor(getBackgroundColor(ColorPicker_1));
                picker.enableAutoClose();
                picker.setCallback(new ColorPickerCallback() {
                    @Override
                    public void onColorChosen(int color) {
                        ColorPicker_1.setBackgroundColor(color);
                        Animation_Replay();
                    }
                });
                picker.show();
            }
        });

        ColorPicker_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPicker picker = new ColorPicker(ex2.this);
                picker.setColor(getBackgroundColor(ColorPicker_2));
                picker.enableAutoClose();
                picker.setCallback(new ColorPickerCallback() {
                    @Override
                    public void onColorChosen(int color) {
                        ColorPicker_2.setBackgroundColor(color);
                        Animation_Replay();
                    }
                });
                picker.show();
            }
        });
        Animation_Replay();
    }

        private void onDurationChanged(String input) {
                int duration = Integer.parseInt(input);
                DurationEditor.setText(input);
                Animation_Replay();
        }

        private int getBackgroundColor(View view){
            Drawable bg = view.getBackground();
            if (bg instanceof ColorDrawable) {
                return ((ColorDrawable) bg).getColor();
            }
            return Color.WHITE;
        }

        private void Animation_Replay(){
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            int duration = Integer.parseInt(DurationEditor.getText().toString());
            ObjectAnimator animator1 = ObjectAnimator.ofArgb(target, "backgroundColor", getBackgroundColor(ColorPicker_1), getBackgroundColor(ColorPicker_2));
            animator1.setRepeatCount(ObjectAnimator.INFINITE);
            animator1.setRepeatMode(ObjectAnimator.REVERSE);
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(target, "scaleX", 1.0f, 1.8f);
            scaleX.setRepeatCount(ObjectAnimator.INFINITE);
            scaleX.setRepeatMode(ObjectAnimator.REVERSE);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(target, "scaleY", 1.0f, 1.8f);
            scaleY.setRepeatCount(ObjectAnimator.INFINITE);
            scaleY.setRepeatMode(ObjectAnimator.REVERSE);
            ObjectAnimator alpha = ObjectAnimator.ofFloat(target, "alpha", 1, 0.3f);
            alpha.setRepeatCount(ObjectAnimator.INFINITE);
            alpha.setRepeatMode(ObjectAnimator.REVERSE);
            animatorSet = new AnimatorSet();
            animatorSet.setDuration(duration);
            animatorSet.playTogether(animator1,scaleX,scaleY,alpha);
            animatorSet.start();
        }

    }

