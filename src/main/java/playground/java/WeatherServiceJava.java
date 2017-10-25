package playground.java;

import rx.Observable;

import java.util.function.Supplier;

public class WeatherServiceJava {

    private final Supplier<Object> cache;

    public WeatherServiceJava(Supplier<Object> cache) {
        this.cache = cache;
    }

    public Observable<Weather> findWeather() {
        return ObservableUtils.justSafe(cache, Weather.class);
    }

    public static class ObservableUtils {

        public static <T> Observable<T> justSafe(Supplier<Object> cache, Class<T> clazz) {
            try {
                Object value = cache.get();
                // if (!(value instanceof T)) doesn't work
                if (!value.getClass().isAssignableFrom(clazz)) {
                    throw new IllegalStateException("Wrong type");
                }
                T weather = (T) value;
                return Observable.just(weather);
            } catch (Exception e) {
                return Observable.error(e);
            }
        }

    }

}
