package com.example;

import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;

import java.util.List;

public class PacketSniffer {

    public static void main(String[] args) throws Exception {

        // Get network devices
        List<PcapNetworkInterface> devices = Pcaps.findAllDevs();

        // Select first device
        PcapNetworkInterface device = devices.get(0);

        System.out.println("Using: " + device.getName());
        System.out.println("Capturing packets...\n");

        // Open device
        PcapHandle handle = device.openLive(
                65536,
                PcapNetworkInterface.PromiscuousMode.PROMISCUOUS,
                10
        );

        // Capture packets
        PacketListener listener = new PacketListener() {
            public void gotPacket(Packet packet) {
                System.out.println("-------------------------");
                System.out.println("Packet Captured!");
                System.out.println("Length: " + packet.length() + " bytes");
                System.out.println(packet);
            }
        };

        // Capture 10 packets
        handle.loop(10, listener);

        handle.close();
        System.out.println("\nCapture completed.");
    }
}
