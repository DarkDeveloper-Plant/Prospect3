package ir.darkdeveloper.english9th.Data.Words;

import ir.plant.english9th.R;

/**
 * Created by DarkDeveloper on 17/02/17.
 */

public class DataRecyclerWords5 implements DataRecyclerWords {
    private String[] esm = {
            "Interview somebody",
            "Text a message",
            "Receive an e_mail",
            "Update a blog",
            "Participate in an online course",
            "Connect to the Internet",
            "Download something from the Internet",
            "Attend a TV program",
            "Use Information Technology",
            "Install a computer dictionary"
    };



    private String[] esm_f = {
            "Interview somebody\nمصاحبه با بعضی افراد",
            "Text a message\nفرستادن نامه",
            "Receive an e_mail\nدریافت یک پست الکترونیک",
            "Update a blog\nبروزرسانی وبلاگ",
            "Participate in an online course\nشرکت در یک دوره آنلاین",
            "Connect to the Internet\nوصل شدن به اینترنت",
            "Download something from the Internet\nبارگیری چیزی از اینترنت",
            "Attend a TV program\nشرکت در یک برنامه تلویزیونی",
            "Use Information Technology\nاستفاده از فناوری اطلاعات",
            "Install a computer dictionary\nنصب یک فرهنگنامه کامپیوتر"
    };



    private int[] aks = {
            R.drawable.interviewsomebody,
            R.drawable.textamessage,
            R.drawable.reciveanemail,
            R.drawable.updateablog,
            R.drawable.participateonline,
            R.drawable.connecttotheinternet,
            R.drawable.downloadsomethinginternet,
            R.drawable.attendtvprogram,
            R.drawable.useit,
            R.drawable.computerdic
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
