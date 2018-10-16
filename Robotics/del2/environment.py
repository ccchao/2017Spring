import constants as c

class ENVIRONMENT:
    def __init__(self, i):
        self.ID = i
        #print self.ID

        self.l = c.L
        self.w = c.L
        self.h = c.L
        
        if self.ID == 0 :
            self.Place_Light_Source_To_The_Front()
        elif self.ID == 1:
            self.Place_Light_Source_To_The_Right()
        elif self.ID == 2:
            self.Place_Light_Source_To_The_Back()
        elif self.ID == 3:
            self.Place_Light_Source_To_The_Left()

        print self.l,
        print self.w,
        print self.h,
        print self.x,
        print self.y,
        print self.z

    def Place_Light_Source_To_The_Front(self):
        self.x = 0
        self.y = 30*c.L
        self.z = c.L/2

    def Place_Light_Source_To_The_Right(self):
        self.x = 30*c.L
        self.y = 0
        self.z = c.L/2

    def Place_Light_Source_To_The_Back(self):
        self.x = 0
        self.y = -30*c.L
        self.z = c.L/2

    def Place_Light_Source_To_The_Left(self):
        self.x = -30*c.L
        self.y = 0
        self.z = c.L/2

    def Send_To(self, sim):
        sim.Send_Box(objectID = 6 , x=self.x, y=self.y, z=self.z, length=self.l, width=self.w, height=self.h)
        sim.Send_Light_Source(objectIndex = 6)




"""
import random
import math
from robot import ROBOT
from pyrosim import PYROSIM
import numpy
import constants as c

class INDIVIDUAL:
    def __init__(self, i):
        self.ID = i
        self.genome = numpy.random.random((4,8)) * 2 - 1
        
        #self.genome = numpy.random.random(4) * 2 - 1
        #print self.genome
        #exit()
        self.fitness = 0

    #def Evaluate(self, pb):
        #sim = PYROSIM(playPaused=False, evalTime=500, playBlind=pb)
        #robot = ROBOT( sim , self.genome )
        #sim.Start()
        #sim.Wait_To_Finish()
        #y = sim.Get_Sensor_Data(sensorID=4 , s=1 )
        #self.fitness = y[499]

    def Start_Evaluation(self, pb):
        self.sim = PYROSIM(playPaused=False, evalTime=c.evalTime, playBlind=pb)
        robot = ROBOT( self.sim , self.genome )
        self.sim.Start()

    def Compute_Fitness(self):
        self.sim.Wait_To_Finish()
        y = self.sim.Get_Sensor_Data(sensorID=4 , s=1 )
        self.fitness = y[c.evalTime-1]
        if self.fitness > 10 :
            self.fitness = 10
        del self.sim

    def Mutate(self):
        geneToMutateRow = random.randint(0,3)
        geneToMutateColumn = random.randint(0,7)
        self.genome[geneToMutateRow][geneToMutateColumn] = random.gauss( self.genome[geneToMutateRow][geneToMutateColumn] , math.fabs(self.genome[geneToMutateRow][geneToMutateColumn]) )

        if (self.genome[geneToMutateRow][geneToMutateColumn] > 1):
            self.genome[geneToMutateRow][geneToMutateColumn] = 1
        if (self.genome[geneToMutateRow][geneToMutateColumn] < -1):
            self.genome[geneToMutateRow][geneToMutateColumn] = -1
        
        #geneToMutate = random.randint(0,3)
        #self.genome[geneToMutate] = random.gauss( self.genome[geneToMutate] , math.fabs(self.genome[geneToMutate]) )

    def Print(self):
        print '[',
        print self.ID,
        print self.fitness,
        print '] ',
"""

