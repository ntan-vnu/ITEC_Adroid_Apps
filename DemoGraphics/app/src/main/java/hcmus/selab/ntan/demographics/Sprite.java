package hcmus.selab.ntan.demographics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Sprite extends View {
    private int[] frame_ids = {
            R.drawable.bmp_000,
            R.drawable.bmp_001,
            R.drawable.bmp_002,
            R.drawable.bmp_003,
            R.drawable.bmp_004,
            R.drawable.bmp_005,
            R.drawable.bmp_006,
            R.drawable.bmp_007,
            R.drawable.bmp_008,
            R.drawable.bmp_009,
            R.drawable.bmp_010,
            R.drawable.bmp_011,
            R.drawable.bmp_012,
            R.drawable.bmp_013,
    };
    private int index = 0;
    private CountDownTimer countDownTimer;

    public Sprite(Context context,
                  @Nullable AttributeSet attrs) {
        super(context, attrs);
        countDownTimer = new CountDownTimer(5000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                update();
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
    }

    private void update() {
        move();
        invalidate();
    }

    private void move() {
        float x = getX()+3;
        float y = x*x;
        setX(x);
        setY(y);
    }

    public void startAnimation() {
        countDownTimer.start();
    }

    public void stopAnimation() {
        countDownTimer.cancel();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bmp = BitmapFactory.decodeResource(
                getResources(), frame_ids[index]
        );
        index = (index+1) % frame_ids.length;
        canvas.drawBitmap(bmp, 0, 0, null);
    }
}
