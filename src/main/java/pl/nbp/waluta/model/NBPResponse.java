package pl.nbp.waluta.model;

import java.util.List;

public class NBPResponse {
    private List<Currency> rates;

    public NBPResponse() {}

    public NBPResponse(List<Currency> rates) {
        this.rates = rates;
    }

    public List<Currency> getRates() {
        return rates;
    }

    public void setRates(List<Currency> rates) {
        this.rates = rates;
    }
}
