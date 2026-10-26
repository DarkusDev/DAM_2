namespace FormulariosHeredados
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            treeView1.Nodes.Add("Madrid", "Madrid", 2, 2);
            treeView1.Nodes.Add("Leon", "Leon", 2, 2);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ListViewItem l = listView1.Items.Add("Pedro", 0);
            l.SubItems.Add("Sanchez");
            l.SubItems.Add("Sanchez@gmail.com");
            l.SubItems.Add("Perro");

            ListViewItem l2 = listView1.Items.Add("Ana", 1);
            l2.SubItems.Add("Lopez");
            l2.SubItems.Add("Lopez@gmail.com");
            l2.SubItems.Add("Nada");


           
        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            treeView1.SelectedNode.Nodes.Add("Juan Sanz", "Juan Sanz", 0, 0);
            treeView1.SelectedNode.Nodes.Add("Ana Lopez", "Ana Lopez", 1, 1);
        }
    }
}
