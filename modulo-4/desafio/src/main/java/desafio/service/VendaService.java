package desafio.service;

import desafio.entity.Venda;
import desafio.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda findById(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }
}