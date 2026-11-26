namespace ControladorEventos
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            Titulos = new ListBox();
            Actores = new ListBox();
            Director = new ListBox();
            SuspendLayout();
            // 
            // Titulos
            // 
            Titulos.FormattingEnabled = true;
            Titulos.ItemHeight = 15;
            Titulos.Location = new Point(475, 59);
            Titulos.Name = "Titulos";
            Titulos.Size = new Size(375, 124);
            Titulos.TabIndex = 0;
            // 
            // Actores
            // 
            Actores.FormattingEnabled = true;
            Actores.ItemHeight = 15;
            Actores.Location = new Point(475, 201);
            Actores.Name = "Actores";
            Actores.Size = new Size(375, 124);
            Actores.TabIndex = 1;
            // 
            // Director
            // 
            Director.FormattingEnabled = true;
            Director.ItemHeight = 15;
            Director.Location = new Point(475, 344);
            Director.Name = "Director";
            Director.Size = new Size(375, 124);
            Director.TabIndex = 2;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(913, 525);
            Controls.Add(Director);
            Controls.Add(Actores);
            Controls.Add(Titulos);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
        }

        #endregion
        private ListBox Actores;
        private ListBox Director;
        public ListBox Titulos;
    }
}
