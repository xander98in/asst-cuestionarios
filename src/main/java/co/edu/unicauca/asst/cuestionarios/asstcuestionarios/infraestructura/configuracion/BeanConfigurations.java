package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarRespuestasGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso.GestionarCuestionarioCUAdapter;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso.GestionarDocenteCUAdapter;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso.GestionarRespuestasCUAdapter;


@Configuration
public class BeanConfigurations {

    @Bean
    GestionarCuestionarioCUAdapter crearGestionarCuestionarioCUInt(
        GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway,
        FormateadorResultadosIntPort objFormateadorResultados
    ) {
        GestionarCuestionarioCUAdapter objGestionarCuestionarioCU = new GestionarCuestionarioCUAdapter(objGestionarCuestionarioGateway, objFormateadorResultados);
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

    @Bean
    GestionarRespuestasCUAdapter crearGestionarRespuestasCUInt(
        GestionarRespuestasGatewayIntPort objGestionarRespuestasGateway,
        FormateadorResultadosIntPort objFormateadorResultados
    ) {
        GestionarRespuestasCUAdapter objGestionarRespuestasCU = new GestionarRespuestasCUAdapter(objGestionarRespuestasGateway, objFormateadorResultados);
        return objGestionarRespuestasCU;
    }

}
