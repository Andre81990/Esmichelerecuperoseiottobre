package com.example.Esmichelerecuperoseiottobre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {
@Autowired
    private OrdineRepository ordineRepository;
    private List <Ordine> ordineList=new ArrayList<>();
    //tutti
    //findall
    public List<Ordine> getAllOrdini()
    {
        return ordineRepository.findAll();
    }

    public List<Ordine> aggOrdine(Ordine ordine)
    {return ordineRepository.save();}

    //opt
    public Optional<Ordine>findForId(long id)
    {
        Optional<Ordine> optional=Optional.empty();

        for (Ordine ordine:ordineList)
        {
         if (ordine.getId().equals(id))
         {
             optional=Optional.of(ordine);
         }
        }
        return optional;
    }


    //quando ci sara il db non sara' piu boolean
    public boolean addOrdine(Ordine ordine) {
        return ordineList.add(ordine);
    }


//opt
    public List<Ordine>selectOrdini() {
        return ordineList;
    }





//serve id e i dati dell oggetto da modificare



    public Optional<Ordine> updateOrdine( Long id,Ordine ordineupdate) {

        Optional<Ordine> opt=findForId(id);
        boolean optPresent = opt.isPresent();
        if (optPresent)
        {

            //get e per prendere l ogg, si controlla con is present
          opt.get().setNome(ordineupdate.getNome());
          opt.get().setPrezzo(ordineupdate.getPrezzo());

          //se si forma l eccez allora si gestisce nel ctrl
            //si puo avere anche la response
          return opt;
        }

        else


            return Optional.empty();
    }

//mettere long perche'
    public boolean deleteOrdine(Long id)
    {

        //ciclare la lista ordini
        for (Ordine o:ordineList)
        {
            //equals tra gli id
            //con gli oggetti c e equals
            if (o.getId().equals(id))
            {
                //eliminare il prodotto tramite metodo di list
                return ordineList.remove(o);
            }
        }
        return false;
    }
}
