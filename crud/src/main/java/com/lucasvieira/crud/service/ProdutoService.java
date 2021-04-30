package com.lucasvieira.crud.service;

import com.lucasvieira.crud.data.vo.ProdutoVO;
import com.lucasvieira.crud.entity.Produto;
import com.lucasvieira.crud.exceptions.ResourceNotFoundException;
import com.lucasvieira.crud.message.ProdutoSendMessage;
import com.lucasvieira.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoSendMessage produtoSendMessage;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, ProdutoSendMessage produtoSendMessage) {
        this.produtoRepository = produtoRepository;
        this.produtoSendMessage = produtoSendMessage;
    }

    public ProdutoVO create(ProdutoVO produtoVO) {
        ProdutoVO proVoRetorno = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
        produtoSendMessage.sendMessage(proVoRetorno);
        return proVoRetorno;
    }

    public Page<ProdutoVO> findAll(Pageable pageable) {
        var page = produtoRepository.findAll(pageable);
        return page.map(this::convertToProdutoVO);
    }

    private ProdutoVO convertToProdutoVO(Produto produto) {
        return ProdutoVO.create(produto);
    }

    public ProdutoVO findById(Long id) {
        var entity = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
        return ProdutoVO.create(entity);
    }

    public ProdutoVO update(ProdutoVO produtoVO) {
        final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());

        if(!optionalProduto.isPresent()) {
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }

        return ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
    }

    public void delete(Long id) {
        var entity = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
        produtoRepository.delete(entity);
    }
}
