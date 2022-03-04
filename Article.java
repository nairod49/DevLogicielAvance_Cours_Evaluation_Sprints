/** Cette classe contient un article */
public class Article {

    // Attributs
    String _label = "";
    int _quantity = 0;
    double _priceHT = 0.0;
    String _letterStateCode = "";
    double _tauxSurProduit = 0.0;
    double _montantTaxeUnProduit = 0.0;
    double _montantTaxeTousLesProduits = 0.0;
    double _prixTotalDesProduitsAvecTaxe = 0.0;

    // Constructeurs
    public Article() {

    }

    public Article(String label, int quantity, double priceHT, String letterStateCode) {
        _label = label;
        _quantity = quantity;
        _priceHT = priceHT;
        _letterStateCode = letterStateCode;

        // Calcul du prix du produit avec la taxe suivant le "state code"
        TaxRate tr = new TaxRate();
        _tauxSurProduit = tr.get_montantTaux(letterStateCode, _priceHT);

        // Calcul du montant de la taxe pour un produit
        _montantTaxeUnProduit = _tauxSurProduit * _priceHT;

        // Calcul du montant de la taxe pour tous les produits identiques
        _montantTaxeTousLesProduits = _montantTaxeUnProduit * _quantity;

        _prixTotalDesProduitsAvecTaxe = (_priceHT * _tauxSurProduit) * _quantity;
    }

    // Getters & setters
    public String get_label() {
        return _label;
    }

    public void set_label(String _label) {
        this._label = _label;
    }

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }

    public double get_priceHT() {
        return _priceHT;
    }

    public void set_priceHT(double _priceHT) {
        this._priceHT = _priceHT;
    }

    public String get_letterStateCode() {
        return _letterStateCode;
    }

    public void set_letterStateCode(String _letterStateCode) {
        this._letterStateCode = _letterStateCode;
    }

    public double get_prixTotalProduit() {
        return _prixTotalDesProduitsAvecTaxe;
    }

    public void set_prixTotalProduit(double prixTotalDesProduitsAvecTaxe) {
        this._prixTotalDesProduitsAvecTaxe = prixTotalDesProduitsAvecTaxe;
    }

    public double get_tauxSurProduit() {
        return _tauxSurProduit;
    }

    public void set_tauxSurProduit(double _tauxSurProduit) {
        this._tauxSurProduit = _tauxSurProduit;
    }

    public double get_montantTaxeUnProduit() {
        return _montantTaxeUnProduit;
    }

    public void set_montantTaxeUnProduit(double _montantTaxeUnProduit) {
        this._montantTaxeUnProduit = _montantTaxeUnProduit;
    }

    public double get_montantTaxeTousLesProduits() {
        return _montantTaxeTousLesProduits;
    }

    public void set_montantTaxeTousLesProduits(double _montantTaxeTousLesProduits) {
        this._montantTaxeTousLesProduits = _montantTaxeTousLesProduits;
    }

    public double get_prixTotalDesProduitsAvecTaxe() {
        return _prixTotalDesProduitsAvecTaxe;
    }

    public void set_prixTotalDesProduitsAvecTaxe(double _prixTotalDesProduitsAvecTaxe) {
        this._prixTotalDesProduitsAvecTaxe = _prixTotalDesProduitsAvecTaxe;
    }

    // Méthodes
    @Override
    public String toString() {
        return "Article: label = " + _label + ", State Code = " + _letterStateCode + ", prix = " + _priceHT
                + " euros, quantite = " + _quantity + "\n";
    }
}
