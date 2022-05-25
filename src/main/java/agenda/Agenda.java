
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
    private String nombre;
    
    public Agenda(String name){
        
        if(name != ""){
            this.nombre = name;
        }else{
            this.nombre = "Untitled";
        }
    }

    Agenda()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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
    public static void ListaAgenda(Agenda a){
    
        ArrayList<Contacto> Listado = new ArrayList<>();
        Listado = a.getContactos();
        System.out.print("AGENDA: ");
        System.out.print(a.getnombre(a));
        System.out.println("\t\tNum.Contactos:"+Listado.size());
        System.out.format("%-24s%-15s%-15s\n", "eMail","Teléfono","Nombre");
        System.out.println("-----------------------------------------------------               ");
        for (Contacto c : Listado){
            System.out.format("%-24s%-15s%-15s\n",c.getEmail(),c.getTelefono(),c.               getNombre());
        }
        System.out.println("-----------------------------------------------------           ");
    }

    private String getnombre(Agenda a)
    {
        return nombre;
    }
    
    

}
