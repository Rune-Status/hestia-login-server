package world.gregs.hestia.network.worlds.out

import world.gregs.hestia.network.packets.Packet
import world.gregs.hestia.network.worlds.WorldList
import world.gregs.hestia.services.int

class WorldListPacket(worlds: WorldList, worldConfiguration: Boolean = true, worldStatus: Boolean = true) : Packet.Builder(88, Packet.Type.VAR_SHORT) {

    init {
        writeByte(1)
        writeByte(if(worldConfiguration) 2 else 0)
        writeByte(worldStatus.int)
        val list = worlds.get()
        if (worldConfiguration) {
            writeSmart(list.size)
            list.forEach {
                writeSmart(it.country)
                writeByte(0)//For string below
                writeString(it.region)
            }
            writeSmart(0)
            writeSmart(list.size + 1)
            writeSmart(list.size)
            list.forEachIndexed { index, world ->
                writeSmart(world.id)
                writeByte(index)//Country/region index
                writeInt(world.flag)
                writeByte(0)//For string below
                writeString(world.activity)
                writeByte(0)//For string below
                writeString(world.ip)
            }
            writeInt(0)//Passed back in ping packet - latency
        }
        if (worldStatus) {
            list.forEach {
                writeSmart(it.id)
                writeShort(it.size)
            }
        }
    }
}