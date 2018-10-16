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
        self.z = c.B

    def Place_Light_Source_To_The_Right(self):
        self.x = c.L*5
        self.y = -c.L*5
        self.z = c.B 

    def Place_Light_Source_To_The_Back(self):
        self.x = -c.L*5
        self.y = -c.L*5
        self.z = c.B 

    def Place_Light_Source_To_The_Left(self):
        self.x = -c.L*5
        self.y = c.L*5
        self.z = c.B 

    def Send_To(self, sim):
        sim.Send_Box(objectID = 6 , x=0, y=c.S/2-c.B, z=c.B, length=c.S, width=c.B*2, height=c.B*2, r=0, g=1, b=0) #up
        sim.Send_Box(objectID = 7 , x=c.S/2-c.B, y=0, z=c.B, length=c.B*2, width=c.S, height=c.B*2, r=0, g=1, b=0) #right
        sim.Send_Box(objectID = 8 , x=0, y=-c.S/2+c.B, z=c.B, length=c.S, width=c.B*2, height=c.B*2, r=0, g=1, b=0) #down
        sim.Send_Box(objectID = 9 , x=-c.S/2+c.B, y=0, z=c.B, length=c.B*2, width=c.S, height=c.B*2, r=0, g=1, b=0) #left
        sim.Send_Cylinder(objectID=10, x=c.S/2-c.B*2-c.H, y=c.S/2-c.B*2-c.H, z=c.H, length=0, radius=c.H, r=0, g=0, b=0) #up right hole
        sim.Send_Cylinder(objectID=11, x=c.S/2-c.B*2-c.H, y=-c.S/2+c.B*2+c.H, z=c.H, length=0, radius=c.H, r=0, g=0, b=0) #down right hole
        sim.Send_Cylinder(objectID=12, x=-c.S/2+c.B*2+c.H, y=-c.S/2+c.B*2+c.H, z=c.H, length=0, radius=c.H, r=0, g=0, b=0) #down left hole
        sim.Send_Cylinder(objectID=13, x=-c.S/2+c.B*2+c.H, y=c.S/2-c.B*2-c.H, z=c.H, length=0, radius=c.H, r=0, g=0, b=0) #up left hole
        sim.Send_Cylinder(objectID=14, x=self.x, y=self.y, z=self.z, length=0, radius=c.B, r=1, g=1, b=1) #front right wheel

        sim.Send_Light_Source(objectIndex = 14)




