import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la palabra secreta:");
        String palabraSecreta = scanner.nextLine().toLowerCase();
        // Limpiar la pantalla para que la palabra secreta no sea visible (solo en terminales que soportan ANSI escape codes)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        //String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;


        // Arreglos:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Estructura de control
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            
        }

        // Estructura de control
        while(!palabraAdivinada && intentos < intentosMaximos){

            System.out.println("Palabra a adiviniar: " + String.valueOf(letrasAdivinadas));

            System.out.println("Introduce una letra, por favor");

            //usamos la clase scanner para pedir letra
            char letra = scanner.next().charAt(0);

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {

                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }

            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("¡Felicidades, has adivinado la palabra secreta: " + palabraSecreta);
            }

        }
        
        if(!palabraAdivinada){
            System.out.println("¡Que pena te has quedado sin intentos! GAME COER");
        }

        scanner.close();
    
    }
}
