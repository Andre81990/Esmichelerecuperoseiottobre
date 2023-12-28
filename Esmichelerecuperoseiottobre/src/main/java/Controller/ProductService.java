package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {



    @Autowired
    private ProductRepository productRepository;

    //lista appoggio
    private List<Product> prodotti=new ArrayList<>();

   // private Long nextId=1L;


    //    @GetMapping("/getprod/{id}")
    public Optional<Product> findForId(long id) {
        //questo pezzo di codice
        // sara sostituito con la chiamata al db
        Optional<Product> optional=Optional.empty();
        for (Product prod:prodotti )
        {
            if (prod.getId().equals(id))
            {
                //return opt solo se i due id sono =
                optional=Optional.of(prod);
                return optional;
            }
        }
        return optional;

    }


    //usare optional:sono campi che fanno passare entity che sono null
    //qui dobbiamo fare la chiamata al db
    public  boolean addProd(Product product)
    {
        return prodotti.add(product);
    }
    public List<Product>selectProdotti() {
        return prodotti;
    }


    //passare nome e prezzo
    public boolean updateProdotto(Product newproduct,long id)
    {

        //find per creare l opgetto
        Optional<Product> product=  findForId(id);
        if (product.isPresent()) {
            //prendere product
            product.get().setNome(newproduct.getNome());
            product.get().setPrezzo(newproduct.getPrezzo());

            return true ;

        }
        return  false;
    }
    public boolean deleteProdotto(Long id)
    {
        for (Product p:prodotti)
        {
        if (p.getId().equals(id))
        {
            //eliminare il prodotto
            return prodotti.remove(p);
        }
        }
        return false;
    }
}

// Implementa metodi per elencare, trovare per ID, creare, aggiornare ed eliminare prodotti