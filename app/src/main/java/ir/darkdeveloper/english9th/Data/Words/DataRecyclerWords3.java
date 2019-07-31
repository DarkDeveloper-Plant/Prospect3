package ir.darkdeveloper.english9th.Data.Words;

import ir.plant.english9th.R;

/**
 * Created by DarkDeveloper on 17/02/17.
 */

public class DataRecyclerWords3 implements DataRecyclerWords {
    private String[] esm = {
            "Make lunch / dinner",
            "Bake a cake",
            "Set the table",
            "Sing the national anthem",
            "Hold a ceremony",
            "Watch fireworks",
            "Read poems of Hafez",
            "Wear special clothes",
            "Go out on Nature Day",
            "Clear the table"
    };

    private String[] esm_f = {
            "Make lunch / dinner\nدرست کردن ناهار/شام",
            "Bake a cake\nپختن یک کیک",
            "Set the table\nچیدن میز",
            "Sing the national anthem\nخواندن سرود ملی",
            "Hold a ceremony\nجشن گرفتن",
            "Watch fireworks\nتماشای آتش بازی",
            "Read poems of Hafez\nخواندن شعر های حافظ",
            "Wear special clothes\nپوشیدن لباس های خاص",
            "Go out on Nature Day\nبیرون رفتن در روز طبیعت",
            "Clear the table\nتمیز کردن میز"
    };



    private int[] aks = {
            R.drawable.makelunch,
            R.drawable.bakecake,
            R.drawable.settable,
            R.drawable.singanthem,
            R.drawable.holdcerenony,
            R.drawable.watchfire,
            R.drawable.poemsofhafez,
            R.drawable.specialclothes,
            R.drawable.gooutnature,
            R.drawable.cleartable
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
