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

        int numPais;
        int posRandomRespuesta;

        int[] opcionesCapitales = new int[4];
        TextBox[] cajas = new TextBox[4];
        
        
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            numPais = NumRandom.Next(1, 13);
            posRandomRespuesta = NumRandom.Next(0, 4);
            textBox1.Text = Paises[numPais];

            cajas[0] = textBox3;
            cajas[1] = textBox4;
            cajas[2] = textBox5;
            cajas[3] = textBox6;
            List<int> opciones = new List<int> { numPais };

            while (opciones.Count < 4)
            {
                int r = NumRandom.Next(1, 13);
                if (!opciones.Contains(r))
                {
                    opciones.Add(r);
                    
                }
            }

            //opciones = opciones.OrderBy(x => NumRandom.Next() -2).ToList();
            int i = 0;
            foreach (TextBox box in cajas)
            {
                while (box.Text == "")
                {
                    box.Text = Capitales[opciones[i]];
                    i++;
                }
            }

            /*if(posRandomRespuesta == 0)
            {
                textBox3.Text = Capitales[numPais];
                textBox4.Text = Capitales[NumRandom.Next(1, 13)];
                textBox5.Text = Capitales[NumRandom.Next(1, 13)];
                textBox6.Text = Capitales[NumRandom.Next(1, 13)];
            } else if(posRandomRespuesta == 1)
            {
                textBox3.Text = Capitales[NumRandom.Next(1, 13)];
                textBox4.Text = Capitales[numPais];
                textBox5.Text = Capitales[NumRandom.Next(1, 13)];
                textBox6.Text = Capitales[NumRandom.Next(1, 13)];
            } else if (posRandomRespuesta == 2)
            {
                textBox3.Text = Capitales[NumRandom.Next(1, 13)];
                textBox4.Text = Capitales[NumRandom.Next(1, 13)];
                textBox5.Text = Capitales[numPais];
                textBox6.Text = Capitales[NumRandom.Next(1, 13)];
            } else if (posRandomRespuesta == 3){
                textBox3.Text = Capitales[NumRandom.Next(1, 13)];
                textBox4.Text = Capitales[NumRandom.Next(1, 13)];
                textBox5.Text = Capitales[NumRandom.Next(1, 13)];
                textBox6.Text = Capitales[numPais];
            }*/


        }



        private void holaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            holaToolStripMenuItem.Checked = true;
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
