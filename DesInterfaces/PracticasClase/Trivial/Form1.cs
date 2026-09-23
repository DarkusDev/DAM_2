namespace Trivial
{
    public partial class Form1 : Form
    {

        string[] Paises = new string[] { "España", "Rumania", "Francia", "Alemania",
        "Suiza", "Suecia", "Hungria", "Bulgaria", "Portugal", "Noruega", "Rusia", "Ucrania"
        };

        string[] Capitales = new string[] { "Madrid", "Bucarest", "Paris", "Berlin",
        "Berna", "Estocolmo", "Budapest", "Sofia", "Lisboa", "Oslo", "Moscu", "Kiev"
        };

        public Random NumRandom = new Random();

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            textBox1.Text = Paises[NumRandom];
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox6_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
