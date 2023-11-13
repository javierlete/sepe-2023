package com.ipartek.formacion.chat.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.chat.accesodatos.DaoUsuario;
import com.ipartek.formacion.chat.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.chat.negocio.UsuarioNegocio;
import com.ipartek.formacion.chat.negocio.UsuarioNegocioImpl;
import com.ipartek.formacion.chat.pojos.Usuario;

public class PresentacionSwing {

	private UsuarioNegocio un;
	private JFrame frame;
	private JTable tListado;
	private DefaultTableModel modelo;
	private JPanel pFormulario;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblNombre;
	private JTextField tfNombre;
	private JLabel lblFecha;
	private JTextField tfFecha;

	static {
		DaoUsuario dao = new DaoUsuarioMemoria();

		dao.insertar(new Usuario("Prueba1"));
		dao.insertar(new Usuario("Prueba2"));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionSwing window = new PresentacionSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PresentacionSwing() {
		initialize();

		modelo = (DefaultTableModel) tListado.getModel();

		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("ÚLTIMA CONEXIÓN");

		Object[] fila;

		un = new UsuarioNegocioImpl();

		for (Usuario u : un.listado()) {
			fila = new Object[3];

			fila[0] = u.getId();
			fila[1] = u.getNombre();
			fila[2] = u.getFechaUltimaConexion();

			modelo.addRow(fila);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tListado = new JTable();
		tListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int fila = tListado.rowAtPoint(p);

				Long id = (Long) modelo.getValueAt(fila, 0);
				// JOptionPane.showMessageDialog(frame, id);
				
				Usuario u = un.datosUsuario(id);
				
				tfId.setText(id.toString());
				tfNombre.setText(u.getNombre());
				tfFecha.setText(u.getFechaUltimaConexion().toString());
			}
		});

		JScrollPane scrollPane = new JScrollPane(tListado);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		pFormulario = new JPanel();
		frame.getContentPane().add(pFormulario, BorderLayout.SOUTH);
		GridBagLayout gbl_pFormulario = new GridBagLayout();
		gbl_pFormulario.columnWidths = new int[]{0, 0};
		gbl_pFormulario.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pFormulario.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pFormulario.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pFormulario.setLayout(gbl_pFormulario);
		
		lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 0);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		pFormulario.add(lblId, gbc_lblId);
		
		tfId = new JTextField();
		GridBagConstraints gbc_tfId = new GridBagConstraints();
		gbc_tfId.insets = new Insets(0, 0, 5, 0);
		gbc_tfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfId.gridx = 0;
		gbc_tfId.gridy = 1;
		pFormulario.add(tfId, gbc_tfId);
		tfId.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		pFormulario.add(lblNombre, gbc_lblNombre);
		
		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 0;
		gbc_tfNombre.gridy = 3;
		pFormulario.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		lblFecha = new JLabel("Fecha última conexión");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 0);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 4;
		pFormulario.add(lblFecha, gbc_lblFecha);
		
		tfFecha = new JTextField();
		GridBagConstraints gbc_tfFecha = new GridBagConstraints();
		gbc_tfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_tfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFecha.gridx = 0;
		gbc_tfFecha.gridy = 5;
		pFormulario.add(tfFecha, gbc_tfFecha);
		tfFecha.setColumns(10);
	}

}
