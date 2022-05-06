package top.zzgpro.calculate.Enum;

public enum CalculateTag {
    ADD("+",0),SUB("-",1),MUTIPIE("*",2),DIVISION("/",3);

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private String Tag;
    private int index;
    private CalculateTag(String tag,int index){
        this.index=index;
        this.Tag=tag;
    }
    public String getTag(int index) {
        for(CalculateTag c:CalculateTag.values()){
            if(c.getIndex()==index){
                return c.getTag();
            }
        }
        return null;
    }
}
