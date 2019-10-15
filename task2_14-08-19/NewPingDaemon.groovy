import org.arl.fjage.*
import org.arl.unet.*
import org.arl.unet.net.*

class NewPingDaemon extends UnetAgent {
    def router
    int addr

    final static int PING_PROTOCOL = Protocol.USER

    void addroute(int to, int via) {
        router.send new RouteDiscoveryNtf(to: to, nextHop: via, reliability: false)
    }

    void startup() {
        def phy = agentForService Services.PHYSICAL
        subscribe topic(phy)

        router = agentForService Services.ROUTING
        subscribe topic(router)

        def nodeInfo = agentForService Services.NODE_INFO
        addr = nodeInfo.address

        switch (addr) {
            case 1:
                addroute 2,2
                addroute 3,2
                addroute 4,2
                addroute 5,2
                addroute 6,2
                break
            case 2:
                addroute 1,1
                addroute 3,3
                addroute 4,3
                addroute 5,3
                addroute 6,3
                break
            case 3:
                addroute 1,2
                addroute 2,2
                addroute 4,4
                addroute 5,4
                addroute 6,4
                break
            case 4:
                addroute 1,3
                addroute 2,3
                addroute 3,3
                addroute 5,5
                addroute 6,5
                break
            case 5:
                addroute 1,4
                addroute 2,4
                addroute 3,4
                addroute 4,4
                addroute 6,6
                break
            case 6:
                addroute 1,5
                addroute 2,5
                addroute 3,5
                addroute 4,5
                addroute 5,5
                break
        }
    }

    void processMessage(Message msg) {
        if (msg instanceof DatagramNtf && msg.protocol == PING_PROTOCOL)
            router.send new DatagramReq(recipient: msg.sender, to: msg.from, protocol: Protocol.DATA)
    }
}
