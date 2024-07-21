package patterns.builder.example.builders;

import patterns.builder.example.cars.CarType;
import patterns.builder.example.components.Engine;
import patterns.builder.example.components.GPSNavigator;
import patterns.builder.example.components.Transmission;
import patterns.builder.example.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
