package com.lucasvieira.pagamento.entity;

import com.lucasvieira.pagamento.data.vo.ProdutoVendaVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name = "produto_venda")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProdutoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_produto", nullable = false, length = 10)
    private Long idProduto;

    @Column(name = "quantidade", nullable = false, length = 10)
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venda")
    private Venda venda;

    public static ProdutoVenda create(ProdutoVendaVO produtoVendaVO) {
        return new ModelMapper().map(produtoVendaVO, ProdutoVenda.class);
    }
}
