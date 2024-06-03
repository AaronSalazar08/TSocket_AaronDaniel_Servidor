package Vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controlador.Metodos;

public class VistaPrincipal extends JFrame implements ActionListener {


//Metodo para la llamada de los metodos de las constantes mediante una instacia de la clase Metodos 

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    public JButton botonPedidos, botonEstado, botonNoticias, botonSolicitudesTrabajos, botonAtencionCliente,
            botonCerrarServidor, botonUsuario;

    public JLabel Logo_Label, usuarioLabel;
    public JPanel panelVistaPrincipal = new JPanel();
    public ImageIcon Logo;
    public ImageIcon imagen;
    public Icon icono;

    //Metodo constructor 

    public VistaPrincipal() {
        //Inicializando JPanel 

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Menú Servidor");
        setSize(500, 600);
        setContentPane(panelVistaPrincipal);
        panelVistaPrincipal.setBackground(new Color(26, 28, 37));
        panelVistaPrincipal.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);

        //Inicializando constantes para el JPanel

        //ImagenIcon 

        Logo = new ImageIcon("Vista/Imagenes/PIZZA_ROMA.png");
        Image imagenLogo = Logo.getImage();
        Image nuevaImagenLogo = imagenLogo.getScaledInstance(300, 180, Image.SCALE_SMOOTH);
        Icon nuevoIconoLogo = new ImageIcon(nuevaImagenLogo);
        Logo_Label = new JLabel();
        Logo_Label.setIcon(nuevoIconoLogo);
        Logo_Label.setBounds(100, 20, 250, 180);

        //JButton

        botonPedidos = new JButton("Ver Pedidos");
        botonPedidos.setBounds(150, 200, 200, 30);
        botonPedidos.setBackground(new Color(111, 113, 121));
        botonPedidos.setForeground(new Color(255, 255, 255));
        botonPedidos.setToolTipText("Visualizar los pedidos que se han realizado");
        ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/pedidos.png");
        Image imagenVovler = iconoVolver.getImage();
        Image imagenVolverAjustada = imagenVovler.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoVolverAjustada = new ImageIcon(imagenVolverAjustada);
        botonPedidos.setIcon(iconoVolverAjustada);
        botonPedidos.addActionListener(this);

        botonEstado = new JButton("Estado Pedidos");
        botonEstado.setBounds(150, 250, 200, 30);
        botonEstado.setBackground(new Color(111, 113, 121));
        botonEstado.setForeground(new Color(255, 255, 255));
        botonEstado.setToolTipText("Responder a los clientes acerca del estado actual de sus pedidos");
        ImageIcon iconoEstado = new ImageIcon("Vista/Imagenes/Estado.png");
        Image imagenEstado = iconoEstado.getImage();
        Image imagenEstadoAjustada = imagenEstado.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEstadoAjustada = new ImageIcon(imagenEstadoAjustada);
        botonEstado.setIcon(iconoEstadoAjustada);
        botonEstado.addActionListener(this);

        botonNoticias = new JButton("Agregar Noticias");
        botonNoticias.setBounds(150, 300, 200, 30);
        botonNoticias.setBackground(new Color(111, 113, 121));
        botonNoticias.setForeground(new Color(255, 255, 255));
        botonNoticias.setToolTipText("Actualizar las noticias destacadas de Pizza Roma");
        ImageIcon iconoNoticia = new ImageIcon("Vista/Imagenes/noticias.png");
        Image imagenNoticia = iconoNoticia.getImage();
        Image imagenNoticiaAjustada = imagenNoticia.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoNoticiaAjustada = new ImageIcon(imagenNoticiaAjustada);
        botonNoticias.setIcon(iconoNoticiaAjustada);
        botonNoticias.addActionListener(this);

        botonSolicitudesTrabajos = new JButton(" Ver Aplicantes");
        botonSolicitudesTrabajos.setBounds(150, 350, 200, 30);
        botonSolicitudesTrabajos.setBackground(new Color(111, 113, 121));
        botonSolicitudesTrabajos.setForeground(new Color(255, 255, 255));
        botonSolicitudesTrabajos.setToolTipText("Revisar solicitudes de aplicantes a puestos de trabajo");
        ImageIcon iconoAplicantes = new ImageIcon("Vista/Imagenes/aplicantes.png");
        Image imagenAplicantes = iconoAplicantes.getImage();
        Image imagenAplicantesAjustada = imagenAplicantes.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoAplicantesAjustada = new ImageIcon(imagenAplicantesAjustada);
        botonSolicitudesTrabajos.setIcon(iconoAplicantesAjustada);
        botonSolicitudesTrabajos.addActionListener(this);

        botonAtencionCliente = new JButton();
        botonAtencionCliente.setBounds(300, 500, 60, 35);
        botonAtencionCliente.setBackground(new Color(111, 113, 121));
        botonAtencionCliente.setForeground(new Color(255, 255, 255));
        botonAtencionCliente.setToolTipText("Atender a los clientes con sus inquietudes");
        ImageIcon iconoBuzon = new ImageIcon("Vista/Imagenes/buzonClientes.png");
        Image imagenBuzon = iconoBuzon.getImage();
        Image imagenBuzonAjustada = imagenBuzon.getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon iconoBuzonAjustada = new ImageIcon(imagenBuzonAjustada);
        botonAtencionCliente.setIcon(iconoBuzonAjustada);
        botonAtencionCliente.addActionListener(this);
        botonAtencionCliente.setBorderPainted(false);

        botonCerrarServidor = new JButton();
        botonCerrarServidor.setBounds(380, 500, 60, 30);
        botonCerrarServidor.setBackground(new Color(111, 113, 121));
        botonCerrarServidor.setForeground(new Color(255, 255, 255));
        botonCerrarServidor.setToolTipText("Cerrar el servidor");
        ImageIcon iconoCerrarServidor = new ImageIcon("Vista/Imagenes/apagar.png");
        Image imagenCerrarServidor = iconoCerrarServidor.getImage();
        Image imagenCerrarServidorAjustada = imagenCerrarServidor.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoCerrarServidorAjustada = new ImageIcon(imagenCerrarServidorAjustada);
        botonCerrarServidor.setIcon(iconoCerrarServidorAjustada);
        botonCerrarServidor.setBorderPainted(false);
        botonCerrarServidor.addActionListener(this);

        botonUsuario = new JButton();
        botonUsuario.setBounds(15, 10, 30, 30);
        botonUsuario.setBorderPainted(false);
        botonUsuario.setOpaque(false);
        botonUsuario.setBackground(new Color(26, 28, 37));
        botonUsuario.setToolTipText("Cerrar Sesión");
        botonUsuario.addActionListener(this);
        this.PintarB(this.botonUsuario, "Vista/Imagenes/usuario.png");

        //JLabel

        usuarioLabel = new JLabel();
        usuarioLabel.setBounds(60, 15, 250, 20);
        usuarioLabel.setForeground(new Color(255, 255, 255));

        // Agregar elementos al JPanel
        panelVistaPrincipal.add(Logo_Label);
        panelVistaPrincipal.add(botonPedidos);
        panelVistaPrincipal.add(botonEstado);
        panelVistaPrincipal.add(botonNoticias);
        panelVistaPrincipal.add(botonSolicitudesTrabajos);
        panelVistaPrincipal.add(botonAtencionCliente);
        panelVistaPrincipal.add(botonCerrarServidor);
        panelVistaPrincipal.add(botonUsuario);
        panelVistaPrincipal.add(usuarioLabel);

    }


    //Metodo para poner imagines a JButton 

    private void PintarB(JButton lbl, String ruta) { 
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(),
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
        this.repaint();
    }



    //Metodo para la acción de los botones mediante una instancia de la clase de Metodos 

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == botonPedidos){

            metodos.principalApedidos();
          
            
        }

        if(e.getSource() == botonEstado){

            metodos.principalAEstado();
        }

        if(e.getSource() == botonNoticias){

            metodos.principalAnoticias();
        }

        if(e.getSource() == botonSolicitudesTrabajos){

            metodos.principalAsolicitudes();
          
           
        }

        if(e.getSource() == botonAtencionCliente){

            metodos.principalAbuzon();
           
        }

        if(e.getSource() == botonCerrarServidor){

            metodos.cerrarServidor();
        }
    }

}
