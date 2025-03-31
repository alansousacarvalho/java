package model.services;

public class PaypalService implements OnlinePaymentService {

	private static final double JURO_MENSAL = 0.01;
	private static final double TAXA_PAGAMENTO = 0.02;
	
	public double taxaDePagamento(Double amount) {
		return amount * TAXA_PAGAMENTO;
	}
	
	public double jurosNoMes(Double amount, Integer months) {
		return amount * JURO_MENSAL * months;
	}
}
