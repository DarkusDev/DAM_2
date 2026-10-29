namespace FormulariosHeredados
{
    partial class FormConsultaList
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
            pictureBox1 = new PictureBox();
            label1 = new Label();
            comboBox1 = new ComboBox();
            label2 = new Label();
            comboBox2 = new ComboBox();
            listView1 = new ListView();
            Nombre = new ColumnHeader();
            Apellidos = new ColumnHeader();
            Email = new ColumnHeader();
            Comentario = new ColumnHeader();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            //
            // pictureBox1
            //
            pictureBox1.BackColor = Color.White;
            pictureBox1.BorderStyle = BorderStyle.FixedSingle;
            pictureBox1.Image = Properties.Resources.bici_carretera;
            pictureBox1.Location = new Point(20, 50);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(135, 80);
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.TabIndex = 1;
            pictureBox1.TabStop = false;
            //
            // label1
            //
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 12F);
            label1.Location = new Point(170, 55);
            label1.Name = "label1";
            label1.Size = new Size(56, 21);
            label1.TabIndex = 2;
            label1.Text = "Ciudad";
            //
            // comboBox1
            //
            comboBox1.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBox1.FormattingEnabled = true;
            comboBox1.Location = new Point(170, 90);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(340, 23);
            comboBox1.TabIndex = 3;
            comboBox1.SelectedIndexChanged += comboBox1_SelectedIndexChanged;
            //
            // label2
            //
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 12F);
            label2.Location = new Point(560, 55);
            label2.Name = "label2";
            label2.Size = new Size(42, 21);
            label2.TabIndex = 4;
            label2.Text = "Vista";
            //
            // comboBox2
            //
            comboBox2.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBox2.FormattingEnabled = true;
            comboBox2.Location = new Point(560, 90);
            comboBox2.Name = "comboBox2";
            comboBox2.Size = new Size(180, 23);
            comboBox2.TabIndex = 5;
            comboBox2.SelectedIndexChanged += comboBox2_SelectedIndexChanged;
            //
            // listView1
            //
            listView1.Columns.AddRange(new ColumnHeader[] { Nombre, Apellidos, Email, Comentario });
            listView1.FullRowSelect = true;
            listView1.LargeImageList = imageList1;
            listView1.Location = new Point(50, 155);
            listView1.MultiSelect = false;
            listView1.Name = "listView1";
            listView1.Size = new Size(690, 275);
            listView1.SmallImageList = imageList1;
            listView1.TabIndex = 6;
            listView1.UseCompatibleStateImageBehavior = false;
            listView1.View = View.Details;
            //
            // Nombre
            //
            Nombre.Text = "Nombre";
            Nombre.Width = 130;
            //
            // Apellidos
            //
            Apellidos.Text = "Apellidos";
            Apellidos.Width = 150;
            //
            // Email
            //
            Email.Text = "email";
            Email.Width = 180;
            //
            // Comentario
            //
            Comentario.Text = "comentario";
            Comentario.Width = 220;
            //
            // FormConsultaList
            //
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(784, 461);
            Controls.Add(listView1);
            Controls.Add(comboBox2);
            Controls.Add(label2);
            Controls.Add(comboBox1);
            Controls.Add(label1);
            Controls.Add(pictureBox1);
            Name = "FormConsultaList";
            Text = "Consulta clientes";
            Load += FormConsultaList_Load;
            Controls.SetChildIndex(pictureBox1, 0);
            Controls.SetChildIndex(label1, 0);
            Controls.SetChildIndex(comboBox1, 0);
            Controls.SetChildIndex(label2, 0);
            Controls.SetChildIndex(comboBox2, 0);
            Controls.SetChildIndex(listView1, 0);
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private PictureBox pictureBox1;
        private Label label1;
        private ComboBox comboBox1;
        private Label label2;
        private ComboBox comboBox2;
        private ListView listView1;
        private ColumnHeader Nombre;
        private ColumnHeader Apellidos;
        private ColumnHeader Email;
        private ColumnHeader Comentario;
    }
}
