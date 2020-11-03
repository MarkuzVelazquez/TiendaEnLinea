/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.clienteDao;
import dao.clienteDaoImplement;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Digits;
import model.Cliente;
import org.primefaces.event.FlowEvent;

@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public class clienteBean implements Serializable {
    private Cliente cliente;
    private List<Cliente> lista;
    private String calle;
    private String numExt;
    private String numInt;
    private String entreCalles;
    private String referencias;
    @Digits(integer=5,fraction=0)
    private String cp;
    private String asentamiento;
    private String municipio;
    private String estado;
    private String direccion;
    private String usuario;
    private String pass;
    private String userAdmin;
    private String passAdmin;
    private boolean online = false;
    private boolean onlineAdmin = false;
    private Cliente cliente1;
     @Digits(integer = 10, fraction = 0)
    private String telefono;
    private String fechaNacimiento = "2000-01-01";
    
    private boolean skip;
    
    public void login() {
       clienteDao dao = new clienteDaoImplement();
        
        List<Cliente> list = dao.mostrar();
        
        // check if username exists here
         boolean existe = false;
         for(Cliente cl : list) {
            if (cl.getUsuario() == null ? usuario == null : cl.getUsuario().equals(usuario)) {
                existe = true;
                if (cl.getPass().equals(pass)) {
                    cliente1 = cl;
                    online = true;
                    addMessage("Bienvenido :" + cl.getUsuario());
                }
                else {
                    
                    addMessage("Contraseña incorrecta");
                
                }
            }
            if (!existe) {
                
                    addMessage("Usuario o Contraseña incorrecto");
            }
         }
    }
    
    
    public void loginAdmin() {
        boolean existe = false;
       if ("Admin".equals(userAdmin)) {
            existe = true;
            if ("password".equals(passAdmin)) {
                setOnlineAdmin(true);
                addMessage("Bienvenido :" + cliente.getUsuario());
            }
            else {
                addMessage("Contraseña incorrecta");

            }
        }
        if (!existe) {

                addMessage("Usuario o Contraseña incorrecto");
        }
    }
     
    public clienteBean() {
        cliente = new Cliente();
    }
    public Cliente getCliente() {
        return cliente;
    }
 
    public String getApellidos() {
        return cliente.getApaterno() + " " + cliente.getAmaterno();
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
    public void insertar() {
        clienteDao dao = new clienteDaoImplement();
        setDireccion(getCalle() + " " + getNumExt() + " " + getNumInt() + " " + getEntreCalles() + " " + getReferencias() + " " + getCp() + " " + getAsentamiento() + " " + getMunicipio() + " " + getEstado());
        cliente.setDireccion(getDireccion());
        cliente.setTelefono(Long.valueOf(telefono));
        dao.insertar(cliente);
        cliente = new Cliente();
        setCalle("");
        setNumExt("");
        setNumInt("");
        setEntreCalles("");
        setReferencias("");
        setCp("");
        setAsentamiento("");
        setMunicipio("");
        setEstado("");
        setDireccion("");
        addMessage("Cliente registrado!");
    }
    public void save() {
        insertar();
        online = true;
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            
            skip = false;   //reset in case user goes back
            return "contact";
        }
        else {
            return event.getNewStep();
        }
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numExt
     */
    public String getNumExt() {
        return numExt;
    }

    /**
     * @param numExt the numExt to set
     */
    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    /**
     * @return the numInt
     */
    public String getNumInt() {
        return numInt;
    }

    /**
     * @param numInt the numInt to set
     */
    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    /**
     * @return the entreCalles
     */
    public String getEntreCalles() {
        return entreCalles;
    }

    /**
     * @param entreCalles the entreCalles to set
     */
    public void setEntreCalles(String entreCalles) {
        this.entreCalles = entreCalles;
    }

    /**
     * @return the referencias
     */
    public String getReferencias() {
        return referencias;
    }

    /**
     * @param referencias the referencias to set
     */
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * @return the asentamiento
     */
    public String getAsentamiento() {
        return asentamiento;
    }

    /**
     * @param asentamiento the asentamiento to set
     */
    public void setAsentamiento(String asentamiento) {
        this.asentamiento = asentamiento;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }
    
    public void eliminar(){
        clienteDao dao = new  clienteDaoImplement();
        dao.eliminar(cliente);
        cliente = new Cliente();
        addMessage("Cliente Eliminado!!");
    }
     
     public void actualizar(){
        clienteDao dao = new  clienteDaoImplement();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(clienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente.setFechaNacimiento(date);
        dao.actualizar(cliente);
        cliente = new Cliente();
        addMessage("Cliente Actualizado!!");
     }
     
     public List<Cliente> getLista() {
        clienteDao dao = new  clienteDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    /**
     * @return the userAdmin
     */
    public String getUserAdmin() {
        return userAdmin;
    }

    /**
     * @param userAdmin the userAdmin to set
     */
    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    /**
     * @return the passAdmin
     */
    public String getPassAdmin() {
        return passAdmin;
    }

    /**
     * @param passAdmin the passAdmin to set
     */
    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
    }
    
    
    /**
     * @return the onlineAdmin
     */
    public boolean isOnlineAdmin() {
        return onlineAdmin;
    }

    /**
     * @param onlineAdmin the onlineAdmin to set
     */
    public void setOnlineAdmin(boolean onlineAdmin) {
        this.onlineAdmin = onlineAdmin;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaNacimiento = formatter.format(cliente.getFechaNacimiento());
        }
        catch(NullPointerException npe) {
            npe.printStackTrace();
        }
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}