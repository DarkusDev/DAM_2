namespace FormulariosHeredados
{
    partial class FormBase
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormBase));
            MenuBase = new MenuStrip();
            mnuAlta = new ToolStripMenuItem();
            mnuConsultaList = new ToolStripMenuItem();
            mnuConsultaTree = new ToolStripMenuItem();
            mnuSalir = new ToolStripMenuItem();
            imageList1 = new ImageList(components);
            MenuBase.SuspendLayout();
            SuspendLayout();
            //
            // MenuBase
            //
            MenuBase.Items.AddRange(new ToolStripItem[] { mnuAlta, mnuConsultaList, mnuConsultaTree, mnuSalir });
            MenuBase.Location = new Point(0, 0);
            MenuBase.Name = "MenuBase";
            MenuBase.Size = new Size(784, 24);
            MenuBase.TabIndex = 0;
            MenuBase.Text = "menuStrip1";
            //
            // mnuAlta
            //
            mnuAlta.Name = "mnuAlta";
            mnuAlta.Size = new Size(40, 20);
            mnuAlta.Text = "Alta";
            mnuAlta.Click += mnuAlta_Click;
            //
            // mnuConsultaList
            //
            mnuConsultaList.Name = "mnuConsultaList";
            mnuConsultaList.Size = new Size(90, 20);
            mnuConsultaList.Text = "Consulta list";
            mnuConsultaList.Click += mnuConsultaList_Click;
            //
            // mnuConsultaTree
            //
            mnuConsultaTree.Name = "mnuConsultaTree";
            mnuConsultaTree.Size = new Size(92, 20);
            mnuConsultaTree.Text = "Consulta tree";
            mnuConsultaTree.Click += mnuConsultaTree_Click;
            //
            // mnuSalir
            //
            mnuSalir.Name = "mnuSalir";
            mnuSalir.Size = new Size(41, 20);
            mnuSalir.Text = "Salir";
            mnuSalir.Click += mnuSalir_Click;
            //
            // imageList1
            //
            imageList1.ColorDepth = ColorDepth.Depth32Bit;
            imageList1.ImageStream = (ImageListStreamer)resources.GetObject("imageList1.ImageStream");
            imageList1.TransparentColor = Color.Transparent;
            imageList1.Images.SetKeyName(0, "User-Profile-256.png");
            imageList1.Images.SetKeyName(1, "Shape-Star2-256.png");
            imageList1.Images.SetKeyName(2, "House-256.png");
            //
            // FormBase
            //
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(784, 461);
            Controls.Add(MenuBase);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MainMenuStrip = MenuBase;
            MaximizeBox = false;
            Name = "FormBase";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Clientes";
            FormClosing += FormBase_FormClosing;
            MenuBase.ResumeLayout(false);
            MenuBase.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        protected MenuStrip MenuBase;
        protected ToolStripMenuItem mnuAlta;
        protected ToolStripMenuItem mnuConsultaList;
        protected ToolStripMenuItem mnuConsultaTree;
        protected ToolStripMenuItem mnuSalir;
        protected ImageList imageList1;
    }
}
