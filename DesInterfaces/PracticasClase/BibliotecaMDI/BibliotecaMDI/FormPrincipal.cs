namespace BibliotecaMDI
{
    public partial class GestionBiblioteca : Form
    {
        private FormAlta fAlt;
        private FormConsulta fCon;
        private bool formActivo;

        public GestionBiblioteca()
        {
            InitializeComponent();
        }

        private void GestionBiblioteca_Load(object sender, EventArgs e)
        {

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
