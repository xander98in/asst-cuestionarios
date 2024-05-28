package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Docente;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.DepartamentoEntity;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.DepartamentoRepositoryInt;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;

@Service
@Transactional
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocenteRepositoryInt docenteRepositoryInt;
    private final DepartamentoRepositoryInt departamentoRepositoryInt;
    private final ModelMapper docenteModelMapper;
    
    public GestionarDocenteGatewayImplAdapter(
        DocenteRepositoryInt docenteRepositoryInt,
        DepartamentoRepositoryInt departamentoRepositoryInt,
        @Qualifier("modelMapperDocente") ModelMapper docenteModelMapper
    ) {
        this.docenteRepositoryInt = docenteRepositoryInt;
        this.departamentoRepositoryInt = departamentoRepositoryInt;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    public Boolean existeDocentePorIdentificacion(String numeroIdentificacion) {
        return this.docenteRepositoryInt.existsByNumeroIdentificacion(numeroIdentificacion);
    }

    @Override
    public Boolean existeDocentePorCorreo(String correo) {
        return this.docenteRepositoryInt.existePorCorreo(correo);
    }

    @Override
    public Docente guardarDocente(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        List<DepartamentoEntity> departamentosEntityDocente = new ArrayList<>();
        objDocenteEntity.getDepartamentos().forEach(d -> {
            departamentosEntityDocente.add(this.departamentoRepositoryInt.findById(d.getIdDepartamento()).get());
        });
        objDocenteEntity.setDepartamentos(departamentosEntityDocente);
        DocenteEntity objDocenteEntityRegistrado = this.docenteRepositoryInt.save(objDocenteEntity);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> listarDocentes() {
        Iterable<DocenteEntity> lista = this.docenteRepositoryInt.findAll();
        List<Docente> listaObtenida = this.docenteModelMapper.map(lista, new TypeToken<List<Docente>>() {
        }.getType());
        return listaObtenida;
    }

}
