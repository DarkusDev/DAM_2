using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormulariosHeredados
{
    public class Cliente
    {
        private string nombre;
        private string apellidos;
        private string ciudad;
        private string email;
        private string comentario;
        private bool vip;

        public Cliente(string nombre, string apellidos, string ciudad, string email, string comentario, bool vip)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.ciudad = ciudad;
            this.email = email;
            this.comentario = comentario;
            this.vip = vip;
        }

        public String getNombre()
        {
            return nombre;
        }

        public void setNombre(string nombre)
        {
            this.nombre = nombre;
        }

        public String getApellidos()
        {
            return apellidos;
        }

        public void setApellidos(string apellidos)
        {
            this.apellidos = apellidos;
        }

        public String getCiudad()
        {
            return ciudad;
        }

        public void setCiudad(string ciudad)
        {
            this.ciudad = ciudad;
        }

        public String getEmail()
        {
            return email;
        }

        public void setEmail(string email)
        {
            this.email = email;
        }

        public String getComentario()
        {
            return comentario;
        }

        public void setComentario(string comentario)
        {
            this.comentario = comentario;
        }

        public bool getVip()
        {
            return vip;
        }

        public void setVip(bool vip)
        {
            this.vip = vip;
        }

        public String getNombreCompleto()
        {
            return nombre + " " + apellidos;
        }
    }
}
