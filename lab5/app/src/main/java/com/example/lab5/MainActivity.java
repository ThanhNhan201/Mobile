package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode, btnBlinkXml,
            btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml, btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode, btnBounceXml,
            btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }

    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }

    private void handleClickAnimationXml(Button btn, int animId)
    {
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, animId);

        animation.setAnimationListener(animationListener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }

    private void handleClickAnimationCode(Button btn, final Animation animation) {

        // Handle onclickListenner to start animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });

    }

    private Animation initFadeOutAnimation() {
        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initFadeInAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initBlinkAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(250);
        animation.setRepeatMode(animation.REVERSE);
        animation.setRepeatCount(3);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initZoomInAnimation() {
        Animation animation = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initZoomOutAnimation() {
        Animation animation = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initRotateAnimation() {
        Animation animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initMoveAnimation() {
        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initSlideUpAnimation() {
        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initBounceAnimation() {
        AnimationSet animationSet = new AnimationSet(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1.0f, 1.0f,   // Start and end scale for the width
                0.0f, 1.0f,   // Start and end scale for the height
                Animation.RELATIVE_TO_SELF, 0.5f,   // Pivot point (X-axis)
                Animation.RELATIVE_TO_SELF, 0.5f    // Pivot point (Y-axis)
        );
        scaleAnimation.setDuration(500); // Duration of the animation in milliseconds

        animationSet.addAnimation(scaleAnimation);

        return animationSet;
    }


    private Animation initCombinedAnimation() {
        AnimationSet animationSet = new AnimationSet(true);

        // Scale Animation
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1.0f, 3.0f,   // Start and end scale for the width
                1.0f, 3.0f,   // Start and end scale for the height
                Animation.RELATIVE_TO_SELF, 0.5f,   // Pivot point (X-axis)
                Animation.RELATIVE_TO_SELF, 0.5f    // Pivot point (Y-axis)
        );
        scaleAnimation.setDuration(4000); // Duration of the scale animation in milliseconds

        // Rotate Animation
        RotateAnimation rotateAnimation = new RotateAnimation(
                0.0f, 360.0f,   // Start and end rotation angles
                Animation.RELATIVE_TO_SELF, 0.5f,   // Pivot point (X-axis)
                Animation.RELATIVE_TO_SELF, 0.5f    // Pivot point (Y-axis)
        );
        rotateAnimation.setDuration(500); // Duration of the rotate animation in milliseconds
        rotateAnimation.setRepeatCount(2); // Number of times the rotation should repeat
        rotateAnimation.setRepeatMode(Animation.RESTART); // Repeat mode for the rotation animation

        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);

        return animationSet;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();

        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);


        // HandleClickAnimationCode
        handleClickAnimationCode(btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode, initFadeOutAnimation());
        handleClickAnimationCode(btnBlinkCode, initBlinkAnimation());
        handleClickAnimationCode(btnZoomInCode, initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode, initZoomOutAnimation());
        handleClickAnimationCode(btnRotateCode, initRotateAnimation());
        handleClickAnimationCode(btnMoveCode, initMoveAnimation());
        handleClickAnimationCode(btnSlideUpCode, initSlideUpAnimation());
        handleClickAnimationCode(btnBounceCode, initBounceAnimation());
        handleClickAnimationCode(btnCombineCode, initCombinedAnimation());

    }

}
