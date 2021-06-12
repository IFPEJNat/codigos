import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EchoServer
{
    public static void main(String[] args )
    {
        try
        {
            ServerSocket s = new ServerSocket(9000);
            Socket incoming = s.accept( );
    
            try
            {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
                
                out.println("Hello! Welcome to NGJ server!");
                out.println("1: System IP");
                out.println("2: System hour");
                out.println("3: System Used Port");
                out.println("4: System Total Space");
                out.println("5: System Free Space");
                out.println("6: System Usable Space");
                out.println("0: Exit");
                out.println();
                out.println("Type ENTER to begin");

// echo client input
                boolean done = false;
                
                while(!done)
                {
                    String line = in.nextLine();
                    File diskPartition = new File("C:");
                    
                    switch(line)
                    {
                        default:
                            out.println();
                            out.println("Choose an option:");
                        break;
                        
                        case "1":
                            System.out.println("Client selected 1");
                            out.println("IP address: " + InetAddress.getLocalHost());
                            out.println();
                            out.println("Choose an option:");
                        break;
                        
                        case "2":
                            System.out.println("Client selected 2");
                            DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                            out.println("Date and Time: "+ date.format(LocalDateTime.now()));
                            out.println();
                            out.println("Choose an option:");                         
                        break;

                        case "3":
                            System.out.println("Client selected 3");
                            out.println("Port used: " + incoming.getLocalPort());
                            out.println();
                            out.println("Choose an option:");                        
                        break;

                        case "4":
                            System.out.println("Client selected 4");
                            long totalCapacity = diskPartition.getTotalSpace();
                            out.println("Disk capacity C: " + totalCapacity/(1024*1024*1024) + "GB");
                            out.println();
                            out.println("Choose an option:");                          
                        break;

                        case "5":
                            System.out.println("Client selected 5");
                            long freeSpace = diskPartition.getFreeSpace();
                            out.println("Free space C: " + freeSpace/(1024*1024*1024) + "GB");
                            out.println();
                            out.println("Choose an option:");                       
                        break;

                        case "6":
                        System.out.println("Client selected 6");
                            long usableSpace = diskPartition.getUsableSpace();
                            out.println("Usable space C: " + usableSpace/(1024*1024*1024) + "GB");
                            out.println();
                            out.println("Choose an option:");                       
                        break;

                        case "0":
                            System.out.println("Conection closed");
                            done = true;
                            in.close();
                        break;
                    }
                }
            }   
                    
            finally 
            { 
                incoming.close();
                s.close();             
            }    
        } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
    } 
} 
