package org.example;

import org.example.model.Commande;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        // Liste de commandes
        List<Commande> commandes = Arrays.asList(
                new Commande(1, "Alice", Arrays.asList("Ordinateur", "Souris"), 1200.50, true),
                new Commande(2, "Bob", Arrays.asList("Clavier", "Écran"), 300.75, false),
                new Commande(3, "Charlie", Arrays.asList("Imprimante"), 150.00, true),
                new Commande(4, "Alice", Arrays.asList("USB", "Casque"), 75.50, false),
                new Commande(5, "Bob", Arrays.asList("Tablette"), 200.00, true)
        );

        commandes.stream()
                .forEach(commande -> System.out.println(commande));

        System.out.println("\nTâche 2\n");
        commandes.stream()
                .map(Commande::getClient).forEach(System.out::println);

        System.out.println("\nTâche 3\n");
        double result = commandes.stream()
                .mapToDouble(Commande::getMontantTotal)
                .sum();
        System.out.println(result);

        System.out.println("\n Tâche 4 \n");
        commandes.stream()
                .forEach(fields -> System.out.println("Articles : "+fields.getArticles()+", Montant total : "+fields.getMontantTotal()));

        System.out.println("\n Tâche 5 \n");
        commandes.stream()
                .filter(Commande::isEstLivree)
                .forEach(System.out::println);

        System.out.println("\n Tâche 6 \n");
        Map<String, Double> resultat = commandes.stream()
                .collect(Collectors.groupingBy(Commande::getClient, Collectors.summingDouble(Commande::getMontantTotal)));
        System.out.println(resultat);


        System.out.println("\n Tâche 7 \n");
        commandes.stream()
                .flatMap(e -> e.getArticles().stream())
                .collect(Collectors.toSet())
                .forEach(System.out::println);



    }
}