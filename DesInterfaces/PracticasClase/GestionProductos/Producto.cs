using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionProductos
{
    public class Producto
    {
        private int id;
        private string nombre;
        private int stock;
        private string categoria;

        public Producto(int id, string nombre, int stock, string categoria)
        {
            this.id = id;
            this.nombre = nombre;
            this.stock = stock;
            this.categoria = categoria;
        }

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getNombre()
        {
            return nombre;
        }

        public void setNombre(string nombre)
        {
            this.nombre = nombre;
        }

        public int getStock()
        {
            return stock;
        }

        public void setStock(int stock)
        {
            this.stock = stock;
        }

        public String getCategoria()
        {
            return categoria;
        }

        public void setCategoria(string categoria)
        {
            this.categoria = categoria;
        }
    }
}
