/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.agentes.CursosDao;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.agentes.entidades.Agente;
import ec.gob.uideh.agentes.entidades.Cursos;
import ec.gob.uideh.agentes.entidades.Parametros;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Pablo
 */

@ManagedBean
@SessionScoped

public class CursosControl extends Comun implements Serializable{
    @EJB
    private CursosDao cursosDao;
    
    @EJB
    private ParametroDao parametroDao;
    
    private Cursos cursos;//objeto tipo Cursos

    
    private Long id_lugar_curso;//variables del combo
    private Long id_tipo_curso;//variables del combo
 
    public CursosControl(){
        
    }
    
    @PostConstruct
    private void inicio(){;
        //this.cursos = new Cursos();
    }
    
    public List<Cursos> getListCursos()
    {
        try{
            return cursosDao.listaCursos();
        }catch(Exception e){
            Logger.getLogger(CursosControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public List<SelectItem> getListParametros(Long tipoParam){
        List<SelectItem> lista= new ArrayList<SelectItem>();
        
        try{
            for(Parametros par: this.parametroDao.listarParametros(tipoParam)){
                 lista.add(new SelectItem(par.getId(), par.getParametro()));
             }
        }catch(Exception e){
             e.printStackTrace();
         }       
         return lista; 
    }
    
    public void nuevo(){
        this.setCursos(new Cursos());
    }

    public void grabar(Long agente){
        
        this.getCursos().setIdAgente(new Agente(agente));
        
        Parametros tipocurso = new Parametros(this.id_tipo_curso);
        this.getCursos().setIdTipoCurso(tipocurso);
        
        Parametros lugarcurso = new Parametros(this.id_lugar_curso);
        this.getCursos().setIdLugarCurso(lugarcurso);
        
        this.cursosDao.ingresar(this.getCursos());
        
        ponerMensajeInfo("SE GRABO");
    
    }
    
      public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }
    
     public Long getId_lugar_curso() {
        return id_lugar_curso;
    }

    public void setId_lugar_curso(Long id_lugar_curso) {
        this.id_lugar_curso = id_lugar_curso;
    }

    public Long getId_tipo_curso() {
        return id_tipo_curso;
    }

    public void setId_tipo_curso(Long id_tipo_curso) {
        this.id_tipo_curso = id_tipo_curso;
    }
        
    public Long getTipocurso(){
        return TIPOCURSO;
    }
    
    public Long getCiudadPais(){
        return CIUDADPAIS;
    }
}
