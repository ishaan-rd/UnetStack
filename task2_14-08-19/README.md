# Extend the 'ping' example in UnetStack

The ping example given in UnetStack works with only three nodes 1, 2 and 3. The shell connects to node 1 and the nodes 2 and 3 can be pinged using the command “ping <node_name>, <count>” where the count is the number of times that node will be pinged and is set to three by default. The nodes 2 and 3 are both in the communication range of 1. The task here was to extend this setup to work with multiple nodes.

## File structure

* src/NewPingDaemon.groovy
* sim/simple_sim.groovy
* etc/fshrc.groovy
