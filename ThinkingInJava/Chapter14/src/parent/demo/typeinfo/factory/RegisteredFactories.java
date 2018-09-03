package parent.demo.typeinfo.factory;

import parent.demo.typeinfo.Null;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Part {
    public static final NullPart NULL = new NullPart();

    private static class NullPart extends Part implements Null {

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFacotries = new ArrayList<>();

    static {
        partFacotries.add(new FuelFilter.Factory());
        partFacotries.add(new AirFilter.Facotry());
        partFacotries.add(new CabinAirFilter.Factory());
        partFacotries.add(new OilFilter.Factory());
        partFacotries.add(new FanBelt.Factory());
        partFacotries.add(new PowerSteeringBelt.Factory());
        partFacotries.add(new GeneratorBelt.Factory());
    }

    private static Random ran = new Random(47);

    public static Part createRandom() {
        int n = ran.nextInt(partFacotries.size());
        return partFacotries.get(n).create();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
    public static class Factory implements parent.demo.typeinfo.factory.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Facotry implements parent.demo.typeinfo.factory.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements parent.demo.typeinfo.factory.Factory<CabinAirFilter> {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements parent.demo.typeinfo.factory.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    public static class Factory implements parent.demo.typeinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements parent.demo.typeinfo.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements parent.demo.typeinfo.factory.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}


public class RegisteredFactories {


    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Part.createRandom());
//        }

    }
}
