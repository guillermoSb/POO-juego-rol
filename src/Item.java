public class Item {
    String name;
    int type;

    Item(String name, int type) {
        this.name = name;
        this.type = type;
    }

    String getName() {
        return this.name;
    }
    
    int getType() {
        return this.type;
    }
    
}
