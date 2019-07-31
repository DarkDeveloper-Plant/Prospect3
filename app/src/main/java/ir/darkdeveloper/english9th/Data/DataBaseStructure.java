package ir.darkdeveloper.english9th.Data;

/**
 * Created by DarkDeveloper on 12/02/17.
 */

public class DataBaseStructure {

    public String conversation, conversation2;
    public String practice1, practice1_2;
    public String practice2, practice2_2;
    public String language, language2;
    public String lrw1, lrw2, ewords;
    public String grammar, grammar2;
    public String findit, findit2;
    public int id;

    public DataBaseStructure(String conversation, String practice1, String practice2
            , String language, String lrw1, String lrw2, String grammar, String findit
            ,String conversation2, String practice1_2, String practice2_2, String language2
            , String ewords, String findit2, String grammar2, int id) {
        this.conversation = conversation;
        this.practice1 = practice1;
        this.practice2 = practice2;
        this.language = language;
        this.lrw1 = lrw1;
        this.lrw2 = lrw2;
        this.grammar = grammar;
        this.findit = findit;
        this.conversation2 = conversation2;
        this.practice1_2 = practice1_2;
        this.practice2_2 = practice2_2;
        this.language2 = language2;
        this.ewords = ewords;
        this.grammar2 = grammar2;
        this.findit2 = findit2;
        this.id = id;
    }


    public String getConversation() {
        return conversation;
    }

    public void setConversation(String conversation) {
        this.conversation = conversation;
    }

    public String getConversation2() {
        return conversation2;
    }

    public void setConversation2(String conversation2) {
        this.conversation2 = conversation2;
    }

    //////////////////////////////

    public String getPractice1() {
        return practice1;
    }

    public void setPractice1(String practice1) {
        this.practice1 = practice1;
    }

    public String getPractice1_2() {
        return practice1_2;
    }

    public void setPractice1_2(String practice1_2) {
        this.practice1_2 = practice1_2;
    }

    //////////////////////////////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //////////////////////////////


    public String getFindit() {
        return findit;
    }

    public void setFindit(String findit) {
        this.findit = findit;
    }

    public String getFindit2() {
        return findit2;
    }

    public void setFindit2(String findit2) {
        this.findit2 = findit2;
    }

    //////////////////////////////


    public String getGrammar() {
        return grammar;
    }

    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    public String getGrammar2() {
        return grammar2;
    }

    public void setGrammar2(String grammar2) {
        this.grammar2 = grammar2;
    }
    //////////////////////////////


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    public String getLanguage2() {
        return language2;
    }

    //////////////////////////////

    public String getLrw2() {
        return lrw2;
    }

    public void setLrw2(String lrw2) {
        this.lrw2 = lrw2;
    }

    public String getEwords() {
        return ewords;
    }

    //////////////////////////////

    public String getLrw1() {
        return lrw1;
    }

    public void setLrw1(String lrw1) {
        this.lrw1 = lrw1;
    }

    public void setEwords(String ewords) {
        this.ewords = ewords;
    }

    //////////////////////////////


    public String getPractice2() {
        return practice2;
    }

    public void setPractice2(String practice2) {
        this.practice2 = practice2;
    }

    public String getPractice2_2() {
        return practice2_2;
    }

    public void setPractice2_2(String practice2_2) {
        this.practice2_2 = practice2_2;
    }

    //////////////////////////////

}