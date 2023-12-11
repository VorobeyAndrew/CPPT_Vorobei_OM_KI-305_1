from ChildClass import ReusableSpacecraft

spacecraft = ReusableSpacecraft("Apolon", "Hydrohen", 100, "GPS", 50, 50, 3)
spacecraft.launch()
spacecraft.navigate_to("Mars")
spacecraft.shoot(True, False)
spacecraft.print_status()
spacecraft.deploy_solar_panels()
spacecraft.stop()