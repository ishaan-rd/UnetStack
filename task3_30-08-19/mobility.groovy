import org.arl.fjage.*
import static org.arl.unet.Services.*
import org.arl.unet.utils.GPlot
import java.awt.Color

println '''
Motion model simulation
=======================
'''

//////////////////////////////////////////////////////////////////////////
////// Utility closure to log AUV locations every 10 seconds

trackAuvLocation = {
    def nodeinfo = agentForService NODE_INFO
    trace.moved(nodeinfo.address, nodeinfo.location, null)
    add new TickerBehavior(10000, {
        trace.moved(nodeinfo.address, nodeinfo.location, null)
    })
}

println 'Simulation AUV-1'
simulate 480.seconds, {
    def n = node('AUV-1', location: [0.m, 0.m, 0.m], mobility: true)
    n.startup = trackAuvLocation
    n.motionModel = [[time: 60.seconds, heading: 45.deg, speed: 1.mps],
                     [time: 180.seconds, diveRate: 0.1.mps],
                     [time: 300.seconds, turnRate: 2.dps, diveRate: 0.mps],
                     [time: 360.seconds, turnRate: 0.dps, speed: 1.mps]]
}

// read trace.nam to get simulation results
x = []
y = []
z = []
n = 0
new File('logs/trace.nam').eachLine { s ->
    if (s.startsWith('# BEGIN SIMULATION ')) n = s.substring(19) as int
    else if (s.startsWith('n ')) {
        x << ((s =~ /-x ([\-0-9\.]+)/)[0][1] as double)
        y << ((s =~ /-y ([\-0-9\.]+)/)[0][1] as double)
        z << ((s =~ /-Z ([\-0-9\.]+)/)[0][1] as double)
    }
}

// plot the paths
new GPlot('AUV Track: x-y', 600, 600).with {
    xlabel('x - meters')
    ylabel('y - meters')
    plot("AUV-1", x as double[], y as double[], Color.blue)
    axis(-100, 400, -100, 400)
    drawnow()
}

new GPlot('AUV Track: y-z', 600, 600).with {
    xlabel('y - meters')
    ylabel('z - meters')
    plot("AUV-1", y as double[], z as double[], Color.red)
    axis(-100, 400, -100, 400)
    drawnow()
}

new GPlot('AUV Track: x-z', 600, 600).with {
    xlabel('x - meters')
    ylabel('z - meters')
    plot("AUV-1", x as double[], z as double[], Color.green)
    axis(-100, 400, -100, 400)
    drawnow()
}

