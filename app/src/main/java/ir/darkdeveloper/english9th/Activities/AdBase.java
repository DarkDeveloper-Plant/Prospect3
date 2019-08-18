package ir.darkdeveloper.english9th.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import ir.tapsell.sdk.Tapsell;
import ir.tapsell.sdk.TapsellAd;
import ir.tapsell.sdk.TapsellAdRequestListener;
import ir.tapsell.sdk.TapsellAdRequestOptions;
import ir.tapsell.sdk.TapsellAdShowListener;
import ir.tapsell.sdk.TapsellShowOptions;

public class AdBase {

    private Context context;
    public AdBase(Context context) {
        this.context = context;
    }

    public void showAd() {
        ConnectivityManager CManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = CManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            TapsellAdRequestOptions options = new TapsellAdRequestOptions();
            options.setCacheType(TapsellAdRequestOptions.CACHE_TYPE_STREAMED);
            TapsellShowOptions showOptions = new TapsellShowOptions();
            showOptions.setBackDisabled(false);
            showOptions.setRotationMode(TapsellShowOptions.ROTATION_LOCKED_PORTRAIT);
            Tapsell.requestAd(context, "5d57f374e2fa8300016b69ee", options, new TapsellAdRequestListener() {
                @Override
                public void onError(String error) {
                }

                @Override
                public void onAdAvailable(TapsellAd ad) {
                    ad.show(context, showOptions, new TapsellAdShowListener() {
                        @Override
                        public void onOpened(TapsellAd tapsellAd) {

                        }

                        @Override
                        public void onClosed(TapsellAd tapsellAd) {

                        }
                    });
                }

                @Override
                public void onNoAdAvailable() {
                }

                @Override
                public void onNoNetwork() {
                }

                @Override
                public void onExpiring(TapsellAd ad) {
                }
            });
        } else {
            Toast.makeText(context, "اتصال شما برقرار نشد", Toast.LENGTH_SHORT).show();
        }
    }



}
