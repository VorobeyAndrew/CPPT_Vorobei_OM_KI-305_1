from spacecraft import Spacecraft

class ReusableSpacecraft(Spacecraft):
    def __init__(self, name, engine_type, engine_power, nav_system_type, ammo_left, ammo_right, remaining_flights):
        super().__init__(name, engine_type, engine_power, nav_system_type, ammo_left, ammo_right)
        self.remaining_flights = remaining_flights
        self.is_launched = False

    def deploy_solar_panels(self):
        if self.is_launched:
            print("Сонячні панелі розгорнуті для підвищення енергоефективності.")
        else:
            print("Корабель не запущений.")

    def launch(self):
        if self.remaining_flights > 0:
            print(f"Корабель {self.name} запущено. К-сть запусків яка залишилась: {self.remaining_flights}")
            self.is_launched = True
            self.remaining_flights -= 1
        else:
            self.is_launched = False
            print("Неможливо запустити. Немає польотів для цього багаторазового космічного корабля.")

    def navigate_to(self, destination):
        if self.is_launched:
            print(f"Корабель {self.name} рухається до {destination}.")
        else:
            print("Корабель не запущений.")

    def shoot(self, is_left_shoot, is_right_shoot):
        if self.is_launched:
            if is_left_shoot and not is_right_shoot and self.left_turret.get_ammo() > 0:
                print("БамБамБімБім")
                self.left_turret.set_ammo(self.left_turret.get_ammo() - 1)
            elif not is_left_shoot and is_right_shoot and self.right_turret.get_ammo() > 0:
                print("БімБімБамБам")
                self.right_turret.set_ammo(self.right_turret.get_ammo() - 1)
            elif is_left_shoot and is_right_shoot and self.left_turret.get_ammo() > 0 and self.right_turret.get_ammo() > 0:
                print("БамБамБімБім БімБімБамБам")
                self.left_turret.set_ammo(self.left_turret.get_ammo() - 1)
                self.right_turret.set_ammo(self.right_turret.get_ammo() - 1)
            elif self.left_turret.get_ammo() <= 0:
                print("Недостатньо патронів у лівій турелі")
            elif self.right_turret.get_ammo() <= 0:
                print("Недостатньо патронів у правій турелі")
        else:
            print("Корабель не запущений.")

    def stop(self):
        if self.is_launched:
            print(f"Корабель {self.name} зупинено.")
            self.is_launched = False
        else:
            print("Корабель не запущений.")

    def print_status(self):
        print(f"Статус корабля {self.name}:")
        print(f"Двигун: {self.engine.get_type()}, Потужність: {self.engine.get_power()}")
        print(f"Система навігації: {self.navigation_system.get_type()}")
        print(f"К-сть патронів у лівій турелі: {self.left_turret.get_ammo()}")
        print(f"К-сть патронів у правій турелі: {self.right_turret.get_ammo()}")
        print(f"Решта польотів для цього космічного корабля багаторазового використання: {self.remaining_flights}")

#