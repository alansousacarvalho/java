package model.services;

public interface OnlinePaymentService {
	double taxaDePagamento(Double amount);
	double jurosNoMes(Double amount, Integer months);
}
