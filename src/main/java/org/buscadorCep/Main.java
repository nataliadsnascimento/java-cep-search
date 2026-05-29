package org.buscadorCep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite um CEP: ");
        String cep = input.nextLine();
        ConsultaCep consultaCep = new ConsultaCep();

        try {
            Endereco novoEndereco = consultaCep.buscarEndereco(cep);
            System.out.println("\nEndereço encontrado:");
            System.out.println("CEP: " + novoEndereco.cep());
            System.out.println("Rua: " + novoEndereco.logradouro());
            System.out.println("Cidade: " + novoEndereco.localidade());
            System.out.println("UF: " + novoEndereco.uf());
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}