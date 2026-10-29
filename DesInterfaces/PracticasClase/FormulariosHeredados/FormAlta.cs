using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FormulariosHeredados
{
    public partial class FormAlta : FormBase
    {
        public FormAlta()
        {
            InitializeComponent();
        }

        private void FormAlta_Load(object sender, EventArgs e)
        {
            CargarLista();
        }

        private void CargarLista()
        {
            listBox1.Items.Clear();
            foreach (Cliente c in listaClientes)
            {
                listBox1.Items.Add(c.getNombreCompleto());
            }
        }

        private void LimpiarCampos()
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
            textBox4.Clear();
            textBox5.Clear();
            checkBox1.Checked = false;
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            listBox1.ClearSelected();
            LimpiarCampos();
            textBox1.Focus();
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Trim() == "" || textBox2.Text.Trim() == "" || textBox3.Text.Trim() == "" || textBox4.Text.Trim() == "")
            {
                MessageBox.Show("Faltan campos por rellenar");
                return;
            }

            if (!textBox4.Text.Contains("@"))
            {
                MessageBox.Show("El e-mail no es valido");
                return;
            }

            String nombre = textBox1.Text.Trim();
            String apellidos = textBox2.Text.Trim();
            String ciudad = textBox3.Text.Trim();
            String email = textBox4.Text.Trim();
            String comentario = textBox5.Text.Trim();
            bool vip = checkBox1.Checked;

            int seleccionado = listBox1.SelectedIndex;

            // Comprobamos que no exista otro cliente con el mismo nombre y apellidos
            bool existe = false;
            for (int i = 0; i < listaClientes.Count; i++)
            {
                Cliente c = (Cliente)listaClientes[i];
                if (i != seleccionado && c.getNombre().ToLower().Equals(nombre.ToLower()) && c.getApellidos().ToLower().Equals(apellidos.ToLower()))
                {
                    existe = true;
                    break;
                }
            }

            if (existe)
            {
                MessageBox.Show("Ya hay un cliente con ese nombre y apellidos");
                return;
            }

            if (seleccionado == -1)
            {
                listaClientes.Add(new Cliente(nombre, apellidos, ciudad, email, comentario, vip));
                MessageBox.Show("Cliente dado de alta correctamente");
            }
            else
            {
                // Si hay un cliente seleccionado en la lista se modifica
                Cliente c = (Cliente)listaClientes[seleccionado];
                c.setNombre(nombre);
                c.setApellidos(apellidos);
                c.setCiudad(ciudad);
                c.setEmail(email);
                c.setComentario(comentario);
                c.setVip(vip);
                MessageBox.Show("Cliente modificado correctamente");
            }

            CargarLista();
            LimpiarCampos();
        }

        private void btnBorrar_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex == -1)
            {
                MessageBox.Show("Selecciona un cliente de la lista");
                return;
            }

            DialogResult respuesta = MessageBox.Show("Seguro que quieres borrar a " + listBox1.SelectedItem + "?", "Borrar", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (respuesta == DialogResult.Yes)
            {
                listaClientes.RemoveAt(listBox1.SelectedIndex);
                CargarLista();
                LimpiarCampos();
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex == -1)
            {
                return;
            }

            Cliente c = (Cliente)listaClientes[listBox1.SelectedIndex];
            textBox1.Text = c.getNombre();
            textBox2.Text = c.getApellidos();
            textBox3.Text = c.getCiudad();
            textBox4.Text = c.getEmail();
            textBox5.Text = c.getComentario();
            checkBox1.Checked = c.getVip();
        }
    }
}
