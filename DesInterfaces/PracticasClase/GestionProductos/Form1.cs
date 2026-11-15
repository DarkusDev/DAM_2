using System.Text;

namespace GestionProductos
{
    public partial class Form1 : Form
    {
        private const String RUTA_FICHERO = @"C:\Temp\Productos.txt";

        public List<Producto> listaProductos = new List<Producto>();
        public List<String> listaCategorias = new List<String>();

        Button[] botones = new Button[8];

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            botones[0] = button1;
            botones[1] = button2;
            botones[2] = button3;
            botones[3] = button4;
            botones[4] = button5;
            botones[5] = button6;
            botones[6] = button7;
            botones[7] = button8;

            // Al principio los botones estan ocultos hasta saber cuantas categorias hay
            foreach (Button b in botones)
            {
                b.Visible = false;
            }

            LeerFichero();
            RellenarBotones();
        }

        private void LeerFichero()
        {
            if (!File.Exists(RUTA_FICHERO))
            {
                MessageBox.Show("No se ha encontrado el fichero " + RUTA_FICHERO, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            try
            {
                // El fichero esta en ANSI, por eso se lee con Latin1 (para que salgan bien las tildes)
                String[] lineas = File.ReadAllLines(RUTA_FICHERO, Encoding.Latin1);

                foreach (String linea in lineas)
                {
                    if (linea.Trim().Equals(""))
                    {
                        continue;
                    }

                    String[] campos = linea.Split(';');

                    int id = int.Parse(campos[0].Trim());
                    String nombre = campos[1].Trim();
                    int stock = int.Parse(campos[2].Trim());
                    String categoria = campos[3].Trim();

                    listaProductos.Add(new Producto(id, nombre, stock, categoria));

                    if (!listaCategorias.Contains(categoria))
                    {
                        listaCategorias.Add(categoria);
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al leer el fichero: " + ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void RellenarBotones()
        {
            for (int i = 0; i < listaCategorias.Count && i < botones.Length; i++)
            {
                botones[i].Text = listaCategorias[i];
                botones[i].Visible = true;
            }
        }

        private void CargarListView(String categoria)
        {
            listView1.Items.Clear();

            foreach (Producto p in listaProductos)
            {
                if (p.getCategoria().Equals(categoria))
                {
                    ListViewItem l = listView1.Items.Add(p.getId().ToString());
                    l.SubItems.Add(p.getNombre());
                    l.SubItems.Add(p.getStock().ToString());
                }
            }

            label2.Text = "Categoria: " + categoria + " (" + listView1.Items.Count + " productos)";
        }

        // Todos los botones usan este mismo evento
        private void button_Click(object sender, EventArgs e)
        {
            Button b = (Button)sender;
            CargarListView(b.Text);
        }
    }
}
