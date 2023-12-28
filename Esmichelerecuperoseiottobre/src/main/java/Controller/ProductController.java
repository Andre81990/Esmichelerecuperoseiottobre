package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/figo")
public class ProductController {
    @Autowired
    private ProductService productService;


    //get
    @GetMapping("/allprodotti")
    public ResponseEntity<List<Product>> getAllProd() {
        /*
if (productService.selectProdotti().isEmpty()) {
    return ResponseEntity.ok("la lista è vuota");
}

        return ResponseEntity.ok(productService.selectProdotti().toString());
    */
        return ResponseEntity.ok(productService.selectProdotti());
    }




    //get

    @GetMapping("/getprod/{id}")
    public ResponseEntity<String> getProductById(@PathVariable long id) {
//dobbiamo chiamare il metodo del service dall oggetto
        //metodo che return oggetto se esiste nel db
        Optional<Product> optional = productService.findForId(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get().getNome() + "-" + optional.get().getPrezzo());
        }
        return ResponseEntity.notFound().build();
    }






    @PostMapping(value = "/addprod")
    public ResponseEntity<String> postProduct(@RequestBody Product product) {
        //serve sempre una var d appoggio che chiama il metodo
        //il controller gestisce il response entity
        boolean addProdTrue = productService.addProd(product);
        if (addProdTrue) {
            return ResponseEntity.ok("Prodotto aggiunto");
        }
        return ResponseEntity.badRequest().body("prodotto non aggiunto");
    }


// Implementa metodi per gestire richieste HTTP per elencare, trovare per ID, creare, aggiornare ed eliminare prodotti

    @PutMapping("/updateprod/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody Product prodotto) {

        //id per andare a trovare l oggetto
        //verificare che esiste


        boolean upProdTrue = productService.updateProdotto(prodotto, id);
        if (upProdTrue) {
            return ResponseEntity.ok("prod aggiornato");
        }
        return ResponseEntity.badRequest().body("prodotto non aggiornato");
    }


    @DeleteMapping("/deleteprod/{id}")

    public ResponseEntity<String> eliminaProdotto(@PathVariable long id) {

        boolean deleteProd= productService.deleteProdotto(id);

            if (deleteProd) {
                return ResponseEntity.ok("prodotto eliminato");
            }
return ResponseEntity.badRequest().body("prodotto non eliminato");
        }

    }


