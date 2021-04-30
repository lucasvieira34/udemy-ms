package com.lucasvieira.pagamento.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lucasvieira.pagamento.entity.ProdutoVenda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id","idProduto","quantidade"})
public class ProdutoVendaVO extends RepresentationModel<ProdutoVendaVO> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("idProduto")
    private Long idProduto;

    @JsonProperty("quantidade")
    private Integer quantidade;

    public static ProdutoVendaVO create(ProdutoVenda produtoVenda){
        return new ModelMapper().map(produtoVenda, ProdutoVendaVO.class);
    }

}
