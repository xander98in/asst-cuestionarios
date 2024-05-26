package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.CuestionarioFormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso.GestionarCuestionarioCUAdapter;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso.GestionarDocenteCUAdapter;


@Configuration
public class BeanConfigurations {

    @Bean
    GestionarCuestionarioCUAdapter crearGestionarCuestionarioCUInt(
        GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway,
        CuestionarioFormateadorResultadosIntPort objCuestionarioFormateadorResultados
    ) {
        GestionarCuestionarioCUAdapter objGestionarCuestionarioCU = new GestionarCuestionarioCUAdapter(objGestionarCuestionarioGateway, objCuestionarioFormateadorResultados);
        return objGestionarCuestionarioCU;
    }

    @Bean
    GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
        GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
        FormateadorResultadosIntPort objFormateadorResultados
    ) {
        GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objGestionarDocenteGateway, objFormateadorResultados);
        return objGestionarDocenteCU;
    }

}
