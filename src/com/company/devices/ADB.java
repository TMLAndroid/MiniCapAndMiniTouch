package com.company.devices;

import java.io.File;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;


public class ADB {

    private AndroidDebugBridge mAndroidDebugBridge = null;
    private String adbPath = "/Users/tangminglong/Library/Android/sdk/platform-tools";
    private String adbPlatformTools = "platform-tools";
    public static boolean hasInitAdb = false;

    public ADB(){
        init();
    }

    /**
     * 获取系统adb路径
     * @return
     */
    private String getADBPath(){
        if (adbPath == null){
            adbPath = System.getenv("ANDROID_HOME");
            if(adbPath != null){
                adbPath += File.separator + adbPlatformTools;
            }else {
                return null;
            }
        }
        adbPath += File.separator + "adb";
        return adbPath;
    }

    /**
     * 初始化adb连接
     * @return
     */
    private boolean init() {
        boolean success = false;
        if (!hasInitAdb){
            String adbPath = getADBPath();
            if (adbPath != null) {
                AndroidDebugBridge.init(false);
                mAndroidDebugBridge = AndroidDebugBridge.createBridge(adbPath, true);
                if (mAndroidDebugBridge != null) {
                    success = true;
                    hasInitAdb = true;
                }
                // 延时处理adb获取设备信息
                if (success) {
                    int loopCount = 0;
                    while (mAndroidDebugBridge.hasInitialDeviceList() == false) {
                        try {
                            Thread.sleep(100);
                            loopCount++;
                        } catch (InterruptedException e) {
                        }
                        if (loopCount > 100) {
                            success = false;
                            break;
                        }
                    }
                }
            }
        }

        return success;
    }

    // 获取连接的设备列表
    public IDevice[] getDevices() {
        IDevice[] devicelist = null;
        if (mAndroidDebugBridge != null) {
            devicelist = mAndroidDebugBridge.getDevices();
        }
        return devicelist;
    }
}