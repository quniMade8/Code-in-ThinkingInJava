package parent.prac14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Class<? extends Part>> classList = new ArrayList<>();

    static {
        classList.add(FuelFilter.class);
        classList.add(AirFilter.class);
        classList.add(OilFilter.class);
        classList.add(CabinAirFilter.class);
        classList.add(FanBelt.class);
        classList.add(GeneratorBelt.class);
    }

    private static Random ran = new Random(47);

    public static Part createRandom() throws IllegalAccessException, InstantiationException {
        int n = ran.nextInt(classList.size());
        return classList.get(n).newInstance();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
    public static class Factory implements parent.prac14.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Facotry implements Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements parent.prac14.Factory<CabinAirFilter> {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements parent.prac14.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    public static class Factory implements parent.prac14.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements parent.prac14.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements parent.prac14.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}


public class RegisteredFactories {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
