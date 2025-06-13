package codegym.mod2.project.simulation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulationParameters {
    int weight();
    int maxPerLocation();
    int speed();
    int maxNeededFoodKg();
}
