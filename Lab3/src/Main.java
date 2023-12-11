public class Main {
    public static void main(String[] args) {
        // Create a regular spacecraft
        // Create a reusable spacecraft
        ReusableSpacecraft reusableSpacecraft = new ReusableSpacecraft("Reusable Spacecraft", "Ion", 800, "GalaxyNav", 30, 30, 3);
        reusableSpacecraft.launch();
        reusableSpacecraft.navigateTo("Moon");
        reusableSpacecraft.shoot(false, true);
        reusableSpacecraft.stop();
        reusableSpacecraft.printStatus();
        reusableSpacecraft.deploySolarPanels();

        // Try launching reusable spacecraft more than its remaining flights
        for (int i = 0; i < 5; i++) {
            reusableSpacecraft.launch();
        }
        reusableSpacecraft.TestFunction();
    }
}
