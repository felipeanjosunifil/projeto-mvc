package com.github.felipeanjosunifil.projeto_mvc.controller;

import com.github.felipeanjosunifil.projeto_mvc.model.Produto;
import com.github.felipeanjosunifil.projeto_mvc.model.service.ProdutoService;
import com.github.felipeanjosunifil.projeto_mvc.model.service.ProdutoServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService = new ProdutoServiceImp();

    @PostMapping("/novo")
    public ResponseEntity<?> novoProduto(@RequestBody Produto produto) {
        try {
            produtoService.novoProduto(produto);
            return ResponseEntity.status(201).body(true);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = produtoService.getProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoPorId(@PathVariable("id") int id) {
        try {
            Produto produto = produtoService.getProdutoPorId(id);
            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> consultarProdutos(@RequestParam("nome") String nome, @RequestParam(value = "valorMaximo", required = false) double valorMaximo) {
        List<Produto> produtosEncontrados = produtoService.consultarProdutos(nome, valorMaximo);

        return ResponseEntity.ok(produtosEncontrados);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> apagarProduto(@PathVariable("id") int id) {
        try {
            produtoService.apagarProduto(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
