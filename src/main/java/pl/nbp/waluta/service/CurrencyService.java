package pl.nbp.waluta.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.nbp.waluta.model.Currency;
import pl.nbp.waluta.model.CurrencyResponse;
import pl.nbp.waluta.model.NBPResponse;
import pl.nbp.waluta.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

@Service
public class CurrencyService {

    private final RestTemplate client;
    private final CurrencyRepository repo;

    public CurrencyService(RestTemplate restTemplate, CurrencyRepository repo) {
        this.client = restTemplate;
        this.repo = repo;
    }

    private final String url = "https://api.nbp.pl/api/exchangerates/rates/a";

    public CurrencyResponse getCurrency(String code, Integer last) {
        LocalDate from = LocalDate.now().minusDays(last);
        LocalDate to = LocalDate.now();
        NBPResponse res = client.getForObject(url + "/{code}/{from}/{to}?format=json", NBPResponse.class, code, from, to);

        BigDecimal avg = BigDecimal.valueOf(res.getRates().stream().map(Currency::getMid).mapToDouble(s -> s).average().orElseThrow())
                .round(new MathContext(3));

        CurrencyResponse response = new CurrencyResponse(avg, code, from, to);

        repo.save(response);

        return response;
    }

}
