import constants as c

class ENVIRONMENT:
    def __init__(self, i):
        self.ID = i
        #print self.ID

        self.l = c.S
        self.w = c.W*2
        self.h = c.W*2
        
        if self.ID == 0 :
            self.Place_Light_Source_To_The_Front()
        elif self.ID == 1:
            self.Place_Light_Source_To_The_Right()
        elif self.ID == 2:
            self.Place_Light_Source_To_The_Back()
        elif self.ID == 3:
            self.Place_Light_Source_To_The_Left()

        #print self.l,
        #print self.w,
        #print self.h,
        #print self.x,
        #print self.y,
        #print self.z

    def Place_Light_Source_To_The_Front(self):
        self.x = c.L*5
        self.y = c.L*5
        self.z = c.B+c.H

    def Place_Light_Source_To_The_Right(self):
        self.x = c.L*5
        self.y = -c.L*5
        self.z = c.B+c.H

    def Place_Light_Source_To_The_Back(self):
        self.x = -c.L*5
        self.y = -c.L*5
        self.z = c.B+c.H

    def Place_Light_Source_To_The_Left(self):
        self.x = -c.L*5
        self.y = c.L*5
        self.z = c.B+c.H

    def Send_To(self, sim):
        self.Send_Objects(sim)
        self.Send_Joints(sim)
        sim.Send_Light_Source(objectIndex = 13)
        self.Send_Sensor(sim)
    
    
    def Send_Objects(self, sim):
        sim.Send_Box(objectID = 6 , x=0, y=0, z=c.H/2, length=c.S, width=c.S+c.H*2, height=c.H, r=0, g=0.7, b=0.6) #middle
        sim.Send_Box(objectID = 7 , x=c.S/2+c.H/2, y=0, z=c.H/2, length=c.H, width=c.S, height=c.H, r=0, g=0.7, b=0.6) #right
        sim.Send_Box(objectID = 8 , x=-c.S/2-c.H/2, y=0, z=c.H/2, length=c.H, width=c.S, height=c.H, r=0, g=0.7, b=0.6) #left
        sim.Send_Box(objectID = 9 , x=0, y=c.S/2+c.H*1.5, z=c.H, length=c.S+c.H*4, width=c.H, height=c.H*2, r=0, g=0.5, b=0.4) #up outside
        sim.Send_Box(objectID = 10 , x=c.S/2+c.H*1.5, y=0, z=c.H, length=c.H, width=c.S+c.H*4, height=c.H*2, r=0, g=0.5, b=0.4) #right outside
        sim.Send_Box(objectID = 11 , x=0, y=-c.S/2-c.H*1.5, z=c.H, length=c.S+c.H*4, width=c.H, height=c.H*2, r=0, g=0.5, b=0.4) #down outside
        sim.Send_Box(objectID = 12 , x=-c.S/2-c.H*1.5, y=0, z=c.H, length=c.H, width=c.S+c.H*4, height=c.H*2, r=0, g=0.5, b=0.4) #left outside
        
        sim.Send_Cylinder(objectID=13, x=c.L*5, y=c.L*5, z=c.B+c.H, length=0, radius=c.B, r=0, g=1, b=0) #front right ball
    
        sim.Send_Box(objectID = 14 , x=c.S/2+c.H/2, y=c.S/2+c.H/2, z=c.F/2, length=c.F, width=c.F, height=c.F, r=0, g=0, b=0) #up-right sensor
        sim.Send_Box(objectID = 15 , x=c.S/2+c.H/2, y=-c.S/2-c.H/2, z=c.F/2, length=c.F, width=c.F, height=c.F, r=0, g=0, b=0) #down-right sensor
        sim.Send_Box(objectID = 16 , x=-c.S/2-c.H/2, y=-c.S/2-c.H/2, z=c.F/2, length=c.F, width=c.F, height=c.F, r=0, g=0, b=0) #down-left sensor
        sim.Send_Box(objectID = 17 , x=-c.S/2-c.H/2, y=c.S/2+c.H/2, z=c.F/2, length=c.F, width=c.F, height=c.F, r=0, g=0, b=0) #up-left sensor
    
        if self.ID != 0:
            sim.Send_Cylinder(objectID=18, x=self.x, y=self.y, z=self.z, length=0, radius=c.B, r=1, g=1, b=0) #second ball
    

    def Send_Joints(self, sim):
        sim.Send_Joint(jointID=3, firstObjectID=7, secondObjectID=6, x=c.S/2, y=0, z=c.H/2, lo=0, hi=0) #right
        sim.Send_Joint(jointID=4, firstObjectID=8, secondObjectID=6, x=-c.S/2, y=0, z=c.H/2, lo=0, hi=0) #left
        
        sim.Send_Joint(jointID=5, firstObjectID=9, secondObjectID=6, x=0, y=c.S/2+c.H, z=c.H, lo=0, hi=0) #up outside
        sim.Send_Joint(jointID=6, firstObjectID=10, secondObjectID=7, x=c.S/2+c.H, y=0, z=c.H, lo=0, hi=0) #right outside
        sim.Send_Joint(jointID=7, firstObjectID=11, secondObjectID=6, x=0, y=-c.S/2-c.H, z=c.H, lo=0, hi=0) #down outside
        sim.Send_Joint(jointID=8, firstObjectID=12, secondObjectID=8, x=-c.S/2-c.H, y=0, z=c.H, lo=0, hi=0) #left outside
        
        sim.Send_Joint(jointID=9, firstObjectID=9, secondObjectID=10, x=c.S/2+c.H*1.5, y=c.S/2+c.H*1.5, z=c.H, lo=0, hi=0) #up-right outside
        sim.Send_Joint(jointID=10, firstObjectID=10, secondObjectID=11, x=c.S/2+c.H*1.5, y=-c.S/2-c.H*1.5, z=c.H, lo=0, hi=0) #down-right outside
        sim.Send_Joint(jointID=11, firstObjectID=11, secondObjectID=12, x=-c.S/2-c.H*1.5, y=-c.S/2-c.H*1.5, z=c.H, lo=0, hi=0) #down-left outside
        sim.Send_Joint(jointID=12, firstObjectID=12, secondObjectID=9, x=-c.S/2-c.H*1.5, y=c.S/2+c.H*1.5, z=c.H, lo=0, hi=0) #up-left outside

    def Send_Sensor(self, sim):
        sim.Send_Light_Sensor(sensorID=5, objectID = 14)
        sim.Send_Light_Sensor(sensorID=6, objectID = 15)
        sim.Send_Light_Sensor(sensorID=7, objectID = 16)
        sim.Send_Light_Sensor(sensorID=8, objectID = 17)
        
        if self.ID != 0:
            sim.Send_Light_Sensor(sensorID=9, objectID=18)
            sim.Send_Position_Sensor(sensorID=10, objectID=18)
