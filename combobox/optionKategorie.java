package combobox;

public enum optionKategorie {

    Beine, Rücken, Oberkörper, Arme;

    private optionKategorie(){

    }
    public String value(){
        return name();
    }

    public static optionKategorie fromvalue(String v){
        return valueOf(v);
    }

}
