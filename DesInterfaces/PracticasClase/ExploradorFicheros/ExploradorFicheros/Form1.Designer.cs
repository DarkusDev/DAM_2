namespace ExploradorFicheros
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            treeView1 = new TreeView();
            listView1 = new ListView();
            Nombre = new ColumnHeader();
            FechaCreacion = new ColumnHeader();
            FechaModificacion = new ColumnHeader();
            FechaAcceso = new ColumnHeader();
            toolStrip1 = new ToolStrip();
            toolStripSplitButton1 = new ToolStripSplitButton();
            toolStripSplitButton2 = new ToolStripSplitButton();
            carpetaToolStripMenuItem = new ToolStripMenuItem();
            ficheroToolStripMenuItem = new ToolStripMenuItem();
            toolStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // treeView1
            // 
            treeView1.Location = new Point(31, 46);
            treeView1.Name = "treeView1";
            treeView1.Size = new Size(307, 379);
            treeView1.TabIndex = 0;
            treeView1.AfterSelect += treeView1_AfterSelect;
            // 
            // listView1
            // 
            listView1.Columns.AddRange(new ColumnHeader[] { Nombre, FechaCreacion, FechaModificacion, FechaAcceso });
            listView1.Location = new Point(370, 46);
            listView1.Name = "listView1";
            listView1.Size = new Size(536, 379);
            listView1.TabIndex = 1;
            listView1.UseCompatibleStateImageBehavior = false;
            listView1.View = View.Details;
            listView1.SelectedIndexChanged += listView1_SelectedIndexChanged;
            // 
            // Nombre
            // 
            Nombre.Text = "Nombre";
            Nombre.Width = 120;
            // 
            // FechaCreacion
            // 
            FechaCreacion.Text = "FechaCreacion";
            FechaCreacion.Width = 140;
            // 
            // FechaModificacion
            // 
            FechaModificacion.Text = "FechaModificacion";
            FechaModificacion.Width = 140;
            // 
            // FechaAcceso
            // 
            FechaAcceso.Text = "FechaAcceso";
            FechaAcceso.Width = 130;
            // 
            // toolStrip1
            // 
            toolStrip1.Items.AddRange(new ToolStripItem[] { toolStripSplitButton1, toolStripSplitButton2 });
            toolStrip1.Location = new Point(0, 0);
            toolStrip1.Name = "toolStrip1";
            toolStrip1.Size = new Size(955, 38);
            toolStrip1.TabIndex = 2;
            toolStrip1.Text = "toolStrip1";
            // 
            // toolStripSplitButton1
            // 
            toolStripSplitButton1.DropDownItems.AddRange(new ToolStripItem[] { carpetaToolStripMenuItem, ficheroToolStripMenuItem });
            toolStripSplitButton1.Image = (Image)resources.GetObject("toolStripSplitButton1.Image");
            toolStripSplitButton1.ImageTransparentColor = Color.Magenta;
            toolStripSplitButton1.Name = "toolStripSplitButton1";
            toolStripSplitButton1.Size = new Size(58, 35);
            toolStripSplitButton1.Text = "Nuevo";
            toolStripSplitButton1.TextDirection = ToolStripTextDirection.Horizontal;
            toolStripSplitButton1.TextImageRelation = TextImageRelation.ImageAboveText;
            // 
            // toolStripSplitButton2
            // 
            toolStripSplitButton2.Image = (Image)resources.GetObject("toolStripSplitButton2.Image");
            toolStripSplitButton2.ImageTransparentColor = Color.Magenta;
            toolStripSplitButton2.Name = "toolStripSplitButton2";
            toolStripSplitButton2.Size = new Size(53, 35);
            toolStripSplitButton2.Text = "Vistas";
            toolStripSplitButton2.TextImageRelation = TextImageRelation.ImageAboveText;
            // 
            // carpetaToolStripMenuItem
            // 
            carpetaToolStripMenuItem.Name = "carpetaToolStripMenuItem";
            carpetaToolStripMenuItem.Size = new Size(180, 22);
            carpetaToolStripMenuItem.Text = "Carpeta";
            // 
            // ficheroToolStripMenuItem
            // 
            ficheroToolStripMenuItem.Name = "ficheroToolStripMenuItem";
            ficheroToolStripMenuItem.Size = new Size(180, 22);
            ficheroToolStripMenuItem.Text = "Fichero";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(955, 445);
            Controls.Add(toolStrip1);
            Controls.Add(listView1);
            Controls.Add(treeView1);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            toolStrip1.ResumeLayout(false);
            toolStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TreeView treeView1;
        private ListView listView1;
        private ColumnHeader Nombre;
        private ColumnHeader FechaCreacion;
        private ColumnHeader FechaModificacion;
        private ColumnHeader FechaAcceso;
        private ToolStrip toolStrip1;
        private ToolStripSplitButton toolStripSplitButton1;
        private ToolStripSplitButton toolStripSplitButton2;
        private ToolStripMenuItem carpetaToolStripMenuItem;
        private ToolStripMenuItem ficheroToolStripMenuItem;
    }
}
