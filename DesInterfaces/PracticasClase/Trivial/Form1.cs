using System.Collections;

namespace Trivial
{
    public partial class Form1 : Form
    {

        List<String> Paises = new List<String> { "España", "Rumania", "Francia", "Alemania",
        "Suiza", "Suecia", "Hungria", "Bulgaria", "Portugal", "Noruega", "Rusia", "Ucrania"
        };

        List<String> Capitales = new List<String> { "Madrid", "Bucarest", "Paris", "Berlin",
        "Berna", "Estocolmo", "Budapest", "Sofia", "Lisboa", "Oslo", "Moscu", "Kiev"
        };

        List<String> PaisesUsados = new List<String>();
        List<String> CapitalesUsadas = new List<String>();

        public Random NumRandom = new Random();

        int numPais;
        int numCapital;
        int posRandomRespuesta;
        float porcentaje;

        int respuestasCorrectas;
        int respuestasIncorrectas;

        int[] opcionesCapitales = new int[4];
        TextBox[] cajas = new TextBox[4];

        String opcionSeleccionada = "";

        List<int> opciones;
        int i;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            if (!paisesCapitalesToolStripMenuItem.Checked && !capitalesPaisesToolStripMenuItem.Checked)
            {
                paisesCapitalesToolStripMenuItem.Checked = true;
            }

            if (!multiplesOpcionesToolStripMenuItem.Checked && !escribeRespuestaToolStripMenuItem.Checked)
            {
                multiplesOpcionesToolStripMenuItem.Checked = true;
            }

            PaisesUsados.Clear();
            CapitalesUsadas.Clear();
            respuestasCorrectas = 0;
            respuestasIncorrectas = 0;
            opcionSeleccionada = "";
            button1.Enabled = true;


            if (paisesCapitalesToolStripMenuItem.Checked)
            {

                textBox7.Text = "0";

                numPais = NumRandom.Next(0, Paises.Count);
                textBox1.Text = Paises[numPais];

                cajas[0] = textBox3;
                cajas[1] = textBox4;
                cajas[2] = textBox5;
                cajas[3] = textBox6;

                List<int> opciones = new List<int> { numPais };
                while (opciones.Count < 4)
                {
                    int r = NumRandom.Next(0, Capitales.Count);
                    if (!opciones.Contains(r))
                        opciones.Add(r);
                }

                opciones = opciones.OrderBy(x => NumRandom.Next()).ToList();

                i = 0;
                foreach (TextBox box in cajas)
                {
                    box.Text = Capitales[opciones[i]];
                    i++;
                }

                ModoRespuesta();
            }
            else if (capitalesPaisesToolStripMenuItem.Checked)
            {
                textBox7.Text = "0";

                numCapital = NumRandom.Next(0, Capitales.Count);
                textBox1.Text = Capitales[numCapital];

                cajas[0] = textBox3;
                cajas[1] = textBox4;
                cajas[2] = textBox5;
                cajas[3] = textBox6;

                List<int> opciones = new List<int> { numCapital };
                while (opciones.Count < 4)
                {
                    int r = NumRandom.Next(0, Paises.Count);
                    if (!opciones.Contains(r))
                        opciones.Add(r);
                }

                opciones = opciones.OrderBy(x => NumRandom.Next()).ToList();

                i = 0;
                foreach (TextBox box in cajas)
                {
                    box.Text = Paises[opciones[i]];
                    i++;
                }

                ModoRespuesta();
            }

        }

        public void ModoRespuesta()
        {
            if (escribeRespuestaToolStripMenuItem.Checked)
            {
                textBox3.ReadOnly = false;
                textBox3.Text = "";
                textBox4.Visible = false;
                textBox5.Visible = false;
                textBox6.Visible = false;
                textBox3.Focus();
            }
            else
            {
                textBox3.ReadOnly = true;
                textBox4.Visible = true;
                textBox5.Visible = true;
                textBox6.Visible = true;
            }
        }

        private void holaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            textBox2.Text = "";
            Form1_Load(sender, e);

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
            String respuestaCorrecta;
            if (paisesCapitalesToolStripMenuItem.Checked)
            {
                respuestaCorrecta = Capitales[numPais];
            }
            else
            {
                respuestaCorrecta = Paises[numCapital];
            }

            if (escribeRespuestaToolStripMenuItem.Checked)
            {
                opcionSeleccionada = textBox3.Text.Trim();
            }

            if (opcionSeleccionada.ToLower().Equals(respuestaCorrecta.ToLower()))
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
            if (paisesCapitalesToolStripMenuItem.Checked)
            {
                PaisesUsados.Add(Paises[numPais]);
                if (textBox2.Text.Equals("Correcto!"))
                {
                    respuestasCorrectas++;
                }
                else
                {
                    respuestasIncorrectas++;
                }

                porcentaje = PaisesUsados.Count * 100 / Paises.Count;
                textBox7.Text = porcentaje + "%";
                if (PaisesUsados.Count == Paises.Count)
                {
                    textBox2.Text = "Fin del juego!";
                    textBox1.Text = "Correctas: " + respuestasCorrectas + " Incorrectas: " + respuestasIncorrectas;
                    button1.Enabled = false;
                    return;
                }

                do
                {
                    numPais = NumRandom.Next(Paises.Count);
                }
                while (PaisesUsados.Contains(Paises[numPais]));

                textBox1.Text = Paises[numPais];

                cajas[0] = textBox3;
                cajas[1] = textBox4;
                cajas[2] = textBox5;
                cajas[3] = textBox6;

                List<int> opciones = new List<int> { numPais };
                while (opciones.Count < 4)
                {
                    int r = NumRandom.Next(0, Capitales.Count);
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

                ModoRespuesta();
            }

            else if (capitalesPaisesToolStripMenuItem.Checked)
            {
                CapitalesUsadas.Add(Capitales[numCapital]);
                if (textBox2.Text.Equals("Correcto!"))
                {
                    respuestasCorrectas++;
                }
                else
                {
                    respuestasIncorrectas++;
                }

                porcentaje = CapitalesUsadas.Count * 100 / Capitales.Count;
                textBox7.Text = porcentaje + "%";
                if (CapitalesUsadas.Count == Capitales.Count)
                {
                    textBox2.Text = "Fin del juego!";
                    textBox1.Text = "Correctas: " + respuestasCorrectas + " Incorrectas: " + respuestasIncorrectas;
                    button1.Enabled = false;
                    return;
                }

                do
                {
                    numCapital = NumRandom.Next(Capitales.Count);
                }
                while (CapitalesUsadas.Contains(Capitales[numCapital]));

                textBox1.Text = Capitales[numCapital];

                cajas[0] = textBox3;
                cajas[1] = textBox4;
                cajas[2] = textBox5;
                cajas[3] = textBox6;

                List<int> opciones = new List<int> { numCapital };
                while (opciones.Count < 4)
                {
                    int r = NumRandom.Next(0, Paises.Count);
                    if (!opciones.Contains(r))
                        opciones.Add(r);
                }

                opciones = opciones.OrderBy(x => NumRandom.Next()).ToList();

                int i = 0;
                foreach (TextBox box in cajas)
                {
                    box.Text = Paises[opciones[i]];
                    i++;
                }

                ModoRespuesta();
            }

        }

        private void textBox7_TextChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }

        private void NombrePaises_Click(object sender, EventArgs e)
        {
            button2_Click(sender, e);
        }

        private void paisesCapitalesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            paisesCapitalesToolStripMenuItem.Checked = true;
            capitalesPaisesToolStripMenuItem.Checked = false;
            textBox2.Text = "";
            Form1_Load(sender, e);
        }

        private void capitalesPaisesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            capitalesPaisesToolStripMenuItem.Checked = true;
            paisesCapitalesToolStripMenuItem.Checked = false;
            textBox2.Text = "";
            Form1_Load(sender, e);
        }

        private void multiplesOpcionesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            multiplesOpcionesToolStripMenuItem.Checked = true;
            escribeRespuestaToolStripMenuItem.Checked = false;
            textBox2.Text = "";
            Form1_Load(sender, e);
        }

        private void escribeRespuestaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            multiplesOpcionesToolStripMenuItem.Checked = false;
            escribeRespuestaToolStripMenuItem.Checked = true;
            textBox2.Text = "";
            Form1_Load(sender, e);
        }
    }


}