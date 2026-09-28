using System.Collections;

namespace Trivial
{
    public partial class Form1 : Form
    {

        List<String> Paises = new List<String> { "España", "Rumania", "Francia", "Alemania",
        "Suiza", "Suecia", "Hungria", "Bulgaria", "Portugal", "Noruega", "Rusia", "Ucrania"
        };

        string[] Capitales = new string[] { "Madrid", "Bucarest", "Paris", "Berlin",
        "Berna", "Estocolmo", "Budapest", "Sofia", "Lisboa", "Oslo", "Moscu", "Kiev"
        };

        List<String> PaisesUsados = new List<String>();

        public Random NumRandom = new Random();

        int numPais;
        int posRandomRespuesta;

        int[] opcionesCapitales = new int[4];
        TextBox[] cajas = new TextBox[4];

        String opcionSeleccionada = "";

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            numPais = NumRandom.Next(1, Paises.Count);
            textBox1.Text = Paises[numPais];

            cajas[0] = textBox3;
            cajas[1] = textBox4;
            cajas[2] = textBox5;
            cajas[3] = textBox6;

            List<int> opciones = new List<int> { numPais };
            while (opciones.Count < 4)
            {
                int r = NumRandom.Next(1, Capitales.Length);
                if (!opciones.Contains(r))
                    opciones.Add(r);
            }

            opciones = opciones.OrderBy(x => NumRandom.Next()).ToList();

            int i = 0;
            foreach (TextBox box in cajas)
            {
                box.Text = Capitales[opciones[i]];
                i++;
            }

        }



        private void holaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            holaToolStripMenuItem.Checked = true;
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
           
        }

        private void textBox3_Click(object sender, EventArgs e)
        {
            TextBox t = (TextBox)sender;
            opcionSeleccionada = t.Text.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(opcionSeleccionada == Capitales[numPais])
            {
                textBox2.Text = "Correcto!";
                CargaPregunta();
            }
            else
            {
                textBox2.Text = "Incorrecto!";
                CargaPregunta();
            }
        }

        public void CargaPregunta()
        {
            String numPaisAntiguo = Paises[numPais];
            PaisesUsados.Add(numPaisAntiguo);

            for(int pais = 0; pais < PaisesUsados.Count; pais++)
            {
                if (PaisesUsados.Contains(numPaisAntiguo))
                {
                    break;
                }
                else
                {
                    numPais = NumRandom.Next(1, Paises.Count);
                }
            }
           
            textBox1.Text = Paises[numPais];

            cajas[0] = textBox3;
            cajas[1] = textBox4;
            cajas[2] = textBox5;
            cajas[3] = textBox6;

            List<int> opciones = new List<int> { numPais };
            while (opciones.Count < 4)
            {
                int r = NumRandom.Next(1, Capitales.Length);
                if (!opciones.Contains(r))
                    opciones.Add(r);
            }

            opciones = opciones.OrderBy(x => NumRandom.Next()).ToList();

            int i = 0;
            foreach (TextBox box in cajas)
            {
                box.Text = Capitales[opciones[i]];
                i++;
            }
        }
    }

   
}
