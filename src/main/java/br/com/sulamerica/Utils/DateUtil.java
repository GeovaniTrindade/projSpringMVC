package br.com.sulamerica.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static Date convertDate(String data) {
		// capturar os valores da data no formato yyyy-MM-dd
//		int ano = Integer.parseInt(date.substring(0, 4)); // ano
//		int mes = Integer.parseInt(date.substring(5, 7)); // mes
//		int dia = Integer.parseInt(date.substring(8, 10)); // dia
//
//		Calendar result = new GregorianCalendar(ano, mes - 1, dia);
//		return result.getTime();

		int dia = Integer.parseInt(data.split("/")[0]);
		int mes = Integer.parseInt(data.split("/")[1]);
		int ano = Integer.parseInt(data.split("/")[2]);

		// return ano + '-' + ("0"+mes).slice(-2) + '-' + ("0"+dia).slice(-2);

		Calendar result = new GregorianCalendar(ano, mes - 1, dia);
		return result.getTime();
	}

}
