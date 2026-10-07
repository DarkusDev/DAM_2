namespace BibliotecaMDI
{
    partial class FormPrincipal
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
            MenuPrincipal = new MenuStrip();
            mnuFichero = new ToolStripMenuItem();
            mnuAlta = new ToolStripMenuItem();
            mnuConsulta = new ToolStripMenuItem();
            saliToolStripMenuItem = new ToolStripSeparator();
            mnuSalir = new ToolStripMenuItem();
            fileSystemWatcher1 = new FileSystemWatcher();
            label1 = new Label();
            MenuPrincipal.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)fileSystemWatcher1).BeginInit();
            SuspendLayout();
            // 
            // MenuPrincipal
            // 
            MenuPrincipal.Items.AddRange(new ToolStripItem[] { mnuFichero });
            MenuPrincipal.Location = new Point(0, 0);
            MenuPrincipal.Name = "MenuPrincipal";
            MenuPrincipal.Size = new Size(800, 24);
            MenuPrincipal.TabIndex = 1;
            MenuPrincipal.Text = "menuStrip1";
            // 
            // mnuFichero
            // 
            mnuFichero.DropDownItems.AddRange(new ToolStripItem[] { mnuAlta, mnuConsulta, saliToolStripMenuItem, mnuSalir });
            mnuFichero.Name = "mnuFichero";
            mnuFichero.Size = new Size(58, 20);
            mnuFichero.Text = "Fichero";
            // 
            // mnuAlta
            // 
            mnuAlta.Name = "mnuAlta";
            mnuAlta.ShortcutKeys = Keys.Control | Keys.A;
            mnuAlta.Size = new Size(163, 22);
            mnuAlta.Text = "Alta";
            mnuAlta.Click += mnuAlta_Click;
            // 
            // mnuConsulta
            // 
            mnuConsulta.Name = "mnuConsulta";
            mnuConsulta.ShortcutKeys = Keys.Control | Keys.C;
            mnuConsulta.Size = new Size(163, 22);
            mnuConsulta.Text = "Consulta";
            mnuConsulta.Click += mnuConsulta_Click;
            // 
            // saliToolStripMenuItem
            // 
            saliToolStripMenuItem.Name = "saliToolStripMenuItem";
            saliToolStripMenuItem.Size = new Size(160, 6);
            // 
            // mnuSalir
            // 
            mnuSalir.Name = "mnuSalir";
            mnuSalir.ShortcutKeys = Keys.Control | Keys.S;
            mnuSalir.Size = new Size(163, 22);
            mnuSalir.Text = "Salir";
            mnuSalir.Click += mnuSalir_Click;
            // 
            // fileSystemWatcher1
            // 
            fileSystemWatcher1.EnableRaisingEvents = true;
            fileSystemWatcher1.SynchronizingObject = this;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 20F);
            label1.Location = new Point(520, 391);
            label1.Name = "label1";
            label1.Size = new Size(0, 37);
            label1.TabIndex = 3;
            // 
            // FormPrincipal
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(label1);
            Controls.Add(MenuPrincipal);
            IsMdiContainer = true;
            MainMenuStrip = MenuPrincipal;
            Name = "FormPrincipal";
            Text = "Gestion Bilioteca";
            FormClosing += FormPrincipal_FormClosing;
            Load += GestionBiblioteca_Load;
            MdiChildActivate += FormPrincipal_MdiChildActivate;
            MenuPrincipal.ResumeLayout(false);
            MenuPrincipal.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)fileSystemWatcher1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip MenuPrincipal;
        private ToolStripMenuItem mnuFichero;
        private ToolStripMenuItem mnuAlta;
        private ToolStripMenuItem mnuConsulta;
        private ToolStripSeparator saliToolStripMenuItem;
        private ToolStripMenuItem mnuSalir;
        private FileSystemWatcher fileSystemWatcher1;
        private Label label1;
    }
}
