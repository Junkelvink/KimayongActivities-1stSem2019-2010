class Horse:
    def name (self, name):
         self._name = name
    def color (self, color):
         self._color = color
    def birthYear (self, birthYear):
         self._birthYear = birthYear
    def get_name(self):
        return self._name
    def set_name(self, n):
        self._name = n
    def get_color(self):
        return self._color
    def set_color(self, c):
        self._color = c
    def get_birthYear(self):
        return self._birthYear
      
    def set_birthYear(self, b):
        self._birthYear = b
        
class RaceHorse(Horse):
    def __init__(self, race = 0):
         self._race = race
      
    # getter method
    def get_race(self):
        return self._race
      
    # setter method
    def set_race(self, x):
        self._race = x
  
horsy = RaceHorse()
horsy.set_race(21)
horsy.set_name("Jun Kelvin") 
horsy.set_color("Blue")
horsy.set_birthYear("2001")

print("Horse Details\nname: ", horsy.get_name())
print("Color: ", horsy.get_color())
print("Birth Year: ", horsy.get_birthYear())
print("Number of Race: ",horsy.get_race())
  