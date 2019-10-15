import org.arl.unet.*
import org.arl.unet.net.*
import org.arl.unet.phy.RxFrameNtf
import org.arl.unet.phy.TxFrameNtf

// documentation for the 'ping' command
doc['ping'] = '''ping - ping a remote node

Examples:
  ping 2                // ping node address 2 thrice
  ping 3,1              // ping node address 3 once
'''

subscribe phy
subscribe router
subscribe link


// add a closure to define the 'ping' command
ping = { addr, count = 1 ->
    println "PING $addr"
    count.times {
        router << new DatagramReq(to: addr, protocol: Protocol.USER)
        def txTime = time()
        def rxNtf = receive({ it instanceof DatagramNtf && it.from == addr}, 8000)
        def rxTime = time()
        if (rxNtf && rxNtf.from == addr)
            println "Response from ${rxNtf.from} to ${rxNtf.to}: time = ${rxTime - txTime} ms"
        else
            println "Request timeout"
    }
}
