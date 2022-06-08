package io.github.moisesccaldas.vendas.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	
@AllArgsConstructor
public class Pedido {
	private Integer id;
	private Cliente cliente;
	private LocalDate dataPedido;
	private BigDecimal total;
}
