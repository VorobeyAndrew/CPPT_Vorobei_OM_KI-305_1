interface Reusable {
    void deploySolarPanels();
}
interface Task {
    void TestFunction();
}

public class ReusableSpacecraft extends Spacecraft implements Reusable, Task {

    private int remainingFlights;
    private boolean isLaunched = false;

    public ReusableSpacecraft(String name, String engineType, int enginePower, String navSystemType, int ammoLeft, int ammoRight, int remainingFlights) {
        super(name, engineType, enginePower, navSystemType, ammoLeft, ammoRight);
        this.remainingFlights = remainingFlights;
    }

    @Override
    public void deploySolarPanels()
    {
        if(isLaunched == true)
        {
            System.out.println("Сонячні панелі розгорнуті для підвищення енергоефективності.");
        }
        else
        {
            System.out.println("Корабель не запущений.");
        }
    }

    @Override
    public void launch() {
        if (remainingFlights > 0) {
            System.out.println("Корабель " + name + " запущено." + "К-сть запусків яка залишилась:" + remainingFlights);
            isLaunched = true;
            remainingFlights--;
        } else {
            isLaunched = false;
            System.out.println("Неможливо запустити. Немає польотів для цього багаторазового космічного корабля.");
        }
    }

    @Override
    public void navigateTo(String destination) {
        if (isLaunched == true) {
            System.out.println("Корабель " + name + " рухається до " + destination + ".");
        } else {
            System.out.println("Корабель не запущений.");
        }
    }

    @Override
    public void shoot(boolean IsLeftShoot, boolean IsRightShoot) {
        if (isLaunched == true) {
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
        } else {
            System.out.println("Корабель не запущений.");
        }
    }

    @Override
    public void stop() {
        if (isLaunched == true) {
            System.out.println("Корабель " + name + " зупинено.");
            isLaunched = false;
        } else {
            System.out.println("Корабель не запущений.");
        }
    }

    @Override
    public void printStatus() {
        System.out.println("Статус корабля " + name + ":");
        System.out.println("Двигун: " + engine.getType() + ", Потужність: " + engine.getPower());
        System.out.println("Система навігації: " + navigationSystem.getType());
        System.out.println("К-сть патронів у лівій турелі: " + LeftTurrel.getAmmo());
        System.out.println("К-сть патронів у правій турелі: " + RightTurrel.getAmmo());
        System.out.println("Решта польотів для цього космічного корабля багаторазового використання: " + remainingFlights);
    }

    @Override
    public void TestFunction() {
        System.out.println("Тест");
    }
}

