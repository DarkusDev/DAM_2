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
    public partial class FormConsultaTree : FormBase
    {
        public FormConsultaTree()
        {
            InitializeComponent();
        }

        private void FormConsultaTree_Load(object sender, EventArgs e)
        {
            CargarArbol();
        }

        private void CargarArbol()
        {
            treeView1.Nodes.Clear();

            foreach (string ciudad in ObtenerCiudades())
            {
               
                TreeNode nodoCiudad = treeView1.Nodes.Add(ciudad, ciudad, 2, 2);

                foreach (Cliente c in listaClientes)
                {
                    if (c.getCiudad().ToLower().Equals(ciudad.ToLower()))
                    {
                       
                        int icono = 0;
                        if (c.getVip())
                        {
                            icono = 1;
                        }

                        TreeNode nodoCliente = nodoCiudad.Nodes.Add(c.getNombreCompleto(), c.getNombreCompleto(), icono, icono);
                        nodoCliente.Tag = c;
                    }
                }
            }
        }

        private void LimpiarCampos()
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
            textBox4.Clear();
            textBox5.Clear();
        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            
            if (e.Node.Tag == null)
            {
                LimpiarCampos();
                return;
            }

            Cliente c = (Cliente)e.Node.Tag;
            textBox1.Text = c.getNombre();
            textBox2.Text = c.getApellidos();
            textBox3.Text = c.getCiudad();
            textBox4.Text = c.getEmail();
            textBox5.Text = c.getComentario();
        }
    }
}
