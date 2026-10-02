using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BibliotecaMDI
{
    public class Libro
    {
        private string titulo;
        private string autor;
        private string editorial;
        private bool nuevo;
        private Bitmap foto;

        public Libro(string titulo, string autor, string editorial, bool nuevo, Bitmap foto)
        {
            this.titulo = titulo;
            this.autor = autor;
            this.editorial = editorial;
            this.nuevo = nuevo;
            this.foto = foto;
        }

        public String getTitulo()
        {
            return titulo;
        }

        public void setTitulo(string titulo)
        {
            this.titulo = titulo;
        }
    }
}
