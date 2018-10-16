from environment import ENVIRONMENT
import constants as c

class ENVIRONMENTS:
    def __init__ (self):
        self.envs = {}
        for i in range(0,c.numEnvs):
            self.envs[i] = ENVIRONMENT(i)



"""
from individual import INDIVIDUAL
import copy
import random

class POPULATION:
    def __init__ (self, popSize):
        self.p = {}
        self.popSize = popSize

        #for i in range(0,popSize):
        #    self.p[i] = INDIVIDUAL(i)

    def Print (self):
        for i in self.p:
            if ( i in self.p ):
                self.p[i].Print()
        print

    def Evaluate (self):
        for i in self.p:
            self.p[i].Start_Evaluation(True)
        for i in self.p:
            self.p[i].Compute_Fitness()

    def Mutate (self):
        for i in self.p:
            self.p[i].Mutate()

    def ReplaceWith(self,other):
        for i in self.p:
            if ( self.p[i].fitness < other.p[i].fitness ):
                self.p[i] = other.p[i]

    def Initialize(self):
        for i in range(0,self.popSize):
            self.p[i] = INDIVIDUAL(i)

    def Fill_From(self,other):
        self.Copy_Best_From(other)
        self.Collect_Children_From(other)

    def Copy_Best_From(self,other):
        highest=-1
        for j in range(0,other.popSize):
            if ( other.p[j].fitness > highest ):
                highest=other.p[j].fitness
                i=j
        self.p[0] = copy.deepcopy(other.p[i])

    def Collect_Children_From(self,other):
        for j in range(1,other.popSize):
            #self.p[j] = copy.deepcopy(other.p[j])
            winner = other.Winner_Of_Tournament_Selection()
            self.p[j] = copy.deepcopy(winner)
            self.p[j].Mutate()

    def Winner_Of_Tournament_Selection(other):
        p1 = random.randint(0,other.popSize-1)
        p2 = random.randint(0,other.popSize-1)
        while p2 == p1:
            p2 = random.randint(0,other.popSize-1)
        if other.p[p1].fitness > other.p[p2].fitness:
            return other.p[p1]
        else:
            return other.p[p2]
"""
