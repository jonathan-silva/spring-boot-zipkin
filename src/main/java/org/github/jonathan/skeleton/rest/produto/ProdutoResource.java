package org.github.jonathan.skeleton.rest.produto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/produto")
@Api(value="API REST Produtos")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value="Retorna uma lista de Produtos")
    @GetMapping("")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @ApiOperation(value="Retorna um produto unico")
    @GetMapping("/{id}")
    public Produto listProdutoById(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    @ApiOperation(value="Salva um produto")
    @PostMapping("")
    public Produto saveProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @ApiOperation(value="Atualiza um produto")
    @PutMapping("")
    public Produto updateProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @ApiOperation(value="Deleta um produto")
    @DeleteMapping("")
    public void deleteProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }
}
