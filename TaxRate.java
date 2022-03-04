import java.util.HashMap;
import java.util.Map;

/** Cette classe contient les taux de TVA pour 1 article */
class TaxRate {

    // Attributs
    Map<String, Double> _mapDesTaux;

    // Constructors
    public TaxRate() {
        _mapDesTaux = new HashMap<String, Double>();

        // Ajouts des taxes
        _mapDesTaux.put("fr", 0.196);
        _mapDesTaux.put("gb", 0.205);
        _mapDesTaux.put("pt", 0.105);
        _mapDesTaux.put("sp", 0.276);
        _mapDesTaux.put("ru", 0.23);
        _mapDesTaux.put("ch", 0.1465);
    }

    // Getters & setters
    public Map<String, Double> get_mapDesTaux() {
        return _mapDesTaux;
    }

    public void set_mapDesTaux(Map<String, Double> _mapDesTaux) {
        this._mapDesTaux = _mapDesTaux;
    }

    // Méthodes
    public double get_montantTaux(String state_code, double prixUnArticle) {

        // Retourne le taux de la taxe à appliquer à un article
        // suivant sa provenance

        double taux = 1.0;

        switch (state_code) {
            case "fr":
                taux = _mapDesTaux.get("fr");
                break;
            case "gb":
                taux = _mapDesTaux.get("gb");
                break;
            case "pt":
                taux = _mapDesTaux.get("pt");
                break;
            case "sp":
                taux = _mapDesTaux.get("sp");
                break;
            case "ru":
                taux = _mapDesTaux.get("ru");
                break;
            case "ch":
                taux = _mapDesTaux.get("ch");
                break;
            default:
                taux = 1.0;
        }

        return taux;
    }

    @Override
    public String toString() {
        return "TaxRate [_mapDesTaux=" + _mapDesTaux + "]";
    }
}