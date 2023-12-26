package com.ina.poc.jpos;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class iso8583JPosUnpack {

    public static void main(String[] args) throws ISOException {
        GenericPackager packager = new GenericPackager("ISO8583XML/iso8583JPosXml.xml");

        // Setting packager
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);

        // This is the ISO8583 Message that we will Unpack
        String isoMessage = "010032200000000100000200000000000050000221151855123456013Example Value";

        // Convert ISO8583 Message String to byte[]
        byte[] bIsoMessage = isoMessage.getBytes();

        // Unpack the message
        isoMsg.unpack(bIsoMessage);

        // Print the unpacked ISO8583
        System.out.println("MTI='" + isoMsg.getMTI() + "'");
        for (int i = 1; i <= isoMsg.getMaxField(); i++) {
            if (isoMsg.hasField(i)) {
                System.out.println(i + "='" + isoMsg.getString(i) + "'");
            }
        }
    }
}
