import os

class Spacecraft:
    def __init__(self, name, engine_type, engine_power, nav_system_type, ammo_left, ammo_right):
        self.name = name
        self.engine = self.Engine(engine_type, engine_power)
        self.navigation_system = self.NavigationSystem(nav_system_type)
        self.left_turret = self.Turret(ammo_left)
        self.right_turret = self.Turret(ammo_right)

    def launch(self):
        pass

    def navigate_to(self, destination):
        pass

    def shoot(self, is_left_shoot, is_right_shoot):
        pass

    def stop(self):
        pass

    def print_status(self):
        pass

    def log(self, message):
        log_file_path = "spacecraft_log.txt"
        with open(log_file_path, "a") as file:
            file.write(message + "\n")

    class Engine:
        def __init__(self, engine_type, power):
            self.type = engine_type
            self.power = power

        def get_type(self):
            return self.type

        def get_power(self):
            return self.power

    class NavigationSystem:
        def __init__(self, nav_type):
            self.type = nav_type

        def get_type(self):
            return self.type

    class Turret:
        def __init__(self, ammo):
            self.ammo = ammo

        def get_ammo(self):
            return self.ammo

        def set_ammo(self, ammo):
            self.ammo = ammo