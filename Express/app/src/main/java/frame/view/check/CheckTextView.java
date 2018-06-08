package frame.view.check;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.ikould.express.R;


/**
 * describe
 * Created by ikould on 2018/3/19.
 */

public class CheckTextView extends AppCompatTextView {

    private int     normalColor;
    private int     checkColor;
    private boolean isChecked;

    public CheckTextView(Context context) {
        super(context);
        init(context, null);
    }

    public CheckTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CheckTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.CheckTextView);
        checkColor = attrArray.getColor(R.styleable.CheckTextView_check_color, 0xffffffff);
        normalColor = attrArray.getColor(R.styleable.CheckTextView_normal_color, 0xffffffff);
        isChecked = attrArray.getBoolean(R.styleable.CheckTextView_is_text_checked, false);
        attrArray.recycle();
        setCheck(isChecked);
    }

    /**
     * 设置Check状态
     */
    public void setCheck(boolean isChecked) {
        this.isChecked = isChecked;
        if (isChecked) {
            setTextColor(checkColor);
        } else {
            setTextColor(normalColor);
        }
    }

    /**
     * 是否处于选中状态
     */
    public boolean isChecked() {
        return isChecked;
    }
}
