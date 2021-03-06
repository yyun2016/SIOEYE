package cn.testcase.setting;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.squareup.spoon.Spoon;

import org.hamcrest.Asst;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import ckt.annotation.PerformanceTest;
import ckt.annotation.SanityTest;
import ckt.base.VP2;
import cn.action.AccountAction;
import cn.action.MeAction;
import cn.page.App;
import cn.page.MePage;

/**
 * Created by elon on 2016/11/16.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 16)
public class SexCase extends VP2 {
    Logger logger = Logger.getLogger(SexCase.class.getName());
    @Before
    public  void setup() throws UiObjectNotFoundException {
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_CN);
        AccountAction.inLogin();
    }
    @Test
    @SanityTest
    @PerformanceTest
    public void testMale() throws UiObjectNotFoundException {
        //修改性别为-male
        MeAction.navToSex();
        clickById(MePage.SETTINGS_SEX_MALE);
        waitUntilGone(MePage.SETTINGS_SEX_MALE,10000);
        //验证
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_CN);
        MeAction.navToSex();
        gDevice.pressBack();
        String sex =MeAction.getSex();
        Asst.assertEquals("change to male","Male",sex);
        gDevice.pressBack();
        Spoon.screenshot("male");
    }
    @Test
    @SanityTest
    @PerformanceTest
    public void testFemale() throws UiObjectNotFoundException {
        //修改性别为-female
        MeAction.navToSex();
        clickById(MePage.SETTINGS_SEX_FEMALE);
        waitUntilGone(MePage.SETTINGS_SEX_MALE,10000);
        //验证
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_CN);
        MeAction.navToSex();
        gDevice.pressBack();
        String sex =MeAction.getSex();
        Asst.assertEquals("change to female","Female",sex);
        gDevice.pressBack();
        Spoon.screenshot("female");
    }
    @Test
    @SanityTest
    @PerformanceTest
    public void testSecret() throws UiObjectNotFoundException {
        //修改性别为-female
        MeAction.navToSex();
        clickById(MePage.SETTINGS_SEX_SECRET);
        waitUntilGone(MePage.SETTINGS_SEX_MALE,10000);
        //验证
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_CN);
        MeAction.navToSex();
        gDevice.pressBack();
        String sex =MeAction.getSex();
        Asst.assertEquals("change to secret","Privacy",sex);
        gDevice.pressBack();
        Spoon.screenshot("secret");
    }
}
