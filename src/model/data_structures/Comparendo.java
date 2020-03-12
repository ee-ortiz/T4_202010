package model.data_structures;

import java.util.Comparator;
import java.util.Date;

public class Comparendo implements Comparable<Comparendo> {

	public int OBJECTID;
	public Date FECHA_HORA;
	public String DES_INFRAC;
	public String MEDIO_DETE;
	public String CLASE_VEHI;
	public String TIPO_SERVI;
	public String INFRACCION;
	public String LOCALIDAD;
	public String MUNICIPIO;

	public double latitud;
	public double longitud;


	public String retornarDatos(){
		//	Mostrar la información del comparendo (OBJECTID, FECHA_HORA, INFRACCION, CLASE_VEHI, TIPO_SERVI, LOCALIDAD) 

		String rta = "OBJECTID: "+OBJECTID +" FECHA_HORA: " + FECHA_HORA + " INFRACCION: " + INFRACCION + " CLASE_VEHI: "+CLASE_VEHI + " TIPO_SERVI: " +
				TIPO_SERVI + " LOCALIDAD: "+ LOCALIDAD + " MUNICIPIO: " + MUNICIPIO;
		return rta;
	}


	public int compareTo(Comparendo comp) {

		if(FECHA_HORA.compareTo(comp.FECHA_HORA)==0){
			return (OBJECTID - comp.OBJECTID);
		}
		else{
			return FECHA_HORA.compareTo(comp.FECHA_HORA);
		}

	}
	public static class ComparadorXLatitud implements Comparator<Comparendo> {

		public int compare(Comparendo c1, Comparendo c2) {
			return  (int) ((int)c1.latitud-c2.latitud);
		}
	}
}
