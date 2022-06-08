package io.github.moisesccaldas.vendas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
	private Integer id;
	private Pedido pedido;
	private Produto produto;
	private Integer quantidade;
}
