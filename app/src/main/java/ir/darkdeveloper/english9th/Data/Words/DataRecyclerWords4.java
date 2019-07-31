package ir.darkdeveloper.english9th.Data.Words;

import ir.plant.english9th.R;

/**
 * Created by DarkDeveloper on 17/02/17.
 */

public class DataRecyclerWords4 implements DataRecyclerWords {
    private String[] esm = {
            "Call the emergency",
            "Send an e_mail",
            "Take out money",
            "Get on a bus",
            "Get off a bus",
            "Hire a taxi",
            "Open an account",
            "Put out fire",
            "Recharge the E_ticket",
            "Ask the information desk"
    };


    private String[] esm_f = {
            "Call the emergency\nتماس گرفتن اظطراری",
            "Send an e_mail\nفرستادن پست الکترونیک",
            "Take out money\nپول گرفتن",
            "Get on a bus\nسوار اتوبوس شدن",
            "Get off a bus\nپیاده شدن از اتوبوس",
            "Hire a taxi\nکرایه تاکسی",
            "Open an account\nباز کردن حساب",
            "Put out fire\nخاموش کردن آتش",
            "Recharge the E_ticket\nشارژ دوباره بلیط الکترونیک",
            "Ask the information desk\nسوال از (بخش) میز اطلاعات"
    };

    private int[] aks = {
            R.drawable.callemergency,
            R.drawable.sendemail,
            R.drawable.takeoutmoney,
            R.drawable.getonabus,
            R.drawable.getoffabus,
            R.drawable.hireataxi,
            R.drawable.openanaccount,
            R.drawable.putoutfire,
            R.drawable.rechargeyoureticjet,
            R.drawable.askthefrontdesk
    };

    @Override
    public void setEsm(String[] esm) {
        this.esm = esm;
    }

    @Override
    public String[] getEsm() {
        return esm;
    }

    @Override
    public void setAks(int[] aks) {
        this.aks = aks;
    }

    @Override
    public void setEsm_f(String[] esm_f) {
        this.esm_f = esm_f;
    }

    @Override
    public String[] getEsm_f() {
        return esm_f;
    }

    @Override
    public int[] getAks() {
        return aks;
    }
}
