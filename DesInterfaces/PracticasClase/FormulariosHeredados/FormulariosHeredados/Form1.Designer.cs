namespace FormulariosHeredados
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
            components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            listView1 = new ListView();
            Nombre = new ColumnHeader();
            Apellidos = new ColumnHeader();
            Email = new ColumnHeader();
            Comentario = new ColumnHeader();
            imageList1 = new ImageList(components);
            button1 = new Button();
            treeView1 = new TreeView();
            SuspendLayout();
            // 
            // listView1
            // 
            listView1.Activation = ItemActivation.OneClick;
            listView1.Columns.AddRange(new ColumnHeader[] { Nombre, Apellidos, Email, Comentario });
            listView1.LargeImageList = imageList1;
            listView1.Location = new Point(12, 90);
            listView1.Name = "listView1";
            listView1.Size = new Size(334, 228);
            listView1.SmallImageList = imageList1;
            listView1.TabIndex = 0;
            listView1.UseCompatibleStateImageBehavior = false;
            listView1.View = View.Details;
            // 
            // Nombre
            // 
            Nombre.Text = "Nombre";
            Nombre.Width = 120;
            // 
            // Apellidos
            // 
            Apellidos.Text = "Apellidos";
            Apellidos.Width = 120;
            // 
            // Email
            // 
            Email.Text = "Email";
            Email.Width = 120;
            // 
            // Comentario
            // 
            Comentario.Text = "Comentario";
            Comentario.Width = 120;
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
            // button1
            // 
            button1.Location = new Point(136, 383);
            button1.Name = "button1";
            button1.Size = new Size(75, 23);
            button1.TabIndex = 1;
            button1.Text = "button1";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // treeView1
            // 
            treeView1.ImageIndex = 0;
            treeView1.ImageList = imageList1;
            treeView1.Location = new Point(398, 90);
            treeView1.Name = "treeView1";
            treeView1.SelectedImageIndex = 0;
            treeView1.Size = new Size(349, 228);
            treeView1.TabIndex = 2;
            treeView1.AfterSelect += treeView1_AfterSelect;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(treeView1);
            Controls.Add(button1);
            Controls.Add(listView1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
        }

        #endregion

        private ListView listView1;
        private ImageList imageList1;
        private Button button1;
        private ColumnHeader Nombre;
        private ColumnHeader Apellidos;
        private ColumnHeader Email;
        private ColumnHeader Comentario;
        private TreeView treeView1;
    }
}
