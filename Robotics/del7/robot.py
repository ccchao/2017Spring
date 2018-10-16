import constants as c

class ROBOT:
    def __init__(self, sim, wts):
        self.Send_Objects(sim)
        self.Send_Joints(sim)
        self.Send_Sensors(sim)
        self.Send_Neurons(sim)
        self.Send_Synapses(sim,wts)

    def Send_Objects(self,sim):
        sim.Send_Box(objectID=0, x=0, y=0, z=c.L/2+c.W+c.H, length=c.L, width=c.L, height=c.L, r=1, g=1, b=1) #body
        sim.Send_Cylinder(objectID=1, x=c.L/2, y=c.L/2, z=c.W+c.H, length=0, radius=c.W, r=1, g=0, b=0) #front right wheel
        sim.Send_Cylinder(objectID=2, x=-c.L/2, y=c.L/2, z=c.W+c.H, length=0, radius=c.W, r=1, g=0, b=0) #front left wheel
        sim.Send_Cylinder(objectID=3, x=c.L/2, y=-c.L/2, z=c.W+c.H, length=0, radius=c.W, r=0, g=0, b=1) #rear right wheel
        sim.Send_Cylinder(objectID=4, x=-c.L/2, y=-c.L/2, z=c.W+c.H, length=0, radius=c.W, r=0, g=0, b=1) #rear left wheel
        #sim.Send_Cylinder(objectID=5, x=0, y=c.L/2+c.P/2, z=c.L/2+c.W+c.H, length=c.P, radius=c.W, r1=0, r2=1, r3=0, r=1, g=0, b=1) #pole
        sim.Send_Cylinder(objectID=5, x=0, y=c.L/2+c.P/2, z=c.W*2+c.H, length=c.P, radius=c.W*0.8, r1=0, r2=1, r3=0, r=1, g=0, b=1) #pole


    def Send_Joints(self,sim):
        sim.Send_Joint(jointID=0, firstObjectID=0, secondObjectID=1, x=c.L/2, y=c.L/2, z=c.W+c.H, n1=1, n2=0, n3=0, lo=-3.14159*2, hi=3.14159*2, positionControl=False) #front right wheel
        sim.Send_Joint(jointID=1, firstObjectID=0, secondObjectID=2, x=-c.L/2, y=c.L/2, z=c.W+c.H, n1=1, n2=0, n3=0, lo=-3.14159*2, hi=3.14159*2, positionControl=False) #front left wheel
        sim.Send_Joint(jointID=0, firstObjectID=0, secondObjectID=3, x=c.L/2, y=-c.L/2, z=c.W+c.H, n1=1, n2=0, n3=0, lo=-3.14159*2, hi=3.14159*2, positionControl=False) #rear right wheel
        sim.Send_Joint(jointID=1, firstObjectID=0, secondObjectID=4, x=-c.L/2, y=-c.L/2, z=c.W+c.H, n1=1, n2=0, n3=0, lo=-3.14159*2, hi=3.14159*2, positionControl=False) #rear left wheel

        sim.Send_Joint(jointID=2, firstObjectID=0, secondObjectID=5, x=0, y=c.L/2, z=c.W*2+c.H, lo=0, hi=0) #pole


    def Send_Sensors(self,sim):
        sim.Send_Touch_Sensor( sensorID = 0 , objectID = 1 )
        sim.Send_Touch_Sensor( sensorID = 1 , objectID = 2 )
        sim.Send_Touch_Sensor( sensorID = 2 , objectID = 3 )
        sim.Send_Touch_Sensor( sensorID = 3 , objectID = 4 )

        sim.Send_Light_Sensor(sensorID=4, objectID = 5) 


    def Send_Neurons(self,sim):
        for s in range(0,4+1):
            sim.Send_Sensor_Neuron(neuronID=s, sensorID=s)
        sim.Send_Motor_Neuron(neuronID=5, jointID=0, tau=0.08)
        sim.Send_Motor_Neuron(neuronID=6, jointID=1, tau=0.08)

    def Send_Synapses(self,sim, wts):
        for j in range(0,5):
            sim.Send_Synapse(sourceNeuronID=j, targetNeuronID=5, weight=wts[j][0] )
            sim.Send_Synapse(sourceNeuronID=j, targetNeuronID=6, weight=wts[j][1] )

