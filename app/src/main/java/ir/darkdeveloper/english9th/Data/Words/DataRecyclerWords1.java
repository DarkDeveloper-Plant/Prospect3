package ir.darkdeveloper.english9th.Data.Words;

import ir.plant.english9th.R;

/**
 * Created by DarkDeveloper on 17/02/17.
 */

public class DataRecyclerWords1 implements DataRecyclerWords{


    private String [] esm = {
            "Angry",
            "Brave",
            "Careless",
            "Cruel",
            "Rude",
            "Nervous",
            "Quiet",
            "Funny",
            "Selfish",
            "Neat"
    };

    private String [] esm_f = {
            "Angry\nخشمگین",
            "Brave\nشجاع",
            "Careless\nبی دقت",
            "Cruel\nبی رحم",
            "Rude\nبی ادب",
            "Nervous\nعصبی",
            "Quiet\nساکت",
            "Funny\nبامزه",
            "Selfish\nخودخواه/مغرور",
            "Neat\nمرتب"
    };
    private int [] aks = {
            R.drawable.angry,
            R.drawable.brave,
            R.drawable.careless,
            R.drawable.israel_cruel,
            R.drawable.rude,
            R.drawable.nervous,
            R.drawable.quiet,
            R.drawable.funny,
            R.drawable.selfish,
            R.drawable.neat,
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
