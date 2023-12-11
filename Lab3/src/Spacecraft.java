import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Spacecraft {
    protected String name;
    protected Engine engine;
    protected NavigationSystem navigationSystem;
    protected Turrel LeftTurrel;
    protected Turrel RightTurrel;


    // Конструктори
    public Spacecraft(String name, Engine engine, NavigationSystem navigationSystem, Turrel LeftTurrel, Turrel RightTurrel) {
        this.name = name;
        this.engine = engine;
        this.navigationSystem = navigationSystem;
        this.LeftTurrel = LeftTurrel;
        this.RightTurrel = RightTurrel;
    }

    public Spacecraft(String name, String engineType, int enginePower, String navSystemType, int ammoLeft, int ammoRight) {
        this.name = name;
        this.engine = new Engine(engineType, enginePower);
        this.navigationSystem = new NavigationSystem(navSystemType);
        this.LeftTurrel = new Turrel(ammoLeft);
        this.RightTurrel = new Turrel(ammoRight);
    }

    // Abstract methods
    public abstract void launch();

    public abstract void navigateTo(String destination);

    public abstract void shoot(boolean IsLeftShoot, boolean IsRightShoot);

    public abstract void stop();

    public abstract void printStatus();

    private void log(String message) {
        try (FileWriter fileWriter = new FileWriter("spacecraft_log.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected class Engine {
        private String type;
        private int power;

        public Engine(String type, int power) {
            this.type = type;
            this.power = power;
        }

        public String getType() {
            return type;
        }

        public int getPower() {
            return power;
        }
    }

    protected class NavigationSystem {
        private String type;

        public NavigationSystem(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
    }

    protected class Turrel {
        private int ammo;

        public Turrel(int ammo) {
            this.ammo = ammo;
        }

        public int getAmmo() {
            return ammo;
        }

        public void setAmmo(int Ammo) {
            this.ammo = Ammo;

        }

    }
}