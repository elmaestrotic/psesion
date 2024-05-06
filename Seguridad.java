package psesion;

import javax.swing.JOptionPane;
public class Seguridad {
    FrmSesion2 login = new FrmSesion2();
    String usuario, res;
    public void validarUsuario(String datos[], String user, String clave, int intentos) {
        boolean encontrado = false;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].equalsIgnoreCase(user) && datos[i + 1].equals(clave)) {
                res = "Bienvenido " + user;
                encontrado = true;
                intentos = 0;
                login.setIntentos(intentos);
                JOptionPane.showMessageDialog(null, res,"    Inicio de Sesión",JOptionPane.INFORMATION_MESSAGE);
                //SI el usuario es valido que me cargue l MDi o form ppal-->papa
                new Papa().setVisible(true);
                break;
            } //fin del condicional 
        }//fin para
        if (encontrado==false) {
            res = "clave y/o usuario erróneos van " + intentos + " intentos fallidos";
            JOptionPane.showMessageDialog(null, res,"    Inicio de Sesión",JOptionPane.ERROR_MESSAGE);
        }
        if (intentos > 2) {
            JOptionPane.showMessageDialog(null, " 3 intentos fallidos, chao", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
