package ir.darkdeveloper.english9th.Data.Words;

import ir.plant.english9th.R;

/**
 * Created by DarkDeveloper on 17/02/17.
 */

public class DataRecyclerWords2 implements DataRecyclerWords {
    private String[] esm = {
            "Buy a ticket",
            "Check the passport",
            "Check in",
            "Check the timetable",
            "Take off / land",
            "Exchange money",
            "Fill out the form",
            "Book a hotel",
            "Pack for a trip",
            "Talk to the receptionist"
    };

    private String[] esm_f = {
            "Buy a ticket\nخرید یک بلیط",
            "Check the passport\nبررسی گذرنامه",
            "Check in\nبررسی (رزرو)",
            "Check the timetable\nبررسی جدول زمانی",
            "Take off / land\nبلند شدن/ فرود آمدن",
            "Exchange money\nتبدیل پول",
            "Fill out the form\nپر کردن فرم",
            "Book a hotel\nرزرو یک هتل",
            "Pack for a trip\nآماده سفر شدن",
            "Talk to the receptionist\nصحبت با پذیرشگر"
    };

    private int[] aks = {
            R.drawable.ticket,
            R.drawable.checkpassport,
            R.drawable.checkin,
            R.drawable.checktimetable,
            R.drawable.landandtakeoff,
            R.drawable.exchangemoney,
            R.drawable.filloutform,
            R.drawable.bookahotel,
            R.drawable.packfor,
            R.drawable.talkto
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
