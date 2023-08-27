import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;
//////////////////////////////////////////////////////////////
public class Musica {
    public static void main(String[] args) {
        Thread musica = new Thread(() -> {
            try {
                File audio = new File("BLESSD-RYAN-CASTRO-OJITOS-ROJOS-REMIX-_VIAJE-3_.wav"); 
                AudioInputStream audio01 = AudioSystem.getAudioInputStream(audio);
                Clip reproduccion = AudioSystem.getClip();
                reproduccion.open(audio01);
                reproduccion.start();
                Thread.sleep(reproduccion.getMicrosecondLength() / 40);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
////////////////////////////////////////////////////////////////////
        Thread inputThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("INGRESE SU NOMBRE");
                String nombre = scanner.nextLine();
                System.out.println("INGRESE SU EDAD: ");
                int edad = Integer.parseInt(scanner.nextLine());
                System.out.println("COMO TE SIENTES BB");;
                String estado = scanner.nextLine();
                System.out.println("CARRERA: ");
                String carrera = scanner.nextLine();
                System.out.println("SEMESTRE: ");
                String semestre = scanner.nextLine();


                System.out.println("\n GRACIAS POR INGRESAR LOS DATOS JOVEN MUY AMABLE ES USTED.");
                System.out.println("NOMBRE: " + nombre);
                System.out.println("EDAD: " + edad);
                System.out.println("ESTADO DE ANIMO: " + estado);
                System.out.println("CARRERA: " +carrera);
                System.out.println("SEMESTRE: " +semestre);
            } catch (NumberFormatException e) 
            
            {
                System.out.println("Ingresa una edad válida.");
            }
        });

        

        musica.start();
        inputThread.start();

        try {
            musica.join();
            inputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




