package iris4G.testcase;

import android.os.Environment;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Asst;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.HashSet;
import java.util.logging.Logger;

import ckt.base.VP2;
import iris4G.action.CameraAction;
import iris4G.action.Iris4GAction;
import iris4G.page.Iris4GPage;
import iris4G.page.NavPage;

/**
 * @Author elon
 * @Description
 * 连拍测试10|20|30 * 4M(16:9)|3M(4:3)|2M(16:9)
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 16)
public class BurstCase extends VP2{
    private static Logger logger = Logger.getLogger(BurstCase.class.getName());
    @Before
    public void setup() throws Exception {
        Iris4GAction.initIris4G();
    }
    private void Burst(String imageSize,String burstSetting,double expectWH) throws Exception {
        //"4M(16:9)",
        CameraAction.configImageSize(NavPage.navConfig_Burst,imageSize);
        //"10P",
        CameraAction.configBurst(NavPage.navConfig_Burst,burstSetting);

        //更改成功，相机左上角显示4M
        Asst.assertEquals(imageSize,imageSize.substring(0,2),getTex(Iris4GPage.info).trim());
        //更改成功，相机左上角显示10P/20P/30P
        Asst.assertEquals(burstSetting,burstSetting,getTex(Iris4GPage.camera_mode_label).trim());

        HashSet<String> beforeTakeVideoList = Iris4GAction.FileList("/sdcard/Photo");
        Iris4GAction.cameraKey();
        waitTime(10);
        HashSet<String> afterTakeVideoList = Iris4GAction.FileList("/sdcard/Photo");
        HashSet<String> resultHashSet = Iris4GAction.result(afterTakeVideoList, beforeTakeVideoList);
        int expect_picture_burst_size=Integer.parseInt(burstSetting.replace("P",""));
        getObject2ById(Iris4GPage.camera_setting_shortcut_id);
        int active_picture_count = resultHashSet.size();
        if (active_picture_count!=expect_picture_burst_size) {
            logger.info(String.format("expect total picture：%s-but active is：%s",
                    expect_picture_burst_size,active_picture_count));
        }else {
            logger.info(String.format("expect total picture：%s-Success",expect_picture_burst_size));
            for (String photoPath : resultHashSet) {
                double activeWH = Iris4GAction.getPicHeightWidth(photoPath);
                if (activeWH==expectWH) {
                    logger.info(photoPath+" -picture width height is right");
                }else {
                    logger.info(photoPath+" -width height error");
                    logger.info("expect is "+expectWH);
                    logger.info("active is "+activeWH);
                    String message=String.format("expect is %s.but active is %s",expectWH,activeWH);
                    Asst.fail(message);
                }
            }
        }
    }
    /* burst  - " "4M(16:9)","3M(4:3)","2M(16:9),"8M(16:9)";
       video quality  -   "480@30FPS","480@60FPS","480@120FPS",
                  "720@30FPS","720@60FPS","1080@30FPS";
        * */
    @Test
    public void testBurst10P4M169() throws Exception {
        Burst(NavPage.imageSize4M,NavPage.burst_10P,16/9);
    }
    @Test
    public void testBurst20P4M169() throws Exception {
        Burst(NavPage.imageSize4M,NavPage.burst_20P,16/9);
    }
    @Test
    public void testBurst30P4M169() throws Exception {
        Burst(NavPage.imageSize4M,NavPage.burst_30P,16/9);
    }
    @Test
    public void testBurst10P3M43() throws Exception {
        Burst(NavPage.imageSize3M,NavPage.burst_10P,4/3);
    }
    @Test
    public void testBurst20P3M43() throws Exception {
        Burst(NavPage.imageSize3M,NavPage.burst_20P,4/3);
    }
    @Test
    public void testBurst30P3M43() throws Exception {
        Burst(NavPage.imageSize3M,NavPage.burst_30P,4/3);
    }
    @Test
    public void testBurst10P2M169() throws Exception {
        Burst(NavPage.imageSize2M,NavPage.burst_10P,16/9);
    }
    @Test
    public void testBurst20P2M169() throws Exception {
        Burst(NavPage.imageSize2M,NavPage.burst_20P,16/9);
    }
    @Test
    public void testBurst30P2M169() throws Exception {
        Burst(NavPage.imageSize2M,NavPage.burst_30P,16/9);
    }
    @Test
    public void testBurst10P8M43() throws Exception {
        Burst(NavPage.imageSize8M,NavPage.burst_10P,4/3);
    }
    @Test
    public void testBurst20P8M43() throws Exception {
        Burst(NavPage.imageSize8M,NavPage.burst_20P,4/3);
    }
    @Test
    public void testBurst30P8M43() throws Exception {
        Burst(NavPage.imageSize8M,NavPage.burst_30P,4/3);
    }

}
