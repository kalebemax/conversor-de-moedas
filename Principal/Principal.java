package Principal;

import Conversor.BuscaDados;
import Conversor.TaxaDeCambio;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("""
                *****************************************************
                Seja bem-vindo(a) ao Conversor de Moeda = :)
                *****************************************************
                """);

        int opcaoEscolhida = 0;

        while (opcaoEscolhida != 7) {
            System.out.println("""
                    -----------------------------------------------------
                    Escolha uma opção:
                    1) Dólar =>> Real
                    2) Real =>> Dólar
                    3) Real =>> Euro
                    4) Euro =>> Real
                    5) Euro =>> Dólar
                    6) Dólar =>> Euro
                    7) Sair
                    -----------------------------------------------------
                    """);

            System.out.print("Digite a opção desejada: ");
            opcaoEscolhida = leitura.nextInt();

            if (opcaoEscolhida == 7) {
                System.out.println("Obrigado por utilizar o Conversor de Moeda! :)");
                break;
            }

            String primeiraMoeda = "";
            String segundaMoeda = "";
            String nomePrimeiraMoeda = "";
            String nomeSegundaMoeda = "";

            switch (opcaoEscolhida) {
                case 1 -> {
                    primeiraMoeda = "usd";
                    segundaMoeda = "brl";
                    nomePrimeiraMoeda = "Dólar";
                    nomeSegundaMoeda = "Real";
                }
                case 2 -> {
                    primeiraMoeda = "brl";
                    segundaMoeda = "usd";
                    nomePrimeiraMoeda = "Real";
                    nomeSegundaMoeda = "Dólar";
                }
                case 3 -> {
                    primeiraMoeda = "brl";
                    segundaMoeda = "eur";
                    nomePrimeiraMoeda = "Real";
                    nomeSegundaMoeda = "Euro";
                }
                case 4 -> {
                    primeiraMoeda = "eur";
                    segundaMoeda = "brl";
                    nomePrimeiraMoeda = "Euro";
                    nomeSegundaMoeda = "Real";
                }
                case 5 -> {
                    primeiraMoeda = "eur";
                    segundaMoeda = "usd";
                    nomePrimeiraMoeda = "Euro";
                    nomeSegundaMoeda = "Dólar";
                }
                case 6 -> {
                    primeiraMoeda = "usd";
                    segundaMoeda = "eur";
                    nomePrimeiraMoeda = "Dólar";
                    nomeSegundaMoeda = "Euro";
                }
                default -> {
                    System.out.println("Opção inválida! Tente novamente.\n");
                    continue;
                }
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = leitura.nextDouble();

            BuscaDados buscaDados = new BuscaDados();
            TaxaDeCambio taxa = buscaDados.buscaMoeda(primeiraMoeda, segundaMoeda);

            double resultado = valor * taxa.conversionRate();

            System.out.printf("Valor %.2f %s corresponde a %.2f %s%n%n",
                    valor, nomePrimeiraMoeda, resultado, nomeSegundaMoeda);
        }
    }
}
