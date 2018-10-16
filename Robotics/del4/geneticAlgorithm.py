"""import random
from robot import ROBOT
from individual import INDIVIDUAL
import matplotlib.pyplot as plt
from pyrosim import PYROSIM
import copy
import pickle
"""

from environments import ENVIRONMENTS
from population import POPULATION
import constants as c
import copy

envs = ENVIRONMENTS()

parents = POPULATION(c.popSize)
parents.Initialize()
parents.Evaluate(envs, pp=True, pb=True)

#for i in parents.p:
#    parents.p[i].Start_Evaluation(True)

print '0',
parents.Print()


# line b
for g in range(1,c.numGens):
    # line c
    children = POPULATION(c.popSize)
    # line d
    children.Fill_From(parents)
    children.Evaluate(envs, pp=True, pb=True)
    print g,
    children.Print()
    #children.Print()
    parents = copy.deepcopy(children)
    #parents.ReplaceWith(children)

#parents.p[0].Start_Evaluation(envs, pp=True, pb=True)
for e in range(0,c.numEnvs):
    parents.p[0].Start_Evaluation(envs.envs[e], pp=True, pb=False)
    parents.p[0].sim.Wait_To_Finish()



#for i in parents.p:
#    parents.p[i].Start_Evaluation(False)



