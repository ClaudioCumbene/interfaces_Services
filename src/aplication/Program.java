package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Data dd/MM/yyyy):");
		LocalDate date = LocalDate.parse(sc.next(),fmt); 
		System.out.print("Valor do contrato: ");
		double totalValue= sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, n);
		
		System.out.println("Parcelas: ");
		
		for(Installment installment: contract.getInstallments()) {
			System.out.println(installment);
		}
		
		
	
		
		sc.close();
		

	}

}
