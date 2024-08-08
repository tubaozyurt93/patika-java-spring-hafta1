[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/bm7i247I)
Factory desen

Library classes
```
abstract class Vehicle {
public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {
public void printVehicle() {
System.out.println("I am two wheeler");
}
}

class FourWheeler extends Vehicle {
public void printVehicle() {
System.out.println("I am four wheeler");
}
}
```

Factory Interface
```
interface VehicleFactory {
Vehicle createVehicle();
}

// Concrete Factory for TwoWheeler
class TwoWheelerFactory implements VehicleFactory {
public Vehicle createVehicle() {
return new TwoWheeler();
}
}
```

Concrete Factory for FourWheeler
```
class FourWheelerFactory implements VehicleFactory {
public Vehicle createVehicle() {
return new FourWheeler();
}
}

// Client class
class Client {
private Vehicle pVehicle;

    public Client(VehicleFactory factory) {
        pVehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}
```

Driver program
```

public class GFG {
public static void main(String[] args) {
VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
Client twoWheelerClient = new Client(twoWheelerFactory);
Vehicle twoWheeler = twoWheelerClient.getVehicle();
twoWheeler.printVehicle();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        Client fourWheelerClient = new Client(fourWheelerFactory);
        Vehicle fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();
    }
}
```


Singleton desen

```
import java.io.*;
class Singleton {
// static class
private static Singleton instance;
private Singleton()
{
System.out.println("Singleton is Instantiated.");
}
public static Singleton getInstance()
{
if (instance == null)
instance = new Singleton();
return instance;
}
public static void doSomething()
{
System.out.println("Somethong is Done.");
}
}

class GFG {
public static void main(String[] args)
{
Singleton.getInstance().doSomething();
}
}
```


