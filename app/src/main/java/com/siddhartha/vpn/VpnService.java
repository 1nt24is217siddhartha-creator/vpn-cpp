package com.siddhartha.vpn;

import android.content.Intent;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;

public class VpnService extends android.net.VpnService {

    private ParcelFileDescriptor vpnInterface;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Builder builder = new Builder();

        builder.setSession("VPN C++")
               .addAddress("10.0.0.2", 24)
               .addRoute("0.0.0.0", 0);

        vpnInterface = builder.establish();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {

        if (vpnInterface != null) {
            try {
                vpnInterface.close();
            } catch (Exception ignored) {
            }

            vpnInterface = null;
        }

        super.onDestroy();
    }
}
