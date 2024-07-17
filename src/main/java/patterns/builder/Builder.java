package patterns.builder;


class House {
    private String address;
    private double size;
    private double price;

    public House(String address, double size, double price) {
        this.address = address;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "House [address=" + address + ", size=" + size + " sqft, price=$" + price + "]";
    }
}

class Director {
    private HouseBuilder builder;

    void setBuilder(HouseBuilder houseBuilder) {
        this.builder = houseBuilder;
    }

    House buildHouse() {
        builder.setAddress();
        builder.setSize();
        builder.setPrice();
        return builder.houseBuild();
    }
}

abstract class HouseBuilder {
    abstract void setAddress();
    abstract void setSize();
    abstract void setPrice();
    abstract House houseBuild();
}

class VillaBuilder extends HouseBuilder {
    private String address;
    private double size;
    private double price;

    @Override
    void setAddress() {
        this.address = "123 Luxury Street, Beverly Hills";
    }

    @Override
    void setSize() {
        this.size = 10000; // Assuming size is in square feet
    }

    @Override
    void setPrice() {
        this.price = 5000000; // Assuming price is in dollars
    }

    @Override
    House houseBuild() {
        return new House(address, size, price);
    }
}

class CastleBuilder extends HouseBuilder {
    private String address;
    private double size;
    private double price;

    @Override
    void setAddress() {
        this.address = "1 Royal Road, Medieval Kingdom";
    }

    @Override
    void setSize() {
        this.size = 50000; // Assuming size is in square feet
    }

    @Override
    void setPrice() {
        this.price = 20000000; // Assuming price is in dollars
    }

    @Override
    House houseBuild() {
        return new House(address, size, price);
    }
}

class Main {
    public static void main(String[] args) {
        Director director = new Director();

        // Building a Villa
        HouseBuilder villaBuilder = new VillaBuilder();
        director.setBuilder(villaBuilder);
        House villa = director.buildHouse();
        System.out.println(villa);

        // Building a Castle
        HouseBuilder castleBuilder = new CastleBuilder();
        director.setBuilder(castleBuilder);
        House castle = director.buildHouse();
        System.out.println(castle);
    }
}
