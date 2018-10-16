import random
import math
from robot import ROBOT
from pyrosim import PYROSIM
import numpy
import constants as c

class INDIVIDUAL:
    def __init__(self, i):
        self.ID = i
        self.genome = numpy.random.random((5,2)) * 2 - 1
        #self.genome = numpy.random.random((4,8)) * 2 - 1
        
        #self.genome = numpy.random.random(4) * 2 - 1
        #print self.genome
        #exit()
        self.fitness = 0

    def Start_Evaluation(self, env, pp, pb):
        self.sim = PYROSIM(playPaused=pp, evalTime=c.evalTime, playBlind=pb)
        robot = ROBOT( self.sim , self.genome )
        env.Send_To( self.sim )
        self.sim.Start()

    def Compute_Fitness(self):
        self.sim.Wait_To_Finish()
        y = self.sim.Get_Sensor_Data(sensorID=4)
        ya = self.sim.Get_Sensor_Data(sensorID=5)
        yb = self.sim.Get_Sensor_Data(sensorID=6)
        yc = self.sim.Get_Sensor_Data(sensorID=7)
        yd = self.sim.Get_Sensor_Data(sensorID=8)
        #self.fitness = y[c.evalTime-1]

        m=0
        if ya[c.evalTime-1] > m :
            m=ya[c.evalTime-1]
        if yb[c.evalTime-1] > m :
            m=yb[c.evalTime-1]
        if yc[c.evalTime-1] > m :
            m=yc[c.evalTime-1]
        if yd[c.evalTime-1] > m :
            m=yd[c.evalTime-1]
        
        self.fitness = self.fitness + y[c.evalTime-1] + m*20
        
        #if self.fitness > 10 :
        #    self.fitness = 10
        del self.sim

    def Mutate(self):
        geneToMutateRow = random.randint(0,4)
        #geneToMutateRow = random.randint(0,3)
        geneToMutateColumn = random.randint(0,1)

        """
        self.genome[geneToMutateRow][geneToMutateColumn] = random.gauss( self.genome[geneToMutateRow][geneToMutateColumn] , math.fabs(self.genome[geneToMutateRow][geneToMutateColumn]) )

        if (self.genome[geneToMutateRow][geneToMutateColumn] > 1):
            self.genome[geneToMutateRow][geneToMutateColumn] = 1
        if (self.genome[geneToMutateRow][geneToMutateColumn] < -1):
            self.genome[geneToMutateRow][geneToMutateColumn] = -1
        """

        self.genome[geneToMutateRow,geneToMutateColumn] = random.gauss( self.genome[geneToMutateRow,geneToMutateColumn] , math.fabs(self.genome[geneToMutateRow][geneToMutateColumn]) )

        if (self.genome[geneToMutateRow,geneToMutateColumn] > 1):
            self.genome[geneToMutateRow,geneToMutateColumn] = 1
        if (self.genome[geneToMutateRow,geneToMutateColumn] < -1):
            self.genome[geneToMutateRow,geneToMutateColumn] = -1
        

        #geneToMutate = random.randint(0,3)
        #self.genome[geneToMutate] = random.gauss( self.genome[geneToMutate] , math.fabs(self.genome[geneToMutate]) )

    def Print(self):
        print '[',
        print self.ID,
        print self.fitness,
        print '] ',


