package org.marsik.ham.adif.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum Propagation implements AdifEnumCode {
    AIRCRAFT_SCATTER("AS"),
    AURORA_E("AUE"),
    AURORA("AUR"),
    BACK_SCATTER("BS"),
    ECHOLINK("ECH"),
    EARTH_MOON_EARTH("EME"),
    SPORADIC_E("ES"),
    F2_REFLECTION("F2"),
    FIELD_ALIGNED_IRREGULARITIES("FAI"),
    GROUND_WAVE("GWAVE"),
    INTERNET("INTERNET"),
    IONOSCATTER("ION"),
    IRLP("IRL"),
    LINE_OF_SIGHT("IOS"),
    METEOR_SCATTER("MS"),
    REPEATER("RPT"),
    RAIN_SCATTER("RS"),
    SATELLITE("SAT"),
    TRANSEQUATORIAL("TEP"),
    TROPOSPHERIC_DUCTING("TR");

    private final String code;

    Propagation(String code) {
        this.code = code;
    }

    @Override
    public String adifCode() {
        return code;
    }

    private final static Map<String, Propagation> reverse = new HashMap<>();

    static {
        Stream.of(values()).forEach(v -> reverse.put(v.adifCode(), v));
    }

    public static Propagation findByCode(String code) {
        return reverse.get(code.toUpperCase());
    }
}
