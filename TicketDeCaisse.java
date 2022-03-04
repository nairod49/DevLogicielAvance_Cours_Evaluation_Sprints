import java.util.ArrayList;
import java.util.List;

/** Classe qui gère l'affichage d'un ticket de caisse / facture */
public class TicketDeCaisse {

    // Attributs
    List<Article> _lstArticle;
    double _montantSansReduc = 0.0;
    double _montantFinal = 0.0;
    double _discount;
    double _tax;
    double _sommeTaxedesArticles = 0.0;
    double _tauxReductionAAppliquer = 0.0;

    // Constructeurs
    public TicketDeCaisse(List<Article> lstArticle) {

        // Récupère la liste des article
        _lstArticle = new ArrayList<Article>();

        for (Article w : lstArticle) {
            _lstArticle.add(w);
        }
        // Mémorisation du montant avant application de la taxe et d'une réduction
        this._montantSansReduc = calculTotalWithoutTaxes();

        // Calcul du montant de la réduction
        DiscountRate dr = new DiscountRate();
        this._discount = dr.get_montantReduc(this._montantSansReduc);

        // Taux de réduction à appliquer
        _tauxReductionAAppliquer = dr.get_tauxAAppliquer() * 100;

        // Calcul du montant de la taxe pour chaque article
        for (Article w : lstArticle) {
            this._sommeTaxedesArticles += w.get_montantTaxeTousLesProduits();
        }

        // Montant avec la taxe et la réduction
        this._montantFinal = this._montantSansReduc - this._discount + this._sommeTaxedesArticles;
    }

    // Gettres & setters
    public List<Article> get_lstArticle() {
        return _lstArticle;
    }

    public void set_lstArticle(List<Article> _lstArticle) {
        this._lstArticle = _lstArticle;
    }

    public double get_montantSansReduc() {
        return _montantSansReduc;
    }

    public void set_montantSansReduc(double _montantSansReduc) {
        this._montantSansReduc = _montantSansReduc;
    }

    public double get_montantFinal() {
        return _montantFinal;
    }

    public void set_montantFinal(double _montantFinal) {
        this._montantFinal = _montantFinal;
    }

    public double get_discount() {
        return _discount;
    }

    public void set_discount(double _discount) {
        this._discount = _discount;
    }

    public double get_tax() {
        return _tax;
    }

    public void set_tax(double _tax) {
        this._tax = _tax;
    }

    public double get_sommeTaxedesArticles() {
        return _sommeTaxedesArticles;
    }

    public void set_sommeTaxedesArticles(double _sommeTaxedesArticles) {
        this._sommeTaxedesArticles = _sommeTaxedesArticles;
    }

    public double get_tauxReductionAAppliquer() {
        return _tauxReductionAAppliquer;
    }

    public void set_tauxReductionAAppliquer(double _tauxReductionAAppliquer) {
        this._tauxReductionAAppliquer = _tauxReductionAAppliquer;
    }

    // Méthodes
    private double calculTotalWithoutTaxes() {
        double montant = 0.0;

        for (Article w : _lstArticle) {
            montant += w._priceHT * w._quantity;
        }

        return montant;
    }

    // Etape 4 Imprimer le ticket de caisse
    public void GenererTicketDeCaisse() {

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\n\n Ticket de caisse : \n");
        System.out.println("---------------------------------------------------------------------------");

        // Affichage des ligens de commandes
        for (Article w : _lstArticle) {
            System.out.println("Label: " + w._label + ", quantite: " + w._quantity + ", prix unitaire: " + w._priceHT
                    + ", prix total: " + w._prixTotalDesProduitsAvecTaxe);
        }

        System.out.println("---------------------------------------------------------------------------");

        System.out.println(
                "Total without taxes                                            " + this._montantSansReduc + " euros");
        System.out
                .println(
                        "Discount " + _tauxReductionAAppliquer + "%                                                    "
                                + this._discount + " euros");
        System.out.println("Tax %Y                                                         "
                + this._sommeTaxedesArticles + " euros");

        System.out.println("---------------------------------------------------------------------------");

        System.out.println(
                "Total price                                                    " + this._montantFinal + " euros\n\n");
    }

}
