package com.example.exno3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.Path;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating a Bitmap
        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);

        // Setting the Bitmap as background for the ImageView
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setBackgroundDrawable(new BitmapDrawable(bg));

        // Creating the Canvas Object
        Canvas canvas = new Canvas(bg);

        // To draw an Ellipse
        Paint paintEllipse = new Paint();
        paintEllipse.setColor(Color.MAGENTA);
        paintEllipse.setTextSize(50);
        canvas.drawText("Ellipse", 420, 150, paintEllipse);
        canvas.drawOval(400, 200, 650, 700, paintEllipse);

        // To draw a Pentagon
        Paint paintPentagon = new Paint();
        paintPentagon.setColor(Color.CYAN);
        paintPentagon.setTextSize(50);
        canvas.drawText("Pentagon", 120, 150, paintPentagon);
        drawPentagon(canvas, 200, 350, 150, paintPentagon);

        // To draw a Diamond
        Paint paintDiamond = new Paint();
        paintDiamond.setColor(Color.rgb(255, 165, 0)); // Orange color
        paintDiamond.setTextSize(50);
        canvas.drawText("Diamond", 120, 800, paintDiamond);
        drawDiamond(canvas, 200, 1000, 150, paintDiamond);
    }

    private void drawPentagon(Canvas canvas, float centerX, float centerY, float radius, Paint paint) {
        float angle = (float) (Math.PI * 2 / 5);
        Path path = new Path();
        path.moveTo(centerX + radius * (float) Math.cos(0), centerY + radius * (float) Math.sin(0));
        for (int i = 1; i < 5; i++) {
            path.lineTo(centerX + radius * (float) Math.cos(angle * i), centerY + radius * (float) Math.sin(angle * i));
        }
        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawDiamond(Canvas canvas, float centerX, float centerY, float sideLength, Paint paint) {
        Path path = new Path();
        path.moveTo(centerX, centerY - sideLength); // Top
        path.lineTo(centerX + sideLength, centerY); // Right
        path.lineTo(centerX, centerY + sideLength); // Bottom
        path.lineTo(centerX - sideLength, centerY); // Left
        path.close();
        canvas.drawPath(path, paint);
    }
}
