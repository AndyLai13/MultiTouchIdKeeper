package com.andylai.multitouchidkeeper;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CanvasView extends FrameLayout {
    private static final int MAX_COUNT = 10;
    private final MultiTouchIdKeeper ids = new MultiTouchIdKeeper(MAX_COUNT);

    public CanvasView(@NonNull Context context) {
        super(context);
    }

    public CanvasView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Andy", "ACTION_DOWN");
                ids.actionDown(event);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.d("Andy", "ACTION_POINTER_DOWN");
                ids.actionPointerDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
//				Log.d("Andy", "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.d("Andy", "ACTION_POINTER_UP");
                ids.actionPointerUp(event);
                break;
            case MotionEvent.ACTION_UP:
                Log.d("Andy", "ACTION_UP");
                ids.actionUp(event);
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("Andy", "ACTION_CANCEL");
                break;
        }
        return true;
    }
}
