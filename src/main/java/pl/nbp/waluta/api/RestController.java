package pl.nbp.waluta.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nbp.waluta.model.CurrencyResponse;
import pl.nbp.waluta.model.NBPResponse;
import pl.nbp.waluta.service.CurrencyService;

import java.time.LocalDate;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    final private CurrencyService currencyService;

    public RestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{currency}")
    public ResponseEntity<CurrencyResponse> getCurrency(@PathVariable String currency, @RequestParam(value = "last", defaultValue = "1") int last) {
        return ResponseEntity.ok(currencyService.getCurrency(currency, last));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(" elo ");
    }
}
