import java.util.Scanner;

class Car {
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}

class Race {
    private String currentLeader = "";
    private int leaderDistance = 0;

    public void determineNewLeader(Car car) {
        int distance = 24 * car.getSpeed();
        if (distance > leaderDistance) {
            currentLeader = car.getName();
            leaderDistance = distance;
        }
    }

    public String getLeader() {
        return currentLeader;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 0; i < 3; i++) {
            System.out.print("Введите назвыание автомобиля: ");
            String name = scanner.next();

            int speed;
            while (true) {
                System.out.print("Введите скорость автомобиля (0-250 km/h): ");
                speed = scanner.nextInt();
                if (speed >= 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Недопустимая скорость, пожалуйста, введите значение от 0 до 250");
                }
            }

            Car car = new Car(name, speed);
            race.determineNewLeader(car);
        }

        System.out.println("Победитель гонки: " + race.getLeader());
        scanner.close();
    }
}