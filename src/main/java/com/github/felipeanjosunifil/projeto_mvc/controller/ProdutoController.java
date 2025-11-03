package com.github.felipeanjosunifil.projeto_mvc.controller;

import com.github.felipeanjosunifil.projeto_mvc.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private int id = 0;
    private List<Produto> produtos = new ArrayList<>();

    @PostMapping("/novo")
    public ResponseEntity<Boolean> novoProduto(@RequestBody Produto produto) {
        produto.setId(++id);
        produtos.add(produto);
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoPorId(@PathVariable("id") int id) {
        Produto produto = null;

        for (Produto p : produtos) {
            if (p.getId() == id) {
                produto = p;
            }
        }

        return ResponseEntity.ok(produto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> consultarProdutos(@RequestParam("nome") String nome, @RequestParam(value = "valorMaximo", required = false) double valorMaximo) {
        List<Produto> produtosEncontrados = new ArrayList<>();
        double valorBuscar = 1000000.0;

        if (valorMaximo > 1) {
            valorBuscar = valorMaximo;
        }

        for (Produto p: produtos) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase()) && p.getPreco() <= valorBuscar) {
                produtosEncontrados.add(p);
            }
        }

        return ResponseEntity.ok(produtosEncontrados);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Boolean> apagarProduto(@PathVariable("id") int id) {
        int deletar = 0;
        int index = -1;

        for (Produto p : produtos) {
            index++;
            if (p.getId() == id) {
                deletar = index;
            }
        }

        produtos.remove(deletar);

//        produtos.removeIf(p -> p.getId() == id);//forma reduzida para remover item

        return ResponseEntity.ok(true);
    }
}
