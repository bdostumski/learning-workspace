package designpatterns.creational.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryPatternFunctionalInterface {

    public static void main(String[] args) {

        MobileFactory mobileFactory = new MobileFactory();
        Mobile mobile = null;
        mobile = mobileFactory.getMobile(OS.ANDROID);
        mobile = mobileFactory.getMobile(OS.IOS);

        System.out.println(mobile.getClass().getName());

    }
}

enum OS {
    ANDROID, IOS;
}

interface Mobile {}

class Android implements Mobile {}

class IOS implements Mobile {}

class MobileFactory {
    // Enum Map
    final Map<OS, Supplier<Mobile>> map = new EnumMap<OS, Supplier<Mobile>>(OS.class);

    // Store references of different OS
    public MobileFactory() {
        map.put(OS.ANDROID, (Supplier<Mobile>) Android::new);
        map.put(OS.IOS, (Supplier<Mobile>) IOS::new);
    }

    public Mobile getMobile(OS type) {
        return map.get(type).get();
    }
}
