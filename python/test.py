class Health:
    def __init__(self, value: float):
        self.max_hp: float
        self.cur_hp: float
    
    def set_max_hp(self, value: float) -> bool:
        if value < 1:
            return False
        
        self.max_hp = value
        if self.cur_hp > self.max_hp:
            self.cur_hp = self.max_hp
        return True
    
    def heal(self, value: float):
        self.cur_hp += value
        if self.cur_hp > self.max_hp:
            self.cur_hp = self.max_hp

class Normal:
    def __init__(self):
        self.name = "Normal Attack"
        self.scale = 1
    
    def __str__(self) -> str:
        return f"{self.name}: Perform a attack deal 100% ATK"

class Slash:
    def __init__(self):
        pass

class Bat:
    def __init__(self):
        pass

class Player:
    def __init__(self):
        self.hp = Health(100)
        self.atk = 15
        self.skills = [Normal()]
    
    def show_skill(self):
        for id, skill in enumerate(self.skills):
            print(id + 1, " | ", skill, sep='')

Player().show_skill()
