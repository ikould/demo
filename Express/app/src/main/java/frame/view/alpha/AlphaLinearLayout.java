package frame.view.alpha;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.ikould.express.R;


/**
 * describe
 * Created by liudong on 2017/8/24.
 */

public class AlphaLinearLayout extends LinearLayout {

    private float   touchAlpha;
    private float   disabledAlpha;
    private boolean isUseEnable;
    private boolean isEnable = true;

    public AlphaLinearLayout(Context context) {
        super(context);
        init(context, null);
    }

    public AlphaLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AlphaLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.AlphaView);
        touchAlpha = attrArray.getFloat(R.styleable.AlphaView_TouchAlpha, 0.4f);
        disabledAlpha = attrArray.getFloat(R.styleable.AlphaView_DisabledAlpha, 0.2f);
        isUseEnable = attrArray.getBoolean(R.styleable.AlphaView_UseEnable, true);
        attrArray.recycle();
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        isEnable = b;
        if (isUseEnable) {
            if (isEnable) {
                setChildAlpha(1.0f);
            } else {
                setChildAlpha(disabledAlpha);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnable) {
            return super.onTouchEvent(event);
        }
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                setChildAlpha(touchAlpha);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            // 手指离开屏幕时将临时值还原
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                setChildAlpha(1.0f);
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 设置子View的Alpha值
     */
    private void setChildAlpha(float alpha) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setAlpha(alpha);
        }
    }
}
