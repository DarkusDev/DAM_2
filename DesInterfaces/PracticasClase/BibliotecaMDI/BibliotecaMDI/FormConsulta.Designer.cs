namespace BibliotecaMDI
{
    partial class FormConsulta
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
            radioButton1 = new RadioButton();
            radioButton2 = new RadioButton();
            groupBox1 = new GroupBox();
            listBoxTitulos = new ListBox();
            listBoxAutorEditorial = new ListBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            pictureBox1 = new PictureBox();
            groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // radioButton1
            // 
            radioButton1.AutoSize = true;
            radioButton1.Font = new Font("Segoe UI", 13F);
            radioButton1.Location = new Point(20, 43);
            radioButton1.Name = "radioButton1";
            radioButton1.Size = new Size(75, 29);
            radioButton1.TabIndex = 1;
            radioButton1.TabStop = true;
            radioButton1.Text = "Autor";
            radioButton1.UseVisualStyleBackColor = true;
            radioButton1.Click += radioButton1_Click;
            // 
            // radioButton2
            // 
            radioButton2.AutoSize = true;
            radioButton2.Font = new Font("Segoe UI", 13F);
            radioButton2.Location = new Point(20, 78);
            radioButton2.Name = "radioButton2";
            radioButton2.Size = new Size(94, 29);
            radioButton2.TabIndex = 2;
            radioButton2.TabStop = true;
            radioButton2.Text = "Editorial";
            radioButton2.UseVisualStyleBackColor = true;
            radioButton2.Click += radioButton2_Click;
            // 
            // groupBox1
            // 
            groupBox1.Controls.Add(radioButton2);
            groupBox1.Controls.Add(radioButton1);
            groupBox1.Font = new Font("Segoe UI", 15F);
            groupBox1.Location = new Point(35, 24);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(462, 122);
            groupBox1.TabIndex = 3;
            groupBox1.TabStop = false;
            groupBox1.Text = "Tipo Consultta";
            // 
            // listBoxTitulos
            // 
            listBoxTitulos.FormattingEnabled = true;
            listBoxTitulos.ItemHeight = 15;
            listBoxTitulos.Location = new Point(37, 189);
            listBoxTitulos.Name = "listBoxTitulos";
            listBoxTitulos.Size = new Size(216, 229);
            listBoxTitulos.TabIndex = 4;
            listBoxTitulos.Click += listBoxTitulos_Click;
            // 
            // listBoxAutorEditorial
            // 
            listBoxAutorEditorial.FormattingEnabled = true;
            listBoxAutorEditorial.ItemHeight = 15;
            listBoxAutorEditorial.Location = new Point(283, 189);
            listBoxAutorEditorial.Name = "listBoxAutorEditorial";
            listBoxAutorEditorial.Size = new Size(216, 229);
            listBoxAutorEditorial.TabIndex = 5;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 15F);
            label1.Location = new Point(37, 158);
            label1.Name = "label1";
            label1.Size = new Size(62, 28);
            label1.TabIndex = 6;
            label1.Text = "Titulo";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 15F);
            label2.Location = new Point(283, 158);
            label2.Name = "label2";
            label2.Size = new Size(153, 28);
            label2.TabIndex = 7;
            label2.Text = "Autor / Editorial";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 15F);
            label3.Location = new Point(588, 158);
            label3.Name = "label3";
            label3.Size = new Size(126, 28);
            label3.TabIndex = 8;
            label3.Text = "Foto Portada";
            // 
            // pictureBox1
            // 
            pictureBox1.Location = new Point(554, 198);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(197, 211);
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox1.TabIndex = 9;
            pictureBox1.TabStop = false;
            // 
            // FormConsulta
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(pictureBox1);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(listBoxAutorEditorial);
            Controls.Add(listBoxTitulos);
            Controls.Add(groupBox1);
            Name = "FormConsulta";
            Text = "FormConsulta";
            Load += FormConsulta_Load;
            groupBox1.ResumeLayout(false);
            groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private RadioButton radioButton1;
        private RadioButton radioButton2;
        private GroupBox groupBox1;
        private ListBox listBoxTitulos;
        private ListBox listBoxAutorEditorial;
        private Label label1;
        private Label label2;
        private Label label3;
        private PictureBox pictureBox1;
    }
}