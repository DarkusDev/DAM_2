using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ControladorEventos
{
    
    internal class Pelicula
    {
        private String titulo;
        private String actores;
        private String director;
        private String clasificacion;

        public Pelicula()
        {
            this.Titulo = "";
            this.Actores = "";
            this.Director = "";
            this.Clasificacion = "";
        }

        public Pelicula(String titulo, String actores, String director, String clasificacion)
        {
            this.Titulo = titulo;
            this.Actores = actores;
            this.Director = director;
            this.Clasificacion = clasificacion;
        }

        public string Titulo { get => titulo; set => titulo = value; }
        public string Actores { get => actores; set => actores = value; }
        public string Director { get => director; set => director = value; }
        public string Clasificacion { get => clasificacion; set => clasificacion = value; }
    }
}
