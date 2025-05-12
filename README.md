## Car Dealership Inventory Console App

This Java console application lets users interact with a vehicle inventory system. It reads from a CSV file and allows:
- Displaying all available vehicles
- Filtering vehicles within a price range


## Screenshots
![workshop scr 1](https://github.com/user-attachments/assets/c08c9490-5da6-4874-b9c0-d6a3f9ef5491)
![workshop scr 2](https://github.com/user-attachments/assets/a1f73fe0-1eb9-4e03-8364-f105d2ff6bc3)
![workshop scr 3](https://github.com/user-attachments/assets/eb220fe7-c38f-491b-8faa-4684533b705d)


## Interesting Code
### Method: getVehiclesByPrice(double min, double max)
```java
public List<Vehicle> getVehiclesByPrice(double min, double max) {
    List<Vehicle> results = new ArrayList<>();
    for (Vehicle v : inventory) {
        if (v.getPrice() >= min && v.getPrice() <= max) {
            results.add(v);
        }
    }
    return results;
}

Why it’s interesting
This method helped me practice loops and conditionals while learning how to filter data in a list based on user input.
