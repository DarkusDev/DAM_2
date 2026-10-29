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
    public partial class FormBase : Form
    {
        // Lista de clientes compartida por todos los formularios
        public static ArrayList listaClientes = new ArrayList();

        // Para saber si estamos cerrando un formulario porque se abre otro
        private static bool cambiandoFormulario = false;

        public FormBase()
        {
            InitializeComponent();
        }

        private void mnuAlta_Click(object sender, EventArgs e)
        {
            AbrirFormulario(new FormAlta());
        }

        private void mnuConsultaList_Click(object sender, EventArgs e)
        {
            AbrirFormulario(new FormConsultaList());
        }

        private void mnuConsultaTree_Click(object sender, EventArgs e)
        {
            AbrirFormulario(new FormConsultaTree());
        }

        private void mnuSalir_Click(object sender, EventArgs e)
        {
            DialogResult respuesta = MessageBox.Show("Seguro que quieres salir?", "Salir", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (respuesta == DialogResult.Yes)
            {
                Application.Exit();
            }
        }

        private void AbrirFormulario(Form nuevo)
        {
            // Si ya estamos en ese formulario no hacemos nada
            if (this.GetType() == nuevo.GetType())
            {
                nuevo.Dispose();
                return;
            }

            // Guardamos los formularios abiertos antes de abrir el nuevo
            List<Form> abiertos = new List<Form>();
            foreach (Form f in Application.OpenForms)
            {
                abiertos.Add(f);
            }

            nuevo.Show();

            // Solo puede haber un formulario visible: el padre se oculta y el resto se cierran
            cambiandoFormulario = true;
            foreach (Form f in abiertos)
            {
                if (f.GetType() == typeof(FormBase))
                {
                    f.Hide();
                }
                else
                {
                    f.Close();
                }
            }
            cambiandoFormulario = false;
        }

        private void FormBase_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (e.CloseReason != CloseReason.UserClosing)
            {
                return;
            }

            if (this.GetType() == typeof(FormBase))
            {
                DialogResult respuesta = MessageBox.Show("Seguro que quieres salir?", "Salir", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

                if (respuesta == DialogResult.No)
                {
                    e.Cancel = true;
                }
            }
            else if (!cambiandoFormulario)
            {
                // Si se cierra un formulario hijo con la X volvemos al formulario padre
                foreach (Form f in Application.OpenForms)
                {
                    if (f.GetType() == typeof(FormBase))
                    {
                        f.Show();
                    }
                }
            }
        }

        // Devuelve las ciudades de los clientes sin repetir
        protected List<string> ObtenerCiudades()
        {
            List<string> ciudades = new List<string>();

            foreach (Cliente c in listaClientes)
            {
                bool existe = false;
                foreach (string ciudad in ciudades)
                {
                    if (ciudad.ToLower().Equals(c.getCiudad().ToLower()))
                    {
                        existe = true;
                        break;
                    }
                }

                if (!existe)
                {
                    ciudades.Add(c.getCiudad());
                }
            }

            return ciudades;
        }
    }
}
