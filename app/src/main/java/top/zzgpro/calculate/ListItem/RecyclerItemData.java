package top.zzgpro.calculate.ListItem;

public class RecyclerItemData{
    private int Image;

    public int getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    private String Name;
    public RecyclerItemData(int image,String Name){
        this.Image=image;
        this.Name=Name;
    }
}