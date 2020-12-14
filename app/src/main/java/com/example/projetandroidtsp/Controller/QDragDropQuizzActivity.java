package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetandroidtsp.R;

public class QDragDropQuizzActivity extends AppCompatActivity {

    private Button rep1;
    private Button rep2;
    private Button rep3;
    private Button rep4;
    private TextView adrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_drag_drop_quizz);
        rep1=(Button)findViewById(R.id.rep1_drop);
        rep1.setOnTouchListener(new MyTouchListener());
        rep2=(Button)findViewById(R.id.rep2_drop);
        rep2.setOnTouchListener(new MyTouchListener());
        rep3=(Button)findViewById(R.id.rep3_drop);
        rep3.setOnTouchListener(new MyTouchListener());
        rep4=(Button)findViewById(R.id.rep4_drop);
        rep4.setOnTouchListener(new MyTouchListener());
        adrop=(TextView) findViewById(R.id.lieudrop);
        findViewById(R.id.adrop).setOnDragListener(new MyDragListener());
        findViewById(R.id.dropa).setOnDragListener(new MyDragListener());

    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }
}