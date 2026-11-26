namespace ControladorEventos
{
    public partial class Form1 : Form
    {
        List<Pelicula> peliculas = new List<Pelicula>();
        private StreamReader reader = new StreamReader(@"C:\\Users\\alumno\\Desktop\\DAM_2\\DesInterfaces\\PracticasClase\\ControladorEventos\\ControladorEventos\\Peliculas.txt");
        public Form1()
        {
            InitializeComponent();
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
            List<String> clasificaciones = new List<String>();
            
            String linea = "";

            while((linea = reader.ReadLine()) != null)
            {
                String[] campos = new string[4];
                campos = null;
                campos = linea.Trim().Split("#");

                Pelicula peli = new Pelicula(campos[0], campos[1], campos[2], campos[3]);
                peliculas.Add(peli);
                if (!clasificaciones.Contains(campos[3])){
                    clasificaciones.Add(campos[3]);
                }
                
            }
            
            int columnas = 1;
            int i = 0;

            foreach (String elemento in clasificaciones)
            {
                RadioButton rb = new RadioButton();
                rb.Text = elemento.ToString();
                rb.Name = elemento.ToString();
                rb.Font = new Font("Segoe UI", 9F);
                rb.Size = new Size(200, 60);

                int columna = i % columnas;
                int fila = i / columnas;
                rb.Location = new Point(0 + columna * (100 + 2), 0 + fila * (60 + 5));
                rb.CheckedChanged += radioButton_CheckedChanged;
                this.Controls.Add(rb);

                i++;
            }
        }

        private void radioButton_CheckedChanged(object sender, EventArgs e)
        {
            RadioButton rb = (RadioButton)sender;
            if (rb.Checked)
            {
               
                MessageBox.Show("Seleccionado: " + rb.Text);

                Titulos.Items.Clear();
                Actores.Items.Clear();
                Director.Items.Clear();

                foreach (Pelicula peli in peliculas)
                    {
                        if (peli.Clasificacion.Equals(rb.Text))
                        {
                            Titulos.Items.Add(peli.Titulo);
                            Actores.Items.Add(peli.Actores);
                            Director.Items.Add(peli.Director);
                        }
                    }
                
            }
        }
    }

   
}
