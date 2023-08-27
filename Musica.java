import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

public class Musica {
    public static void main(String[] args) {
        Thread musicThread = new Thread(() -> {
            try {
                File audioFile = new File("BLESSD-RYAN-CASTRO-OJITOS-ROJOS-REMIX-_VIAJE-3_.wav"); 
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                Thread.sleep(clip.getMicrosecondLength() / 40);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread inputThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Ingresa tu nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingresa tu edad: ");
                int edad = Integer.parseInt(scanner.nextLine());
                System.out.print("¿Cómo te sientes hoy? ");
                String estado = scanner.nextLine();

                System.out.println("\nGracias por proporcionar tus datos.");
                System.out.println("Nombre: " + nombre);
                System.out.println("Edad: " + edad);
                System.out.println("Estado de ánimo: " + estado);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa una edad válida.");
            }
        });

        System.out.println("Iniciando reproducción de música y solicitud de datos...");

        musicThread.start();
        inputThread.start();

        try {
            musicThread.join();
            inputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado. ¡Sigue disfrutando la canción!");
    }
}