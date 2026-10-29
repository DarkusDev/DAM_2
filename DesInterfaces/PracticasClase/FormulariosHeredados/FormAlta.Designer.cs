namespace FormulariosHeredados
{
    partial class FormAlta
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
            toolStrip1 = new ToolStrip();
            btnNuevo = new ToolStripButton();
            toolStripSeparator1 = new ToolStripSeparator();
            btnGuardar = new ToolStripButton();
            toolStripSeparator2 = new ToolStripSeparator();
            btnBorrar = new ToolStripButton();
            label1 = new Label();
            listBox1 = new ListBox();
            pictureBox1 = new PictureBox();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            textBox4 = new TextBox();
            textBox5 = new TextBox();
            checkBox1 = new CheckBox();
            toolStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            //
            // toolStrip1
            //
            toolStrip1.AutoSize = false;
            toolStrip1.Dock = DockStyle.None;
            toolStrip1.GripStyle = ToolStripGripStyle.Hidden;
            toolStrip1.ImageList = imageList1;
            toolStrip1.Items.AddRange(new ToolStripItem[] { btnNuevo, toolStripSeparator1, btnGuardar, toolStripSeparator2, btnBorrar });
            toolStrip1.Location = new Point(0, 24);
            toolStrip1.Name = "toolStrip1";
            toolStrip1.Size = new Size(784, 45);
            toolStrip1.TabIndex = 1;
            toolStrip1.Text = "toolStrip1";
            //
            // btnNuevo
            //
            btnNuevo.ImageIndex = 1;
            btnNuevo.Name = "btnNuevo";
            btnNuevo.Size = new Size(46, 42);
            btnNuevo.Text = "Nuevo";
            btnNuevo.TextImageRelation = TextImageRelation.ImageAboveText;
            btnNuevo.Click += btnNuevo_Click;
            //
            // toolStripSeparator1
            //
            toolStripSeparator1.Name = "toolStripSeparator1";
            toolStripSeparator1.Size = new Size(6, 45);
            //
            // btnGuardar
            //
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(53, 42);
            btnGuardar.Text = "Guardar";
            btnGuardar.TextImageRelation = TextImageRelation.ImageAboveText;
            btnGuardar.Click += btnGuardar_Click;
            //
            // toolStripSeparator2
            //
            toolStripSeparator2.Name = "toolStripSeparator2";
            toolStripSeparator2.Size = new Size(6, 45);
            //
            // btnBorrar
            //
            btnBorrar.Name = "btnBorrar";
            btnBorrar.Size = new Size(43, 42);
            btnBorrar.Text = "Borrar";
            btnBorrar.TextImageRelation = TextImageRelation.ImageAboveText;
            btnBorrar.Click += btnBorrar_Click;
            //
            // label1
            //
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            label1.Location = new Point(20, 80);
            label1.Name = "label1";
            label1.Size = new Size(52, 15);
            label1.TabIndex = 2;
            label1.Text = "Clientes";
            //
            // listBox1
            //
            listBox1.FormattingEnabled = true;
            listBox1.ItemHeight = 15;
            listBox1.Location = new Point(20, 100);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(260, 334);
            listBox1.TabIndex = 3;
            listBox1.SelectedIndexChanged += listBox1_SelectedIndexChanged;
            //
            // pictureBox1
            //
            pictureBox1.BorderStyle = BorderStyle.FixedSingle;
            pictureBox1.Image = Properties.Resources.ciclista;
            pictureBox1.Location = new Point(538, 70);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(105, 135);
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.TabIndex = 4;
            pictureBox1.TabStop = false;
            //
            // label2
            //
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            label2.Location = new Point(320, 218);
            label2.Name = "label2";
            label2.Size = new Size(54, 15);
            label2.TabIndex = 5;
            label2.Text = "Nombre";
            //
            // label3
            //
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            label3.Location = new Point(320, 253);
            label3.Name = "label3";
            label3.Size = new Size(62, 15);
            label3.TabIndex = 6;
            label3.Text = "Apellidos";
            //
            // label4
            //
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            label4.Location = new Point(320, 288);
            label4.Name = "label4";
            label4.Size = new Size(45, 15);
            label4.TabIndex = 7;
            label4.Text = "Ciudad";
            //
            // label5
            //
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            label5.Location = new Point(320, 323);
            label5.Name = "label5";
            label5.Size = new Size(44, 15);
            label5.TabIndex = 8;
            label5.Text = "e-mail";
            //
            // label6
            //
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            label6.Location = new Point(320, 358);
            label6.Name = "label6";
            label6.Size = new Size(72, 15);
            label6.TabIndex = 9;
            label6.Text = "Comentario";
            //
            // label7
            //
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            label7.Location = new Point(320, 418);
            label7.Name = "label7";
            label7.Size = new Size(24, 15);
            label7.TabIndex = 10;
            label7.Text = "Vip";
            //
            // textBox1
            //
            textBox1.Location = new Point(440, 215);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(300, 23);
            textBox1.TabIndex = 11;
            //
            // textBox2
            //
            textBox2.Location = new Point(440, 250);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(300, 23);
            textBox2.TabIndex = 12;
            //
            // textBox3
            //
            textBox3.Location = new Point(440, 285);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(300, 23);
            textBox3.TabIndex = 13;
            //
            // textBox4
            //
            textBox4.Location = new Point(440, 320);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(300, 23);
            textBox4.TabIndex = 14;
            //
            // textBox5
            //
            textBox5.Location = new Point(440, 355);
            textBox5.Multiline = true;
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(300, 50);
            textBox5.TabIndex = 15;
            //
            // checkBox1
            //
            checkBox1.AutoSize = true;
            checkBox1.Location = new Point(440, 419);
            checkBox1.Name = "checkBox1";
            checkBox1.Size = new Size(15, 14);
            checkBox1.TabIndex = 16;
            checkBox1.UseVisualStyleBackColor = true;
            //
            // FormAlta
            //
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(784, 461);
            Controls.Add(checkBox1);
            Controls.Add(textBox5);
            Controls.Add(textBox4);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(textBox1);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(pictureBox1);
            Controls.Add(listBox1);
            Controls.Add(label1);
            Controls.Add(toolStrip1);
            Name = "FormAlta";
            Text = "Clientes";
            Load += FormAlta_Load;
            Controls.SetChildIndex(toolStrip1, 0);
            Controls.SetChildIndex(label1, 0);
            Controls.SetChildIndex(listBox1, 0);
            Controls.SetChildIndex(pictureBox1, 0);
            Controls.SetChildIndex(label2, 0);
            Controls.SetChildIndex(label3, 0);
            Controls.SetChildIndex(label4, 0);
            Controls.SetChildIndex(label5, 0);
            Controls.SetChildIndex(label6, 0);
            Controls.SetChildIndex(label7, 0);
            Controls.SetChildIndex(textBox1, 0);
            Controls.SetChildIndex(textBox2, 0);
            Controls.SetChildIndex(textBox3, 0);
            Controls.SetChildIndex(textBox4, 0);
            Controls.SetChildIndex(textBox5, 0);
            Controls.SetChildIndex(checkBox1, 0);
            toolStrip1.ResumeLayout(false);
            toolStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ToolStrip toolStrip1;
        private ToolStripButton btnNuevo;
        private ToolStripSeparator toolStripSeparator1;
        private ToolStripButton btnGuardar;
        private ToolStripSeparator toolStripSeparator2;
        private ToolStripButton btnBorrar;
        private Label label1;
        private ListBox listBox1;
        private PictureBox pictureBox1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Label label7;
        private TextBox textBox1;
        private TextBox textBox2;
        private TextBox textBox3;
        private TextBox textBox4;
        private TextBox textBox5;
        private CheckBox checkBox1;
    }
}
