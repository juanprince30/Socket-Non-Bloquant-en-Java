import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.lang.System;


public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Debut du programme !!");
        NonBlockingSocket prince=new NonBlockingSocket();
        prince.socket();
    }
}