# traffic-light-intersection-feature-house
Implemented a configurable traffic light simulator using FeatureHouse2. The program will simulate an intersection that is managed by traffic lights.

The variants of the simulation differ in the number of roads that merge at the intersection, whether there are pedestrian crossings present, and how the traffic lights behave.

The file model.xml contains the feature model for the project. This file must not be modified. The folder configs contains configurations for the project, that is, feature selections that define a variant of the simulation. You can activate one configuration at a time. FeatureIDE will automatically generate the sources for the currently active
configuration. The folder features is where the actual source code for the project lives. It contains a subfolder for each feature. The implementation for each feature must be done in the respective subfolder. In the folders for the features Base and Pedestrians, you can find an abstract class Intersection that I extended with our functionality. Make sure to read the documentation for this class in the actual source code in the provided skeleton! This class is used by the class Main–the class that manages the simulation to instantiate our implementation of the traffic light simulator.

Explanation of all features:

Base : Contains the base functionality that is included in all variants.

Roads : Note that this is an abstract feature and has no code associated with it. The subfeatures of this feature determine from which directions roads lead to the intersection.
        Each road automatically has a traffic light at the intersection. Traffic lights of opposing roads (e.g., left and right) always show the same light.
        
Left : Road from the left. This road is always present.

Right : Road from the right. This road is always present.

Bottom : Road from the bottom.

Top : Road from the top.

OrangeLight : Adds an orange light to traffic lights. Pedestrian traffic lights do not get an orange light. Traffic lights with an orange light take an additional 2 steps where               the light is orange when switching from green to red or from red to green. When a road’s traffic light is orange, the crossing lights must be red.

Pedestrians : Adds pedestrian traffic lights to each road that is present in the configuration. Pedestrian lights are green if the traffic light on the same road is red, and red
              otherwise. Also, pedestrians can now enqueue at the intersection. Pedestrians have an own queue per road. That is, per road and simulation step, one vehicle
              and one pedestrian can cross the intersection (if their respective traffic light is green).

Timed : The Left/Right roads start with a 10 steps long green phase. Then the traffic lights switch and the Bottom/Top roads get a 10 steps long green phase before the traffic
        lights switch again and the cycle repeats. Watch out how the addition of orange lights affect the duration of a complete cycle.

OnDemand : The Left/Right roads are green by default. When a vehicle queues at one of the Bottom/Top roads or a pedestrian queues at the Left/Right roads, the traffic lights
           switch to a 10 steps enduring green phase on the Bottom/Top roads, and then switches back. The Left/Right roads then need to have at least a 10 steps long green phase            before the lights can switch again.
           

Running the Simulation 

The project skeleton includes a run configuration you can use to start the simulation.

Once started, you can enter the following commands on the commandline:

vehicle <road> Enqueue a vehicle on <road>, where road can be one of left, right, top, bottom.
pedestrian <road> Enqueue a pedestrian on <road>, where road can be one of left, right, top, bottom.
step Advance the simulation by one step.
state Print the current state of the intersection.
