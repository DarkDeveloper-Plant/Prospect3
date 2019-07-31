package ir.darkdeveloper.english9th.Data.Words;

public interface DataRecyclerWords {
    String [] esm = {
            ""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""

    };

    String [] esm_f = {
            ""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
    };
    int [] aks = {
            0
            ,0
            ,0
            ,0
            ,0
            ,0
            ,0
            ,0
            ,0
            ,0
    };


    void setEsm(String[] esm);

    String[] getEsm();

    void setAks(int[] aks);

    void setEsm_f(String[] esm_f);

    String[] getEsm_f();

    int[] getAks();
}
