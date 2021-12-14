package mx.com.gm.servicio;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void guardar(Persona persona) {
          personaDao.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
          personaDao.delete(persona);
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
