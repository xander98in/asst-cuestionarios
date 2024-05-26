package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperBean {

    @Bean(name = "modelMapperCuestionario")
    ModelMapper modelMapperCuestionario() {
        ModelMapper objMapper = new ModelMapper();
        objMapper.getConfiguration().setAmbiguityIgnored(true);
        return objMapper;
    }

    @Bean(name = "modelMapperDocente")
    ModelMapper modelMapperDocente() {
        ModelMapper objMapper = new ModelMapper();
        objMapper.getConfiguration().setAmbiguityIgnored(true);
        return objMapper;
    }
    
    @Bean(name = "modelMapperRespuestas")
    ModelMapper modelMapperRespuesta() {
        ModelMapper objMapper = new ModelMapper();
        objMapper.getConfiguration().setAmbiguityIgnored(true);
        return objMapper;
    }
}
