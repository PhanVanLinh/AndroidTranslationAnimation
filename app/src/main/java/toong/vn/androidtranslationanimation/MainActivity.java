package toong.vn.androidtranslationanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final long DURATION_FAST = 200;
    private Button buttonStart;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.button_start);
        imageView = findViewById(R.id.imageView);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upAndAlphaWithEndAction(imageView, 1f, 500f, DURATION_FAST, new Runnable() {
                    @Override
                    public void run() {
                        downAndAlphaWithEndAction(imageView, 0f, 0, DURATION_FAST, new Runnable() {
                            @Override
                            public void run() {
                                imageView.animate().alpha(1).setDuration(DURATION_FAST).start();
                            }
                        });
                    }
                });
            }
        });
    }

    private void upAndAlphaWithEndAction(View
            view, float alpha, float translation, long duration,
            Runnable endAction) {
        view.animate()
                .alpha(alpha)
                .setDuration(duration)
                .translationY(-translation)
                .withEndAction(endAction)
                .start();
    }

    private void downAndAlphaWithEndAction(View view, float alpha, float translation, long duration,
            Runnable endAction) {
        view.animate()
                .alpha(alpha)
                .setDuration(duration)
                .translationY(translation)
                .withEndAction(endAction)
                .start();
    }
}
