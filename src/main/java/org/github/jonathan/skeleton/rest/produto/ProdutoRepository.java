package org.github.jonathan.skeleton.rest.produto;

import org.springframework.stereotype.Repository;
import org.github.jonathan.skeleton.generic.RestFullApiGeneric;

@Repository
public interface ProdutoRepository extends RestFullApiGeneric<Produto> { }