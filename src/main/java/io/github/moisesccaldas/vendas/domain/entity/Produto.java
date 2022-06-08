package io.github.moisesccaldas.vendas.domain.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	private Integer id;
	private String descricao;
	private BigDecimal preco;
}
