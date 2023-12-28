package com.example.Esmichelerecuperoseiottobre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordine")
public class OrdineController
{



    @Autowired
    private OrdineService ordineService;




    @GetMapping("/findall")
    public ResponseEntity<List<Ordine>> getAllOrdini()
    {

        if (!ordineService.getAllOrdini().isEmpty())
        {
            return ResponseEntity.ok(ordineService.getAllOrdini());
        }
        return ResponseEntity.notFound().build();
        //return ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
    //indirizzo di casa

@PostMapping("/aggordine")
public ResponseEntity<String> addOrdine(@RequestBody Ordine ordine)
{
    //ordineService.
    ordineService.aggOrdine(ordine);
       return ResponseEntity.ok("ordine aggiunto_<z");
}




    //metodo che ritorno l oggetto solo se esiste nel db
    @GetMapping("/getorder/{id}")
    public ResponseEntity<String> getOrdierById(@PathVariable Long id)
    {


        Optional<Ordine> optional = ordineService.findForId(id);

        if (optional.isPresent())
        {
            //ritornare l oggetto/stringa
            return ResponseEntity.ok(optional.get().getNome() +"-"+optional.get().getPrezzo());
            //stampa tutto
            //return ResponseEntity.ok(optional.get());
        }

        //senno non si è trovato nulla il prodotto non esiste
        return ResponseEntity.notFound().build();
    }




    @PostMapping(value = "/addordine")
    public ResponseEntity<String> postProduct(@RequestBody Ordine ordine) {
        //serve sempre una var d appoggio che chiama il metodo
        //il controller gestisce il response entity
        boolean addOrdTrue = ordineService.addOrdine(ordine);
        if (addOrdTrue) {
            return ResponseEntity.ok("Ordine aggiunto");
        }

        //codice http
        //https://it.wikipedia.org/wiki/Codici_di_stato_HTTP
        return ResponseEntity.badRequest().body("prodotto non aggiunto");
    }

//non serve mettere l id nel json in postman
    @PutMapping("/updateordine/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Ordine newordine)
    {
        //id per andare a trovare l oggetto
        //verificare che esiste

        Optional<Ordine> optionalOrdine = ordineService.updateOrdine(id,newordine);
        if (optionalOrdine.isPresent())
        {
            return ResponseEntity.ok("ordine aggiornato");
        }
        else
        {
        return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deleteordine/{id}")

    public ResponseEntity<String> eliminaOrdine(@PathVariable long id) {

        boolean deleteOrd= ordineService.deleteOrdine(id);
        if (deleteOrd)
        {
            return ResponseEntity.ok("ordine eliminato");
        }
        return ResponseEntity.badRequest().body("ordine non eliminato");
    }


}
