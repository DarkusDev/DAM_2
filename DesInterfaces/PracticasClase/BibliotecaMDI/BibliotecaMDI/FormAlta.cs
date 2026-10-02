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
    public partial class FormAlta : Form
    {
        public String titulo = "";
        public String autor = "";
        public String editorial = "";
        public bool nuevo = false;
        public Bitmap imagenPortada = null;
        public FormAlta()
        {
            InitializeComponent();
        }

        private void FormAlta_FormClosed(object sender, FormClosedEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            openFileDialog1.FileName = "";
            openFileDialog1.InitialDirectory = "C:\\";
            openFileDialog1.Filter = "jpg files (*.jpg)|*.jpg|All files (*.*)|*.*";
            openFileDialog1.ShowDialog();

            try
            {
                imagenPortada = new Bitmap(openFileDialog1.FileName);
                pictureBox1.Image = imagenPortada;
            }
            catch (Exception ex)
            {

            }




        }

        private void button3_Click(object sender, EventArgs e)
        {
            titulo = textBox1.Text.ToString();
            autor = textBox2.Text.ToString();
            editorial = textBox3.Text.ToString();
            if (checkBox1.Checked)
            {
                nuevo = true;
            }
            else
            {
                nuevo = false;
            }
            imagenPortada = new Bitmap(openFileDialog1.FileName);

            FormPrincipal frmPrincipal = new FormPrincipal();

            List<Libro> listaLibros = frmPrincipal.listaLibros;

            listaLibros.Add(new Libro(titulo, autor, editorial, nuevo, imagenPortada));

    }
    }
}
