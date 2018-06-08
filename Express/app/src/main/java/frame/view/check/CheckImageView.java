package frame.view.check;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.ikould.express.R;


/**
 * describe
 *
 * @author ikould on 2018/3/19.
 */

public class CheckImageView extends AppCompatImageView {

    private int     normalImgRes;
    private int     checkImgRes;
    private boolean isChecked;

    public CheckImageView(Context context) {
        super(context);
        init(context, null);
    }

    public CheckImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CheckImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.CheckImageView);
        checkImgRes = attrArray.getResourceId(R.styleable.CheckImageView_check_img, 0);
        normalImgRes = attrArray.getResourceId(R.styleable.CheckImageView_normal_img, 0);
        isChecked = attrArray.getBoolean(R.styleable.CheckImageView_is_img_checked, false);
        attrArray.recycle();
        setCheck(isChecked);
    }


    /**
     * 设置Check状态
     */
    public void setCheck(boolean isChecked) {
        this.isChecked = isChecked;
        if (isChecked && checkImgRes != 0) {
            setImageResource(checkImgRes);
        } else if (!isChecked && normalImgRes != 0) {
            setImageResource(normalImgRes);
        }
    }

    /**
     * 是否处于选中状态
     */
    public boolean isChecked() {
        return isChecked;
    }

}
