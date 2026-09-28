namespace Trivial
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
            textBox1 = new TextBox();
            label1 = new Label();
            label2 = new Label();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            textBox4 = new TextBox();
            textBox5 = new TextBox();
            textBox6 = new TextBox();
            button1 = new Button();
            button2 = new Button();
            textBox7 = new TextBox();
            mnu = new MenuStrip();
            Partida = new ToolStripMenuItem();
            NombreCapitales = new ToolStripMenuItem();
            NombrePaises = new ToolStripMenuItem();
            mnu.SuspendLayout();
            SuspendLayout();
            // 
            // textBox1
            // 
            textBox1.Font = new Font("Segoe UI", 20F);
            textBox1.Location = new Point(12, 67);
            textBox1.Name = "textBox1";
            textBox1.ReadOnly = true;
            textBox1.Size = new Size(421, 43);
            textBox1.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 15F);
            label1.Location = new Point(12, 24);
            label1.Name = "label1";
            label1.Size = new Size(49, 28);
            label1.TabIndex = 1;
            label1.Text = "Pais:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 15F);
            label2.Location = new Point(12, 134);
            label2.Name = "label2";
            label2.Size = new Size(77, 28);
            label2.TabIndex = 2;
            label2.Text = "Capital:";
            // 
            // textBox2
            // 
            textBox2.BackColor = SystemColors.HotTrack;
            textBox2.Font = new Font("Segoe UI", 20F);
            textBox2.Location = new Point(239, 134);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(194, 43);
            textBox2.TabIndex = 3;
            textBox2.TextChanged += textBox2_TextChanged;
            // 
            // textBox3
            // 
            textBox3.Font = new Font("Segoe UI", 20F);
            textBox3.Location = new Point(12, 210);
            textBox3.Name = "textBox3";
            textBox3.ReadOnly = true;
            textBox3.Size = new Size(421, 43);
            textBox3.TabIndex = 4;
            textBox3.Click += textBox3_Click;
            // 
            // textBox4
            // 
            textBox4.Font = new Font("Segoe UI", 20F);
            textBox4.Location = new Point(12, 325);
            textBox4.Name = "textBox4";
            textBox4.ReadOnly = true;
            textBox4.Size = new Size(421, 43);
            textBox4.TabIndex = 5;
            textBox4.Click += textBox3_Click;
            // 
            // textBox5
            // 
            textBox5.Font = new Font("Segoe UI", 20F);
            textBox5.Location = new Point(12, 267);
            textBox5.Name = "textBox5";
            textBox5.ReadOnly = true;
            textBox5.Size = new Size(421, 43);
            textBox5.TabIndex = 6;
            textBox5.Click += textBox3_Click;
            // 
            // textBox6
            // 
            textBox6.Font = new Font("Segoe UI", 20F);
            textBox6.Location = new Point(12, 385);
            textBox6.Name = "textBox6";
            textBox6.ReadOnly = true;
            textBox6.Size = new Size(421, 43);
            textBox6.TabIndex = 7;
            textBox6.Click += textBox3_Click;
            // 
            // button1
            // 
            button1.Location = new Point(12, 448);
            button1.Name = "button1";
            button1.Size = new Size(207, 41);
            button1.TabIndex = 8;
            button1.Text = "Siguiente";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // button2
            // 
            button2.Location = new Point(12, 504);
            button2.Name = "button2";
            button2.Size = new Size(207, 41);
            button2.TabIndex = 9;
            button2.Text = "Salir";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // textBox7
            // 
            textBox7.BackColor = SystemColors.Info;
            textBox7.Font = new Font("Segoe UI", 20F);
            textBox7.Location = new Point(365, 504);
            textBox7.Name = "textBox7";
            textBox7.Size = new Size(68, 43);
            textBox7.TabIndex = 10;
            textBox7.TextChanged += textBox7_TextChanged;
            // 
            // mnu
            // 
            mnu.Items.AddRange(new ToolStripItem[] { Partida });
            mnu.Location = new Point(0, 0);
            mnu.Name = "mnu";
            mnu.Size = new Size(445, 24);
            mnu.TabIndex = 11;
            mnu.Text = "menuStrip1";
            // 
            // Partida
            // 
            Partida.DropDownItems.AddRange(new ToolStripItem[] { NombreCapitales, NombrePaises });
            Partida.Name = "Partida";
            Partida.Size = new Size(56, 20);
            Partida.Text = "Partida";
            // 
            // NombreCapitales
            // 
            NombreCapitales.Name = "NombreCapitales";
            NombreCapitales.Size = new Size(180, 22);
            NombreCapitales.Text = "Nombre Capitales";
            NombreCapitales.Click += holaToolStripMenuItem_Click;
            // 
            // NombrePaises
            // 
            NombrePaises.Name = "NombrePaises";
            NombrePaises.Size = new Size(180, 22);
            NombrePaises.Text = "Nombre Paises";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(445, 557);
            Controls.Add(textBox7);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(textBox6);
            Controls.Add(textBox5);
            Controls.Add(textBox4);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(textBox1);
            Controls.Add(mnu);
            MainMenuStrip = mnu;
            Name = "Form1";
            Text = "ASD";
            Load += Form1_Load;
            mnu.ResumeLayout(false);
            mnu.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox textBox1;
        private Label label1;
        private Label label2;
        private TextBox textBox2;
        private TextBox textBox3;
        private TextBox textBox4;
        private TextBox textBox5;
        private TextBox textBox6;
        private Button button1;
        private Button button2;
        private TextBox textBox7;
        private MenuStrip mnu;
        private ToolStripMenuItem Partida;
        private ToolStripMenuItem NombreCapitales;
        private ToolStripMenuItem NombrePaises;
    }
}
