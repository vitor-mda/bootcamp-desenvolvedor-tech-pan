package desafio.service;

import desafio.entity.Venda;
import desafio.entity.Vendedor;
import desafio.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {
    @Autowired
    VendedorRepository vendedorRepository;

    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    public List<Vendedor> findAllOrderByTotalDeVendas() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        vendedores.sort((v1, v2) -> {
            Double vendas1 = v1.getVendas()
                    .stream()
                    .map(Venda::getValor)
                    .reduce(0.0, Double::sum),

                    vendas2 = v2.getVendas()
                    .stream()
                    .map(Venda::getValor)
                    .reduce(0.0, Double::sum);
            if(vendas1 > vendas2) {
                return -1;
            } else if(vendas1.equals(vendas2)) {
                return 0;
            } else {
                return 1;
            }
        });

        return vendedores;
    }

    public Vendedor findById(Long id) {
        return vendedorRepository.findById(id).orElse(null);
    }

    public Vendedor save(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
}