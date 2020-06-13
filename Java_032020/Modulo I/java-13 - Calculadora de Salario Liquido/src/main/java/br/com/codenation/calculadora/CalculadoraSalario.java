package br.com.codenation.calculadora;


public class CalculadoraSalario {

	private static final double SALARIO_MINIMO    = 1039.00;
	private static final int    FATOR_PERCENT     = 100;

	private static final String INSS = "INSS";
	private static final double INSS_SAL_REF_01 = 1500.00;
	private static final double INSS_SAL_REF_02 = 4000.00;
	private static final double INSS_PERC_01 = 8.00;
	private static final double INSS_PERC_02 = 9.00;
	private static final double INSS_PERC_03 = 11.00;

	private static final String IRRF = "IRRF";
	private static final double IRRF_SAL_REF_01 = 3000.00;
	private static final double IRRF_SAL_REF_02 = 6000.00;
	private static final double IRRF_PERC_01 = 0.00;
	private static final double IRRF_PERC_02 = 7.50;
	private static final double IRRF_PERC_03 = 15.00;

	public long calcularSalarioLiquido(double salarioBase) {

		return Math.round(validarSalario(salarioBase));

	}

	private double validarSalario(double salarioBase){

		return (salarioBase > SALARIO_MINIMO) ? calcularIrrf(calcularInss(salarioBase)) : 0.0;

	}

	private double calcularInss(double salarioBase) {

		return  (salarioBase - ( salarioBase * ( getPercentualImposto(salarioBase,INSS) / FATOR_PERCENT)));

	}

	private double calcularIrrf(double salarioLiquido) {

		return  (salarioLiquido - (salarioLiquido * ( getPercentualImposto(salarioLiquido,IRRF) / FATOR_PERCENT )));

	}

	private double getPercentualImposto(double valorBase, String tipoImposto){

        double taxPercent = 0.0;

		switch (tipoImposto.trim().toUpperCase()) {
			case INSS :
				//A linha abaixo demonstra uma forma de realizar os 3 if em uma unica linha;
				//taxPercent = (valorBase <= INSS_SAL_REF_01) ? INSS_PERC_01 : (valorBase  > INSS_SAL_REF_01) ? INSS_PERC_02 : (valorBase  > INSS_SAL_REF_02) ? INSS_PERC_03 : 0.00;
			    if (valorBase <= INSS_SAL_REF_01) {taxPercent = INSS_PERC_01;};
				if ((valorBase > INSS_SAL_REF_01)&&(valorBase <= INSS_SAL_REF_02)) {taxPercent = INSS_PERC_02;};
				if (valorBase > INSS_SAL_REF_02) {taxPercent = INSS_PERC_03;};
				break;
			case IRRF :
				if (valorBase <= IRRF_SAL_REF_01) {taxPercent = IRRF_PERC_01;};
				if ((valorBase > IRRF_SAL_REF_01)&&(valorBase <= IRRF_SAL_REF_02)) {taxPercent = IRRF_PERC_02;};
				if (valorBase > IRRF_SAL_REF_02) {taxPercent = IRRF_PERC_03;};
				break;
			default:
				taxPercent = 0.0;
				break;
		}

		return taxPercent;
	}
}