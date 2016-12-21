package nyc.c4q.class12202016.backend;

public class House {
    private String style;
    private String price;
    private String location;

    public House(String style, String price, String location){
        this.style = style;
        this.price = price;
        this.location = location;
    }

    public String getStyle() {
        return style;
    }

    public String getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }
}
