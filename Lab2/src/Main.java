public class Main {
    public static void main(String[] args) {
        // Creating an instance of the Spacecraft class using the second constructor

        Engine Engine1 = new Engine("Hydrohen", 9000);
        NavigationSystem NavSystem1 = new NavigationSystem("GPS");
        Turrel r1 = new Turrel(10);
        Turrel l1 = new Turrel(10);

        Spacecraft f1 = new Spacecraft("f1",Engine1, NavSystem1,r1,l1);

        f1.launch();
        f1.navigateTo("Mars");
        f1.shoot(true, false);
        f1.printStatus();
        f1.stop();
        // Testing the log file
        // The log file will be created or appended in the current working directory
        // Make sure to check the file "spacecraft_log.txt" after running the program
    }
}
