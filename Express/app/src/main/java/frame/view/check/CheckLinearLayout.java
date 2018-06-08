package frame.view.check;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import frame.view.alpha.AlphaLinearLayout;

/**
 * describe
 *
 * @author ikould on 2018/3/19.
 */
public class CheckLinearLayout extends AlphaLinearLayout {

    private boolean isChecked;

    public CheckLinearLayout(Context context) {
        super(context);
    }

    public CheckLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置Check状态
     */
    public void setCheck(boolean isChecked) {
        this.isChecked = isChecked;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof CheckImageView) {
                ((CheckImageView) view).setCheck(isChecked);
            } else if (view instanceof CheckTextView) {
                ((CheckTextView) view).setCheck(isChecked);
            }
        }
    }

    /**
     * 返回Check状态
     */
    public boolean isChecked() {
        return isChecked;
    }
}
