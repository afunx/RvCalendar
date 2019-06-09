package me.afunx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class RvCalendar extends RelativeLayout {

    private static final String TAG = "RvCalendar";
    private static final boolean DEBUG = true;

    private float mToolbarHeight;

    private float mWeekHeight;

    private float mMonthHeight;

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.calendar);
        mToolbarHeight = typedArray.getDimension(R.styleable.calendar_toolbar_height, 0);
        mWeekHeight = typedArray.getDimension(R.styleable.calendar_week_height, 0);
        mMonthHeight = typedArray.getDimension(R.styleable.calendar_month_height, 0);
        typedArray.recycle();
        if (DEBUG) {
            Log.d(TAG, "toolbarHeight: " + mToolbarHeight + ", weekHeight: " + mWeekHeight + ", monthHeight: " + mMonthHeight);
        }
    }

    private void inflate(Context context) {
        LayoutInflater.from(context).inflate(R.layout.rv_calendar_layout, this);
    }

    public RvCalendar(Context context) {
        super(context);
        inflate(context);
    }

    public RvCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        inflate(context);
    }

    public RvCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        inflate(context);
    }
}

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//@Override
//public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//        super.onScrollStateChanged(recyclerView, newState);
//        String newStateStr = null;
//        switch (newState) {
//        case RecyclerView.SCROLL_STATE_IDLE:
//        newStateStr = "SCROLL_STATE_IDLE";
//
//        int offset = recyclerView.computeVerticalScrollOffset();
//        int extent = recyclerView.computeVerticalScrollExtent();
//        int range = recyclerView.computeVerticalScrollRange();
//
//        int minPosition = 0;
//        int maxPosition = range / extent;
//        int position = (offset + extent/3) / extent;
//        recyclerView.smoothScrollToPosition(position);
//
//        break;
//        case RecyclerView.SCROLL_STATE_DRAGGING:
//        newStateStr = "SCROLL_STATE_DRAGGING";
//        break;
//        case RecyclerView.SCROLL_STATE_SETTLING:
//        newStateStr = "SCROLL_STATE_SETTLING";
//        break;
//        }
//        Log.e(TAG, "onScrollStateChanged() newState: " + newStateStr);
//        Log.e(TAG, "onScrollStateChanged() offset: " + recyclerView.computeVerticalScrollOffset());
//        Log.e(TAG, "onScrollStateChanged() extent: " + recyclerView.computeVerticalScrollExtent());
//        Log.e(TAG, "onScrollStateChanged() range: " + recyclerView.computeVerticalScrollRange());
//        }
//
//@Override
//public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//        super.onScrolled(recyclerView, dx, dy);
//        Log.e(TAG, "onScrolled() dx: " + dx + ", dy: " + dy);
//        }
//        });