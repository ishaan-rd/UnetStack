import org.arl.unet.link.ReliableLink
import org.arl.unet.sim.channels.*
import org.arl.fjage.*
import org.arl.unet.net.*

import org.arl.unet.shell.*

//platform = RealTimePlatform
channel.model = ProtocolChannelModel

channel.soundSpeed = 1500.mps          // c
channel.communicationRange = 100.m     // Rc
channel.detectionRange = 110.m
channel.interferenceRange = 200.m

println '''
6-node network with ping daemons
--------------------------------

You can interact with node 1 in the console shell. For example, try:
> ping 2
> help ping

When you are done, exit the shell by pressing ^D or entering:
> shutdown
'''

// run the simulation infinitely
simulate {
    def n1 = node '1', remote: 1101, address: 1, location: [ 0.m, 0.m, 0.m], shell: true, stack: { container ->
        container.add 'ping', new NewPingDaemon()
        container.add 'link', new ReliableLink()
        container.add 'router', new Router()
        container.add 'rdp', new RouteDiscoveryProtocol()
        container.shell.addInitrc "${script.parent}/../etc/fshrc.groovy"
    }
//    n1.startup = {
//        router.send new RouteDiscoveryNtf(to: 3, nextHop: 2)
//    }

    node '2', remote: 1102, address: 2, location: [ 0.m, 0.m, -75.m], shell: 5102, stack: { container ->
        container.add 'ping', new NewPingDaemon()
        container.add 'link', new ReliableLink()
        container.add 'router', new Router()
        container.add 'rdp', new RouteDiscoveryProtocol()
    }

    node '3', remote: 1103, address: 3, location: [0.m, 0.m, -120.m], shell: 5103, stack: { container ->
        container.add 'ping', new NewPingDaemon()
        container.add 'link', new ReliableLink()
        container.add 'router', new Router()
        container.add 'rdp', new RouteDiscoveryProtocol()
    }

    node '4', remote: 1104, address: 4, location: [0.m, 0.m, -150.m], shell: 5104, stack: {container ->
        container.add 'ping', new NewPingDaemon()
        container.add 'link', new ReliableLink()
        container.add 'router', new Router()
        container.add 'rdp', new RouteDiscoveryProtocol()
    }

    node '5', remote: 1105, address: 5, location: [0.m, 0.m, -220.m], shell: 5105, stack: {container ->
        container.add 'ping', new NewPingDaemon()
        container.add 'link', new ReliableLink()
        container.add 'router', new Router()
        container.add 'rdp', new RouteDiscoveryProtocol()
    }

    node '6', remote: 1106, address: 6, location: [0.m, 0.m, -500.m], shell: 5106, stack: {container ->
        container.add 'ping', new NewPingDaemon()
        container.add 'link', new ReliableLink()
        container.add 'router', new Router()
        container.add 'rdp', new RouteDiscoveryProtocol()
    }
}
