/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom;

import dao.clienteDao;
import dao.clienteDaoImplement;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import model.Cliente;

/**
 *
 * @author Lenovo
 */
@FacesConverter("userValidator")
public class UserValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        String username = (String) value;
        if (usernameExists(username)) {
            throw new ValidatorException(new FacesMessage("Nombre de usuario ya existe."));
        }
    }

    private boolean usernameExists(String username) {
         boolean existe = false;
        
        
        // check if username exists here
        clienteDao dao = new clienteDaoImplement();
        List<Cliente> lista = dao.mostrar();
        try {
            for(Cliente cliente : lista) {
                if (cliente.getUsuario()== null ? username == null : cliente.getUsuario().equals(username)) {
                    existe = true;
                }
             }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
         
        
        return existe;
    }
}