package com.example.exoplayer;

import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.Player;

public class MyDispatcher extends DefaultControlDispatcher {
    @Override
    public boolean dispatchSeekTo(Player player, int windowIndex, long positionMs) {
        long a = player.getCurrentPosition();
        long b = player.getDuration();
        if (a > positionMs) {
            player.seekTo(windowIndex, positionMs);
            return true;

        } else if (a == b) {
            player.stop(true);
        }

        return false;
    }
}
