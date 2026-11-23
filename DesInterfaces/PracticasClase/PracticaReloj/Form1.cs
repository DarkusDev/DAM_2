using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace PracticaReloj
{
    public partial class Form1 : Form
    {
        private readonly Dictionary<string, string> zonas = new Dictionary<string, string>()
        {
            { "España", "Europe/Madrid" },
            { "Mexico", "America/Mexico_City" },
            { "Argentina", "America/Argentina/Buenos_Aires" },
            { "Reino Unido", "Europe/London" },
            { "Japon", "Asia/Tokyo" }
        };

        private string paisSeleccionado = "";

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            timer1.Interval = 1000;
            timer1.Start();
            timer1_Tick(sender, e);
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label3.Text = paisSeleccionado;
            textBox1.Text = DateTime.Now.ToString("HH:mm:ss");

            if (paisSeleccionado.Equals(""))
            {
                label3.Text = "";
                textBox2.Clear();
                return;
            }
            else
            {
                TimeZoneInfo tz = TimeZoneInfo.FindSystemTimeZoneById(zonas[paisSeleccionado]);
                DateTime horaPais = TimeZoneInfo.ConvertTimeFromUtc(DateTime.UtcNow, tz);
                textBox2.Text = horaPais.ToString("HH:mm:ss");
            }

        }

        private void españaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            paisSeleccionado = "España";
        }

        private void mexicoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            paisSeleccionado = "Mexico";
        }

        private void argentinaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            paisSeleccionado = "Argentina";
        }

        private void reinoUnidoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            paisSeleccionado = "Reino Unido";
        }

        private void japonToolStripMenuItem_Click(object sender, EventArgs e)
        {
            paisSeleccionado = "Japon";
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            paisSeleccionado = "";
        }
    }
}