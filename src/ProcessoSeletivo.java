import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", "JULIA", "MARIA", "JOAO", "PAULO"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

        
        
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false; 
        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if(continuaTentando)
                tentativasRealizadas++;
            else
                System.out.println("\nCONTATO REALIZADO COMSUCESSO");

        }while (continuaTentando && tentativasRealizadas < 3);

        if (atendeu)
        System.out.println("CONTATO CONTATO " + candidato + " em " + tentativasRealizadas + " tentaivas ");
        else
            System.out.println("NÃO FOI POSSIVEL REALIZAR O CONTATO COM O CANDIDATO");
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }


    static void imprimirSelecionados() {

        String [] candidatos = {"FELIPE", "JULIA", "MARIA", "JOAO", "PAULO"};
        System.out.println("imprimindo a lista de candidatos informando o indice de elemento:");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n" + (indice + 1) + " é" + candidatos[indice]);

        }

        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi : " + candidato);
        }
    }


    static void selecionarCandidatos() {
        String [] candidatos = {"FELIPE", "JULIA", "MARIA", "JOAO", "PAULO","stevs", "JULIANA", "MARCOS", "LUCAS", "GUSTAVO"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {

            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato: " + candidato + " Solicitou este valor de salario: " + salarioPretendido);
            

            if (salarioBase > salarioPretendido) {
                System.out.println("O candidato: " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }

            candidatosAtual++;

        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } 
        else if (salarioBase == salarioPretendido) {
            System.out.println("ligar para o candidato com contra proposta");

        }
        else {
            System.out.println("Aguardando resultado demais candidatos");
        }
    }
}