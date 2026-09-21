using System.Data;
using System;

namespace Calculadora
{
    public partial class FrmInicio : Form
    {
        public double Op1;
        public double Op2;

        public string operacion = "";

        public string memoria = "";

        public FrmInicio()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Button b = (Button)sender;
            textBox1.Text += b.Text;
        }

        private void button11_Click(object sender, EventArgs e)
        {
            Button b = (Button)sender;

            textBox1.Text += b.Text;



        }

        private void button13_Click(object sender, EventArgs e)
        {
            DataTable dt = new DataTable(); //He usado esto porque lo he visto en internet en vez de convertir lo que hay en el textbox esto ya coge todo incluido los simbolos de operaciones para poder hacer el calculo directamente.
            operacion = textBox1.Text.Replace(",", ".");
            var resultado = dt.Compute(operacion, null);

            textBox1.Text = resultado.ToString();

        }

        private void button21_Click(object sender, EventArgs e)
        {
            if (textBox1.TextLength == 1) textBox1.Text = "0";
            else textBox1.Text = textBox1.Text.Substring(0, textBox1.TextLength - 1);
        }

        private void button22_Click(object sender, EventArgs e)
        {
            textBox1.Clear();
        }

        private void button18_Click(object sender, EventArgs e)
        {
            memoria = textBox1.Text.Replace(",", ".");
            textBox1.Clear();
        }

        private void button17_Click(object sender, EventArgs e)
        {
            textBox1.Text = memoria.ToString();
        }

        private void button16_Click(object sender, EventArgs e)
        {
            memoria = "";
        }

        private void button19_Click(object sender, EventArgs e)
        {
            double MemoriaNueva = Convert.ToDouble(textBox1.Text);
            double MemoriaAntigua = Convert.ToDouble(memoria);

            memoria = (MemoriaNueva + MemoriaAntigua).ToString();

            textBox1.Clear();
        }

        private void button20_Click(object sender, EventArgs e)
        {
            double num = Convert.ToDouble(textBox1.Text);

            textBox1.Text = (1 / num).ToString();
        }
    }
}
