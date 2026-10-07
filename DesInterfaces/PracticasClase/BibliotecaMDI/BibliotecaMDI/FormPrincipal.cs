using Microsoft.VisualBasic.ApplicationServices;
using System.Threading.Tasks;

namespace BibliotecaMDI
{
    public partial class FormPrincipal : Form
    {
        private FormAlta fAlt;
        private FormConsulta fCon;
        private bool formActivo;

        public List<Libro> listaLibros = new List<Libro>();
        public FormPrincipal()
        {
            InitializeComponent();
        }

        private async void GestionBiblioteca_Load(object sender, EventArgs e)
        {
            //Bitmap portada = Properties.FormPrincipal.l;
            //listaLibros.Add(new Libro("La odisea", "Homero", "Gredos", true, new Bitmap(@"C:\\Users\\alumno\\Downloads")));
            while (true)
            {

                label1.Text = "Hora Actual: " + DateTime.Now.ToString("HH:mm:ss");
                await Task.Delay(1000);
            }
        }



        private void mnuAlta_Click(object sender, EventArgs e)
        {
            if (ComprobarFormularios())
            {

                fAlt = new FormAlta();
                fAlt.WindowState = FormWindowState.Maximized;
                fAlt.MdiParent = this;
                fAlt.Show();
            }

        }

        private void mnuConsulta_Click(object sender, EventArgs e)
        {
            if (ComprobarFormularios())
            {

                fCon = new FormConsulta();
                fCon.WindowState = FormWindowState.Maximized;
                fCon.MdiParent = this;
                fCon.Show();
            }

        }

        private bool ComprobarFormularios()
        {
            foreach (Form f in MdiChildren)
            {
                if (f.Enabled)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            return true;
        }

        private void mnuSalir_Click(object sender, EventArgs e)
        {
            DialogResult respuesta = MessageBox.Show("Seguro que quieres salir?", "Salir", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (respuesta == DialogResult.Yes)
            {
                Application.Exit();
            }
        }

        private void FormPrincipal_FormClosing(object sender, FormClosingEventArgs e)
        {
            DialogResult respuesta = MessageBox.Show("Seguro que quieres salir?", "Salir", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (respuesta == DialogResult.No)
            {
                e.Cancel = true;
            }
        }

        private void FormPrincipal_MdiChildActivate(object sender, EventArgs e)
        {
            label1.Visible = (this.ActiveMdiChild == null);
        }
    }
}


