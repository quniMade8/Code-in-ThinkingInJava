package parent.Prac38;

class CoffeeDecorator extends Coffee {
    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void setName(String name) {
        coffee.setName(name);
    }

    @Override
    public String getName() {
        return coffee.getName();
    }
}

class Milked extends CoffeeDecorator {
    public void go() {
        System.out.println("Adding milk...");
    }

    public Milked(Coffee coffee) {
        super(coffee);
    }
}

class Buttered extends CoffeeDecorator {
    public void go() {
        System.out.println("Adding butter...");
    }

    public Buttered(Coffee coffee) {
        super(coffee);
    }
}

public class Prac38 {
    public static void main(String[] args) {
        Coffee rawCoffee = new Coffee();
        Buttered butteredCoffee = new Buttered(rawCoffee);
        butteredCoffee.go();
    }
}
