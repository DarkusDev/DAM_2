using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BibliotecaMDI
{
    public partial class FormConsulta : Form
    {
        public FormPrincipal frmPrincipal;
        public List<Libro> listaLibros;
        public FormConsulta()
        {
            InitializeComponent();

        }

        private void FormConsulta_Load(object sender, EventArgs e)
        {
            frmPrincipal = (FormPrincipal)this.MdiParent;
            listaLibros = frmPrincipal.listaLibros;

            foreach (Libro l in listaLibros)
            {
                listBoxTitulos.Items.Add(l.getTitulo()).ToString();

            }


            //;
        }

        private void radioButton1_Click(object sender, EventArgs e)
        {
            listBoxAutorEditorial.Items.Clear();
            foreach (Libro l in listaLibros)
            {
                listBoxAutorEditorial.Items.Add(l.getAutor()).ToString();

            }

        }

        private void radioButton2_Click(object sender, EventArgs e)
        {
            listBoxAutorEditorial.Items.Clear();
            foreach (Libro l in listaLibros)
            {
                listBoxAutorEditorial.Items.Add(l.getEditorial()).ToString();
            }
        }

        private void listBoxTitulos_Click(object sender, EventArgs e)
        {
            foreach (Libro l in listaLibros)
            {
                if (l.getTitulo().ToString().Equals(listBoxTitulos.SelectedItem.ToString())){
                    pictureBox1.Image = l.getImage();
                }

            }
        }
    }
}
