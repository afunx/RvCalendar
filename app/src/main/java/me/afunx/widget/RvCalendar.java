package me.afunx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class RvCalendar extends View {

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

    public RvCalendar(Context context) {
        super(context);
    }

    public RvCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RvCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
}
