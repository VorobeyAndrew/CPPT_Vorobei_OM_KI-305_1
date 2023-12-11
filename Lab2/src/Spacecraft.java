import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Spacecraft {
    // Поля для опису складових частин корабля
    private String name;
    private Engine engine;
    private NavigationSystem navigationSystem;
    private Turrel LeftTurrel;
    private Turrel RightTurrel;

    private static int firstconstrucktor = 0;

    private static int secondconstrucktor = 0;


    // Конструктори
    public Spacecraft(String name, Engine engine, NavigationSystem navigationSystem, Turrel LeftTurrel, Turrel RightTurrel) {
        this.name = name;
        this.engine = engine;
        this.navigationSystem = navigationSystem;
        this.LeftTurrel = LeftTurrel;
        this.RightTurrel = RightTurrel;
        firstconstrucktor++;
    }

    public Spacecraft(String name, String engineType, int enginePower, String navSystemType, int ammoLeft, int ammoRight) {
        this.name = name;
        this.engine = new Engine(engineType, enginePower);
        this.navigationSystem = new NavigationSystem(navSystemType);
        this.LeftTurrel = new Turrel(ammoLeft);
        this.RightTurrel = new Turrel(ammoRight);
        secondconstrucktor++;
    }

    // Методи
    public void launch() {
        log("Корабель " + name + " запущено.");
    }

    public void navigateTo(String destination) {
        log("Корабель " + name + " рухається до " + destination + ".");
    }

    public void shoot(boolean IsLeftShoot, boolean IsRightShoot) {

        if (IsLeftShoot && !IsRightShoot && LeftTurrel.getAmmo()>0) {
            System.out.println("БамБамБімБім");
            LeftTurrel.setAmmo(LeftTurrel.getAmmo() - 1);
        }
        else if (!IsLeftShoot && IsRightShoot && RightTurrel.getAmmo()>0) {
            System.out.println("БімБімБамБам");
            RightTurrel.setAmmo(RightTurrel.getAmmo() - 1);
        }
        else if (IsLeftShoot && IsRightShoot && LeftTurrel.getAmmo()>0 && RightTurrel.getAmmo()>0) {
            System.out.println("БамБамБімБім БімБімБамБам");
            LeftTurrel.setAmmo(LeftTurrel.getAmmo()-1);
            RightTurrel.setAmmo(RightTurrel.getAmmo()-1);
        }
        else if(LeftTurrel.getAmmo()<=0){
            System.out.println("Недостатньо патронів у лівій турелі");
        }
        else if(RightTurrel.getAmmo()<=0){
            System.out.println("Недостатньо патронів у правій турелі");
        }

    }

    public void stop() {
        log("Корабель " + name + " зупинено.");
    }

    public void printStatus() {
        System.out.println("Статус корабля " + name + ":");
        System.out.println("Двигун: " + engine.getType() + ", Потужність: " + engine.getPower());
        System.out.println("Система навігації: " + navigationSystem.getType());
        System.out.println("К-сть патронів у лівій турелі: " + LeftTurrel.getAmmo());
        System.out.println("К-сть патронів у правій турелі: " + RightTurrel.getAmmo());
    }

    // Приватний метод для запису протоколу діяльності у файл
    private void log(String message) {
        try (FileWriter fileWriter = new FileWriter("spacecraft_log.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Get_fc()
    {
        System.out.println("К-сть об'єктів створених першим конструктором: " + firstconstrucktor);
    }

    public void Get_sc()
    {
        System.out.println("К-сть об'єктів створених другим конструктором: " + secondconstrucktor);
    }
    // Внутрішні класи, які описують складові частини корабля

}

