package com.mvs.aula1.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvs.exception.MathMethodNotSupported;

@RestController
public class OperacaoController {


	@RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {

		if (!isNumero(numeroUm) || !isNumero(numeroDois)) {
			throw new MathMethodNotSupported("Please set numeric value.");
		}
		Double soma = converteDouble(numeroUm) + converteDouble(numeroDois);
		System.out.println(numeroUm +" + "+numeroDois);
		return soma;

	}
	
	@RequestMapping(value = "/subtracao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {

		if (!isNumero(numeroUm) || !isNumero(numeroDois)) {
			throw new MathMethodNotSupported("Please set numeric value.");
		}
		Double subt = converteDouble(numeroUm) - converteDouble(numeroDois);
		System.out.println(numeroUm +" - "+numeroDois);
		return subt;

	}
	
	@RequestMapping(value = "/multiplicacao/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {

		if (!isNumero(numeroUm) || !isNumero(numeroDois)) {
			throw new MathMethodNotSupported("Please set numeric value.");
		}
		Double mult = converteDouble(numeroUm) * converteDouble(numeroDois);
		System.out.println(numeroUm +" x "+numeroDois);
		return mult;

	}

	@RequestMapping(value = "/div/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
	public Double div(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois)
			throws Exception {

		if (!isNumero(numeroUm) || !isNumero(numeroDois)) {
			throw new MathMethodNotSupported("Please set numeric value.");
		}
		Double division = converteDouble(numeroUm) / converteDouble(numeroDois);
		System.out.println(numeroUm +" x "+numeroDois);
		return division;

	}
	
	@RequestMapping(value = "/square/{numeroUm}", method = RequestMethod.GET)
	public Double square(@PathVariable("numeroUm") String numeroUm)
			throws Exception {

		if (!isNumero(numeroUm)) {
			throw new MathMethodNotSupported("Please set numeric value.");
		}
		Double square = Math.sqrt(converteDouble(numeroUm));
		System.out.println(numeroUm );
		return square;

	}
	
	private Double converteDouble(String strNum) {
		// TODO Auto-generated method stub
		if (strNum == null)
			return 0D;
		if (isNumero(strNum))
			return Double.parseDouble(strNum);
		return 0D;
		
	}

	private boolean isNumero(String strNum) {
		if (strNum == null)
			return false;
		String num = strNum.replaceAll(",", ".");
		return num.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}

}
