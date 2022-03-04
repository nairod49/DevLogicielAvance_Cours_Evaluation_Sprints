import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashRegisterTicket {

    public static void main(String[] args) {

        // Etape 1
        System.out.println(
                "\nHello World !\n\n*****************************************\nCash register tickets :\n*****************************************\n");

        // Etape 11
        System.out.println("Order value Discount rate :");
        DiscountRate dr = new DiscountRate();
        List<Double> lstDr = dr._mapDesTaux;
        for (int i = 0; i < lstDr.size(); i++) {
            System.out.println(
                    "> " + (Math.round(lstDr.get(i) * 100000)) + "                " + (Math.round(lstDr.get(i) * 100))
                            + "%");
        }

        // Etape 6
        System.out.println("\nCodes TVA :");
        TaxRate tr = new TaxRate();
        Map<String, Double> lstTr = tr._mapDesTaux;
        for (Map.Entry mapentry : lstTr.entrySet()) {
            System.out.println(mapentry.getKey()
                    + " | " + mapentry.getValue());
        }

        // Variable du jeu
        String _choix = "";
        int numArticle = 1;

        String _label = "";
        int _quantity = 0;
        double _priceHT = 0.0;
        String _letterStateCode = "";
        double _tauxred=0;
        // Liste des articles à facturer
        List<Article> listeArticles = new ArrayList<Article>();

        // Scanner de lecture du choix utilisateur
        Scanner sc1 = new Scanner(System.in);

        do {
            System.out.println("\n-->> Article " + numArticle + " scanne : ");

            // Demande à renseigner les 4 paramètre de l'article
            System.out.println("\tLabel ? ");
            _label = sc1.nextLine();

            System.out.println("\tQuantite ? ");
            _quantity = Integer.parseInt(sc1.nextLine());

            System.out.println("\tPrix ? ");
            _priceHT = Double.parseDouble(sc1.nextLine());

            System.out.println("\tState code ? ");
            _letterStateCode = sc1.nextLine();

            // Instanciation d'un article
            Article _article = new Article(_label, _quantity, _priceHT, _letterStateCode);

            // Etape 17 demander une désignation ét l'afficher
            System.out.println(_article.toString());

            // Ajout de l'article à la liste des articles à facturer
            listeArticles.add(_article);

            // Affichage de la ligne de commande enregistrée

            // Incrémente le nombre d'article
            numArticle++;

            System.out.println("\nVoulez-vous enregistrer un autre article (oui/non) ? ");
            _choix = sc1.nextLine();

        } while (_choix.equalsIgnoreCase("oui") ? true : false);

        //demande du taux de réduction
        System.out.println("\nQuelle est le taux de réduction ?");
        _tauxred = Double.parseDouble(sc1.nextLine());

        // Affiche la liste des articles que le client souhaite consommer
        TicketDeCaisse ticket = new TicketDeCaisse(listeArticles);
        ticket.GenererTicketDeCaisse();

        // Dispose le scanner
        sc1.close();
    }
}