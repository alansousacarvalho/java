package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	public OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		double totalParcelado = contract.getTotalValue() / months;
	
		for(int i = 1; i <= months; i++) {
			LocalDate dataParcela = contract.getDate().plusMonths(i);
			Double valorTaxaMensal = onlinePaymentService.jurosNoMes(totalParcelado, i);
			Double valorTaxaPagamento = onlinePaymentService.taxaDePagamento(totalParcelado);
			Double valorFinalParcela = totalParcelado + valorTaxaMensal + valorTaxaPagamento;
			
			contract.getInstallment().add(new Installment(dataParcela, valorFinalParcela));
		}
	}	
}