using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FormulariosHeredados
{
    public partial class FormConsultaList : FormBase
    {
        public FormConsultaList()
        {
            InitializeComponent();
        }

        private void FormConsultaList_Load(object sender, EventArgs e)
        {
            comboBox1.Items.Add("Todas");
            foreach (string ciudad in ObtenerCiudades())
            {
                comboBox1.Items.Add(ciudad);
            }

            comboBox2.Items.Add("Detalles");
            comboBox2.Items.Add("Iconos grandes");
            comboBox2.Items.Add("Iconos pequeños");
            comboBox2.Items.Add("Lista");
            comboBox2.Items.Add("Mosaico");

            comboBox2.SelectedIndex = 0;
            comboBox1.SelectedIndex = 0;
        }

        private void CargarListView()
        {
            listView1.Items.Clear();

            String ciudadSeleccionada = comboBox1.SelectedItem.ToString();

            foreach (Cliente c in listaClientes)
            {
                if (ciudadSeleccionada.Equals("Todas") || c.getCiudad().ToLower().Equals(ciudadSeleccionada.ToLower()))
                {
                    // Si es vip lleva la estrella, si no el icono de persona
                    int icono = 0;
                    if (c.getVip())
                    {
                        icono = 1;
                    }

                    ListViewItem l = listView1.Items.Add(c.getNombre(), icono);
                    l.SubItems.Add(c.getApellidos());
                    l.SubItems.Add(c.getEmail());
                    l.SubItems.Add(c.getComentario());
                }
            }
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarListView();
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
            switch (comboBox2.SelectedIndex)
            {
                case 0:
                    listView1.View = View.Details;
                    break;
                case 1:
                    listView1.View = View.LargeIcon;
                    break;
                case 2:
                    listView1.View = View.SmallIcon;
                    break;
                case 3:
                    listView1.View = View.List;
                    break;
                case 4:
                    listView1.View = View.Tile;
                    break;
            }
        }
    }
}
