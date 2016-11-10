package cn.action;

import android.graphics.Point;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import com.squareup.spoon.Spoon;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import bean.InfoBean;
import ckt.base.VP2;
import cn.page.App;
import cn.page.MePage;

/**
 * Created by elon on 2016/10/27.
 */
public class MeAction extends VP2{
    //编辑界面所有用户的信息
    public static InfoBean getEditUserInfo() throws UiObjectNotFoundException {
        InfoBean infoBean=new InfoBean();
        infoBean.setNick_name(getNkName());
        infoBean.setSex(getSex());
        infoBean.setEmail(getEmailAddress());
        infoBean.setLocation(getLocation());
        infoBean.setId(getSioEyeID());
        infoBean.setAbout_me(getAboutMe());
        return  infoBean;
    }
    //Go to 直播
    public static void navToBroadcasts(){
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_ME_BROADCAST);
        waitTime(2);
        gDevice.wait(Until.findObject(By.res(MePage.BROADCAST_VIEW)),40000);
        Spoon.screenshot("navToBroadcasts");
    }
    //Go to 关注
    public static void navToFollowing(){
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_ME_FOLLOWING);
        gDevice.wait(Until.gone(By.res(MePage.LOADING_FOLLOWERS)),40000);
        Spoon.screenshot("navToFollowing");
    }
    //Go to 粉丝
    public static void navToFans(){
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_ME_FOLLOWERS);
        gDevice.wait(Until.gone(By.res(MePage.BROADCAST_VIEW_VIDEO_LOADING)),40000);
        Spoon.screenshot("navToFans");
    }

    //Go to 直播配置
    public static void navToLiveConfiguration(){
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.LIVE_CONFIGURATION);
        Spoon.screenshot("navToLiveConfiguration");
    }
    //Go to 我的二维码
    public static void navToQrCode(){
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.LIVE_CONFIGURATION);
        Spoon.screenshot("navToQrCode");
    }
    //Go to 消息
    public static void navToNotifications(){
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.NOTIFICATIONS);
        gDevice.wait(Until.gone(By.res(MePage.IS_LOCATING)),20000);
        Spoon.screenshot("navToNotifications");
    }
    //Go to 消息
    public static void navToSettings(){
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.SETTINGS_USER_MAIN);
        Spoon.screenshot("navToSettings");
    }
    //Go to 帮助中心
    public static void navToFeedback(){
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.SETTINGS_USER_MAIN);
        Spoon.screenshot("navToFeedback");
    }
    //编辑 -> 昵称
    public static InfoBean navToNickName() throws UiObjectNotFoundException {
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_USER_EDIT);
        InfoBean infoBean=getEditUserInfo();
        logger.info(infoBean.toString());
        clickById(MePage.NAV_EDIT_NICKNAME);
        Spoon.screenshot("navToNickName");
        return infoBean;
    }
    //编辑 -> 性别
    public static InfoBean navToSex() throws UiObjectNotFoundException {
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_USER_EDIT);
        InfoBean infoBean=getEditUserInfo();
        logger.info(infoBean.toString());
        clickById(MePage.NAV_EDIT_SEX);
        Spoon.screenshot("navToSex");
        return infoBean;
    }
    //编辑 -> 邮箱
    public static InfoBean navToEmail() throws UiObjectNotFoundException {
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_USER_EDIT);
        InfoBean infoBean=getEditUserInfo();
        logger.info(infoBean.toString());
        clickById(MePage.NAV_EDIT_EMAIL);
        Spoon.screenshot("navToEmail");
        return infoBean;
    }
    //编辑 -> 地址
    public static InfoBean navToLocation() throws UiObjectNotFoundException {
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_USER_EDIT);
        InfoBean infoBean=getEditUserInfo();
        logger.info(infoBean.toString());
        clickById(MePage.NAV_EDIT_LOCATION);
        Spoon.screenshot("navToLocation");
        return infoBean;
    }
    //编辑 -> 爱好
    public static InfoBean navToActivities() throws UiObjectNotFoundException {
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_USER_EDIT);
        InfoBean infoBean=getEditUserInfo();
        logger.info(infoBean.toString());
        clickById(MePage.NAV_EDIT_ACTIVITY);
        gDevice.wait(Until.gone(By.res(MePage.IS_LOCATING)),20000);
        Spoon.screenshot("navToActivities");
        return infoBean;
    }
    //编辑 -> Sio Eye ID
    public static InfoBean navToSioEyeId() throws UiObjectNotFoundException {
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_USER_EDIT);
        InfoBean infoBean=getEditUserInfo();
        logger.info(infoBean.toString());
        clickById(MePage.NAV_EDIT_SIOEYE_ID);
        Spoon.screenshot("navToSioEyeId");
        return infoBean;
    }
    //编辑 -> 个性签名
    public static InfoBean navToAboutMe() throws UiObjectNotFoundException {
        clickById(MePage.ID_MAIN_TAB_ME);
        clickById(MePage.ID_USER_EDIT);
        InfoBean infoBean=getEditUserInfo();
        logger.info(infoBean.toString());
        clickById(MePage.NAV_EDIT_ABOUT_ME);
        Spoon.screenshot("navToAboutMe");
        return infoBean;
    }
    //Go to 编辑
    public static InfoBean navToUserEdit() throws UiObjectNotFoundException {
        clickById(MePage.ID_MAIN_TAB_ME);
        Spoon.screenshot(gDevice,"Me");
        clickById(MePage.ID_USER_EDIT);
        InfoBean infoBean=getEditUserInfo();
        logger.info(infoBean.toString());
        return infoBean;
    }
    /**
     *获取点赞图标的X Y,作为键盘输入的确定按钮
     * @param
     */
    public static Point getPointToDoComment() throws UiObjectNotFoundException, IOException {
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_EN);
        Point point = new Point();
        navToBroadcasts();
        int index=BroadcastAction.getRandomBroadcastsIndex();
        BroadcastAction.getRandomBroadcasts(index).click();
        BroadcastAction.waitBroadcastLoading();
        UiObject zan = getUiObjectById(MePage.BROADCAST_VIEW_ZAN);
        int x = zan.getBounds().centerX();
        int y = zan.getBounds().centerY();
        point.set(x,y);
        makeToast(point.x+"|"+point.y,3);
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_EN);
        return  point;
    }
    //获取nickname
    public static String getNkName() throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(MePage.NAV_EDIT_NICKNAME));
        String me = u.getChild(new UiSelector().resourceId(MePage.ABOUT_ME_CONTENT_TEXT)).getText();
        return  me;
    }
    //获取性别
    public static String getSex() throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(MePage.NAV_EDIT_SEX));
        String me = u.getChild(new UiSelector().resourceId(MePage.ABOUT_ME_CONTENT_TEXT)).getText();
        return  me;
    }
    //邮件
    public static String getEmailAddress() throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(MePage.NAV_EDIT_EMAIL));
        String em = u.getChild(new UiSelector().resourceId(MePage.ABOUT_ME_CONTENT_TEXT)).getText();
        return  em;
    }
    //地址
    public static String getLocation() throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(MePage.NAV_EDIT_LOCATION));
        String em = u.getChild(new UiSelector().resourceId(MePage.ABOUT_ME_CONTENT_TEXT)).getText();
        return  em;
    }
    //爱好
    public static String getActivities() throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(MePage.NAV_EDIT_ACTIVITY));
        String em = u.getChild(new UiSelector().resourceId(MePage.ABOUT_ME_CONTENT_TEXT)).getText();
        return  em;
    }
    //SIO EYE ID
    public static String getSioEyeID() throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(MePage.NAV_EDIT_SIOEYE_ID));
        String em = u.getChild(new UiSelector().resourceId(MePage.ABOUT_ME_CONTENT_TEXT)).getText();
        return  em;
    }
    //个性签名内容
    public static String getAboutMe() throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(MePage.NAV_EDIT_ABOUT_ME));
        String me = u.getChild(new UiSelector().resourceId(MePage.ABOUT_ME_CONTENT_TEXT)).getText();
        return  me;
    }

    /*
    获取子对象内容MePage.ABOUT_ME_CONTENT_TEXT
    父对象id-MePage.ABOUT_ME_ID
    public static final String NAV_EDIT_NICKNAME="cn.sioeye.sioeyeapp:id/nickname";
    public static final String NAV_EDIT_SEX="cn.sioeye.sioeyeapp:id/sex";
    public static final String NAV_EDIT_EMAIL="cn.sioeye.sioeyeapp:id/email";
    public static final String NAV_EDIT_LOCATION="cn.sioeye.sioeyeapp:id/location";
    public static final String NAV_EDIT_ACTIVITY="cn.sioeye.sioeyeapp:id/interest";
    public static final String NAV_EDIT_SIOEYE_ID="cn.sioeye.sioeyeapp:id/sioeye_id";
    public static final String NAV_EDIT_ABOUT_ME="cn.sioeye.sioeyeapp:id/about";
    * */
    public static String getEditContent(String resourceID) throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(resourceID));
        String me = u.getChild(new UiSelector().resourceId(MePage.ABOUT_ME_CONTENT_TEXT)).getText();
        return  me;
    }
}
