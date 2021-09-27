package com.cegepst;

public class Byte {

    public String charByte;

    public Byte(String bits) {
        charByte = bits; //POUR 1 char (8 bit)
        addParityBit();
        System.out.println(charByte);
    }

    private void addParityBit() {
        if ((Integer.parseInt(charByte) % 2) == 0) {
            charByte += "0";
        } else {
            charByte += "1";
        }
    }

}
