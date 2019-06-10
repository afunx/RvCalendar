package me.afunx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RvCalendar extends RelativeLayout {

    private static final String TAG = "RvCalendar";
    private static final boolean DEBUG = true;

    private RelativeLayout mToolbar;
    private ImageView mImgToolbar;
    private TextView mTitleToolbar;
    private TextView mEndToolbar;

    private LinearLayout mLinearLayoutWeek;

    private TextView mTvMonth;

    private RecyclerView mRvDay;

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

        ViewGroup.LayoutParams layoutParams = mToolbar.getLayoutParams();
        layoutParams.height = (int) mToolbarHeight;
        mToolbar.setLayoutParams(layoutParams);

        layoutParams = mImgToolbar.getLayoutParams();
        layoutParams.width = (int) mToolbarHeight;
        mImgToolbar.setLayoutParams(layoutParams);

        layoutParams = mLinearLayoutWeek.getLayoutParams();
        layoutParams.height = (int) mWeekHeight;
        mLinearLayoutWeek.setLayoutParams(layoutParams);

        layoutParams = mTvMonth.getLayoutParams();
        layoutParams.height = (int) mMonthHeight;
        mTvMonth.setLayoutParams(layoutParams);
    }

    private void inflate(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_calendar_layout, this);

        mToolbar = view.findViewById(R.id.toolbar_rv_calendar);
        mImgToolbar = view.findViewById(R.id.img_rv_calendar);
        mTitleToolbar = view.findViewById(R.id.tv_title_rv_calendar);
        mEndToolbar = view.findViewById(R.id.tv_title_end_rv_calendar);

        mLinearLayoutWeek = view.findViewById(R.id.ll_week_rv_calendar);

        mTvMonth = view.findViewById(R.id.tv_month_rv_calendar);

        mRvDay = view.findViewById(R.id.rv_day_rv_calendar);
    }

    public RvCalendar(Context context) {
        super(context);
        inflate(context);
    }

    public RvCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
        init(context, attrs);
    }

    public RvCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
        init(context, attrs);
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