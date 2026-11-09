using System.Collections;
using System.IO;

namespace ExploradorFicheros
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            foreach (string unidad in Directory.GetLogicalDrives())
            {
                TreeNode nodo = new TreeNode(unidad);
                nodo.Tag = unidad;              // ruta completa
                treeView1.Nodes.Add(nodo);
            }

            //ListViewItem l = listView1.Items.Add("Darius");
            // l.SubItems.Add(DateTime.Now.ToString());

        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            listView1.Items.Clear();
            TreeNode nodoActual = e.Node;
            string ruta = (string)nodoActual.Tag;
            

            // Evita duplicados: solo carga si aún no tiene hijos
            if (nodoActual.Nodes.Count > 0)
                return;

            try
            {
                foreach (string dir in Directory.GetDirectories(ruta))
                {
                    TreeNode hijo = new TreeNode(Path.GetFileName(dir)); // solo el nombre
                    hijo.Tag = dir;                                      // ruta completa
                    nodoActual.Nodes.Add(hijo);                          // dentro del nodo
                }

                // Opcional: mostrar también los ficheros
                foreach (string fichero in Directory.GetFiles(ruta))
                {
                    FileInfo ficheros = new FileInfo(fichero);
                    ListViewItem l = listView1.Items.Add(ficheros.Name);
                    l.SubItems.Add(ficheros.CreationTime.ToString());
                    l.SubItems.Add(ficheros.LastWriteTime.ToString());
                    l.SubItems.Add(ficheros.LastAccessTime.ToString());
                }

                nodoActual.Expand();
            }
            catch (UnauthorizedAccessException)
            {
                MessageBox.Show("Acceso Denegado");
            }
            catch (IOException ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
