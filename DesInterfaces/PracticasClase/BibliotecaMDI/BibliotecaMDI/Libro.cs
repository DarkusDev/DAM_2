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

        public String getAutor()
        {
            return autor;
        }

        public void setAutor(string autor)
        {
            this.autor = autor;
        }

        public String getEditorial()
        {
            return editorial;
        }

        public void setEditorial(string editorial)
        {
            this.editorial = editorial;
        }

        public Bitmap getImage()
        {
            return foto;
        }

        public void setImage(Bitmap foto)
        {
            this.foto = foto;
        }


    }
}
