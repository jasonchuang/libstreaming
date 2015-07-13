package net.majorkernelpanic.streaming.hw;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;

@SuppressLint("InlinedApi")
public class MediaCodecListUtils {

    public final static String TAG = "MediaCodecListUtils";

    public static int getCodecCount() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            MediaCodecInfo[] mediaCodecInfos = getMediaCodecInfos();
            return mediaCodecInfos.length;
        }

        return MediaCodecList.getCodecCount();
    }

    public static MediaCodecInfo getCodecInfoAt(int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            MediaCodecInfo[] mediaCodecInfos = getMediaCodecInfos();
            if (index < 0 || index > mediaCodecInfos.length) {
                throw new IllegalArgumentException();
            }

            return mediaCodecInfos[index];
        }

        return MediaCodecList.getCodecInfoAt(index);
    }

    private static MediaCodecInfo[] getMediaCodecInfos() {
        MediaCodecList mediaCodecList = new MediaCodecList(MediaCodecList.REGULAR_CODECS);
        return mediaCodecList.getCodecInfos();
    }
}

