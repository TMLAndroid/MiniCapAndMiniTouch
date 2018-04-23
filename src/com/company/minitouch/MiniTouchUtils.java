package com.company.minitouch;

import com.android.ddmlib.*;
import com.company.utils.Constant;

import java.io.File;
import java.io.IOException;

 
public class MiniTouchUtils {

    private IDevice device;
    private static final int PORT = 1111;
    private String ABI_COMMAND = "ro.product.cpu.abi";
    private String SDK_COMMAND = "ro.build.version.sdk";
    private String MINITOUCH_BIN = "minitouch";
    private String REMOTE_PATH = "/data/local/tmp";
    private String MINICAP_CHMOD_COMMAND = "chmod 777 %s/%s";
    private String MINICAP_WM_SIZE_COMMAND = "wm size";
    private String MINICAP_START_COMMAND = "LD_LIBRARY_PATH=/data/local/tmp /data/local/tmp/minicap -P %s@%s/0";
    private String MINICAP_TAKESCREENSHOT_COMMAND = "LD_LIBRARY_PATH=/data/local/tmp /data/local/tmp/minicap -P %s@%s/0 -s >%s";
    private String ADB_PULL_COMMAND = "adb -s %s pull %s %s";
    public MiniTouchUtils(IDevice device) {
        this.device = device;
        init();
    }



    /**
     * 将minicap的二进制和.so文件push到/data/local/tmp文件夹下，启动minicap服务
     */
    private void init() {

        String abi = device.getProperty(ABI_COMMAND);
        String sdk = device.getProperty(SDK_COMMAND);
        System.out.println("minitouch获取abi 信息以及系统的sdk为abi:"+abi+"sdk:"+sdk);
        File miniTouchBinFile = new File(Constant.getMiniTouchBin(), abi
                + File.separator + MINITOUCH_BIN);
        try {
            // 将minicap的可执行文件和.so文件一起push到设备中
            System.out.println(miniTouchBinFile.getAbsolutePath()+","+REMOTE_PATH
                    + File.separator + MINITOUCH_BIN);
            device.pushFile(miniTouchBinFile.getAbsolutePath(), REMOTE_PATH
                    + File.separator + MINITOUCH_BIN);
            executeShellCommand(String.format(MINICAP_CHMOD_COMMAND,
                    REMOTE_PATH, MINITOUCH_BIN));
            // 端口转发
            device.createForward(PORT, "minitouch",
                    IDevice.DeviceUnixSocketNamespace.ABSTRACT);


        } catch (SyncException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (AdbCommandRejectedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String executeShellCommand(String command) {
        CollectingOutputReceiver output = new CollectingOutputReceiver();
        try {
            device.executeShellCommand(command, output, 0);
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (AdbCommandRejectedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ShellCommandUnresponsiveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return output.getOutput();
    }

}
