import java.util.ArrayList;
import java.util.List;

/** Classe qui gère les réductions */
public class DiscountRate {

    // Attributs
    List<Double> _mapDesTaux;
    double _tauxAAppliquer = 0.0;

    // Constructors
    public DiscountRate() {
        _mapDesTaux = new ArrayList<Double>();

        // Ajouts des taxes
        _mapDesTaux.add(0.03);
        _mapDesTaux.add(0.05);
        _mapDesTaux.add(0.07);
        _mapDesTaux.add(0.10);
        _mapDesTaux.add(0.15);
    }

    // Getters & setters
    public List<Double> get_mapDesTaux() {
        return _mapDesTaux;
    }

    public void set_mapDesTaux(List<Double> _mapDesTaux) {
        this._mapDesTaux = _mapDesTaux;
    }

    public double get_tauxAAppliquer() {
        return _tauxAAppliquer;
    }

    public void set_tauxAAppliquer(double _tauxAAppliquer) {
        this._tauxAAppliquer = _tauxAAppliquer;
    }

    // Méthodes
    public double get_montantReduc(double montant) {

        double montantReduc = 0.0;

        if (montant > 1000 && montant <= 5_000) {
            _tauxAAppliquer = 0.03;
            montantReduc = montant * 0.03;
        } else if (montant > 5_000 && montant <= 7_000) {
            _tauxAAppliquer = 0.05;
            montantReduc = montant * 0.05;
        } else if (montant > 7_000 && montant <= 10_000) {
            _tauxAAppliquer = 0.07;
            montantReduc = montant * 0.07;
        } else if (montant > 10_000 && montant <= 15_000) {
            _tauxAAppliquer = 0.10;
            montantReduc = montant * 0.10;
        } else if (montant > 15_000) {
            _tauxAAppliquer = 0.15;
            montantReduc = montant * 0.15;
        } else {
            _tauxAAppliquer = 0.0;
            montantReduc = 0.0;
        }

        return montantReduc;
    }
}
