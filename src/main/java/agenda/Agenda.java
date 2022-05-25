
package agenda;

//import exceptions.ContactoInexistenteException;
import exceptions.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author loned
 */
public class Agenda {

    private HashMap<String, Contacto> contactos = new HashMap();
    private static int n = 0;
    private static int count = 0;
    
    /**
     * Añade un nuevo contacto
     * @param contacto Contacto que queremos añadir
     * @return Objeto contacto añadido o genera una excepcion si ya existiera
     * @throws ContactoRepetidoException Ecepcion programada, ver paquete exception
     */
    public Contacto addContacto(Contacto contacto) throws ContactoRepetidoException {
        if (contactos.containsKey(contacto.getEmail())) {
            //
            throw new ContactoRepetidoException("Ya existe un contacto con email: " + contacto.getEmail());
        }
        n++;
        contacto.setN(n);
        contactos.put(contacto.getEmail(), contacto);
        count++;
        return contacto;
    }

    /**
     * Elimina uno de los contactos que tengamos registrados
     * @param email Eliminamos el contacto segun el email
     * @return Si lo consigue eliminar, retorna el contacto eliminado, si no retorna null
     */
    public Contacto eliminarContacto(String email) { 
        Contacto contacto = buscarContacto(email);
        if (contacto != null) {
        contactos.remove(email);
        count--;
        }
        return contacto;
    }

    /**
     * Busca un contacto dentro de la agenda
     * @param email Busca contacto segun el email
     * @return Devuelve el contacto que hemos eliminado, o si no retorna null
     */
    public Contacto buscarContacto(String email) { 
        Contacto contacto = null;
        if (!contactos.containsKey(email)) {

            return null;
        }
        else{
        return contactos.get(email);
        }
    }

    /**
     * Lista todos los contactos que tenemos en la agenda
     * @return retorna un array con los contactos registrados
     */
    public ArrayList<Contacto> getContactos() {
        ArrayList<Contacto> contactosList = new ArrayList<>();
        contactosList.addAll(contactos.values());
        return contactosList;
    }
    
    

}
