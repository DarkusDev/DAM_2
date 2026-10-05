using Microsoft.VisualBasic.ApplicationServices;

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

        private void GestionBiblioteca_Load(object sender, EventArgs e)
        {
            //Bitmap portada = Properties.FormPrincipal.l;
            listaLibros.Add(new Libro("La odisea", "Homero", "Gredos", true, new Bitmap(@"C:\\Users\\alumno\\Downloads")));
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
            Application.Exit();
        }
    }
}

/*foreach(Form f in MdiChildren)
           {
               MessageBox.Show(f.GetType().ToString());
           }*/
