package ir.darkdeveloper.english9th.Data.Words;

import ir.plant.english9th.R;

/**
 * Created by DarkDeveloper on 17/02/17.
 */

public class DataRecyclerWords6 implements DataRecyclerWords {
    private String[] esm = {
            "She burned her hand",
            "He broke his leg",
            "He hit his head on the door",
            "It is bleeding",
            "It hurts a lot",
            "She cut her finger",
            "Please stick a plaster on the wound",
            "I hurt my knee",
            "She takes care of her mother",
            "He has some bruises"
    };

    private String[] esm_f = {
            "She burned her hand\nدستش را سوزاند",
            "He broke his leg\nپای او شکست",
            "He hit his head on the door\nسرش به در برخورد کرد",
            "It is bleeding\nدرحال خونریزی است",
            "It hurts a lot\nخیلی درد دارد",
            "She cut her finger\nانگشتش را برید",
            "Please stick a plaster on the wound\nلطفا یک چسپ زخم روی زخم بچسبانید",
            "I hurt my knee\nزانویم آسیب دید",
            "She takes care of her mother\nاز مادرش مراقبت می کند",
            "He has some bruise\nاو کمی کبودی دارد."
    };


    private int[] aks = {
            R.drawable.sheburned,
            R.drawable.brokeleg,
            R.drawable.hehithead,
            R.drawable.itsbleeding,
            R.drawable.ithurt,
            R.drawable.cutfinger,
            R.drawable.stick,
            R.drawable.ihurtmyknee,
            R.drawable.shetakescare,
            R.drawable.hehasbruises,
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
