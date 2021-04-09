package com.lucasvieira.crud.service;

import com.lucasvieira.crud.data.vo.ProdutoVO;
import com.lucasvieira.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoVO create(ProdutoVO produtoVO) {
        return null;
    }
}
