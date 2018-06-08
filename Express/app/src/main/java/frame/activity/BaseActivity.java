package frame.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.adnonstop.frame.activity.FrameActivity;
import com.adnonstop.frame.util.KeyBoardUtils;
import com.ikould.express.R;

/**
 * describe
 * Created by ikould on 2018/6/5.
 */
public abstract class BaseActivity extends FrameActivity {

    /**
     * 更换Fragment
     */
    public void replaceFragment(int id, Fragment fragment, boolean isDoAnim) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (isDoAnim) {
            fragmentTransaction.setCustomAnimations(R.anim.anim_in_right, R.anim.anim_out_left);
        }
        fragmentTransaction.replace(id, fragment);
        KeyBoardUtils.closeKeyboard(this);
        try {
            fragmentTransaction.commitNow();
        } catch (Exception e) {
            fragmentTransaction.commitAllowingStateLoss();
        }
    }
}
