import java.util.Iterator;

public class Toys implements Iterator<String> {
    private String name;
    private int mass;
    private int id;

    public Toys(int id, String name, int mass) {
        this.id = id;
        this.mass = mass;
        this.name = name;
        this.index = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    int index;

    @Override
    public boolean hasNext() {
        return index++ < 3;
    }

    @Override
    public String next() {
        switch (index) {
            case 1:
                return name;
            case 2:
                return Integer.toString(mass);
            default:
                return Integer.toString(id);

        }

    }

}
