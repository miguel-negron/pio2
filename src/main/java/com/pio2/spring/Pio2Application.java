package com.pio2.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pio2.spring.entidades.Alergia;
import com.pio2.spring.entidades.Curso;
import com.pio2.spring.entidades.Monitor;
import com.pio2.spring.entidades.Ninyo;
import com.pio2.spring.enums.EnumAlergias;
import com.pio2.spring.enums.EnumCargos;
import com.pio2.spring.enums.EnumCursos;
import com.pio2.spring.repositorios.AlergiaRepository;
import com.pio2.spring.repositorios.CursoRepository;
import com.pio2.spring.repositorios.MonitorRepository;
import com.pio2.spring.repositorios.NinyoRepository;
import com.pio2.spring.utilidades.InicializadorDatos;

@SpringBootApplication
public class Pio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Pio2Application.class, args);
	}

	@Bean
	CommandLineRunner initDataNinyos(NinyoRepository repositorioNinyos, CursoRepository repositorioCursos,
			MonitorRepository repositorioMonitores, AlergiaRepository repositorioAlergias) {
		return (args) -> {

//			Empleado empleado = new Empleado("Luis Miguel López", "luismi.lopez@openwebinars.net", "954000000");
//			Empleado empleado2 = new Empleado("José García", "jose.garcia@openwebinars.net", "954000000");
//			
//			repositori1o.save(empleado);
//			repositorio.save(empleado2);
//			
//			repositorio.findAll().forEach(System.out::println);

//			repositorioNinyos.saveAll( 
//					Arrays.asList(new Ninyo("1"), new Ninyo("2"), new Ninyo("3"))
//					);

			for (int i = 0; i < 5; i++) {
				Curso c = new Curso(EnumCursos.values()[i].toString());
				repositorioCursos.save(c);

				
				for (int j = 0; j < 5; j++) {
					String nomMon = InicializadorDatos.creaNombre();
					String apeMon = InicializadorDatos.creaApellido();
					
					Ninyo n = new Ninyo(InicializadorDatos.creaDni(), InicializadorDatos.creaNombre(),
							InicializadorDatos.creaApellido(), InicializadorDatos.creaApellido(), "01-01-1631");
					Monitor m = new Monitor(InicializadorDatos.creaDni(), nomMon,
							apeMon, InicializadorDatos.creaApellido(), "01-01-1631",
							 nomMon.toLowerCase() + "." + apeMon.toLowerCase() + "@gmail.com", "900 800 700");
					m.setCargo(EnumCargos.values()[i % EnumCargos.values().length].toString());

					n.setCurso(c);
					m.setCurso(c);

					repositorioNinyos.save(n);
					repositorioMonitores.save(m);
					//TODO arreglame por dios
					c.setJefe(m);
				}

				
				repositorioCursos.save(c);

			}

			for (EnumAlergias alergeno : EnumAlergias.values()) {
				Alergia a = new Alergia(alergeno.toString());

				repositorioAlergias.save(a);
			}

		};
	}

}
