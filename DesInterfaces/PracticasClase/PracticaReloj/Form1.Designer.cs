namespace PracticaReloj
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
            menuStrip1 = new MenuStrip();
            paisToolStripMenuItem = new ToolStripMenuItem();
            añadirToolStripMenuItem = new ToolStripMenuItem();
            españaToolStripMenuItem = new ToolStripMenuItem();
            mexicoToolStripMenuItem = new ToolStripMenuItem();
            argentinaToolStripMenuItem = new ToolStripMenuItem();
            reinoUnidoToolStripMenuItem = new ToolStripMenuItem();
            japonToolStripMenuItem = new ToolStripMenuItem();
            borrarToolStripMenuItem = new ToolStripMenuItem();
            label1 = new Label();
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            label2 = new Label();
            label3 = new Label();
            timer1 = new System.Windows.Forms.Timer(components);
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.Items.AddRange(new ToolStripItem[] { paisToolStripMenuItem });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(432, 24);
            menuStrip1.TabIndex = 0;
            menuStrip1.Text = "menuStrip1";
            // 
            // paisToolStripMenuItem
            // 
            paisToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { añadirToolStripMenuItem, borrarToolStripMenuItem });
            paisToolStripMenuItem.Name = "paisToolStripMenuItem";
            paisToolStripMenuItem.Size = new Size(40, 20);
            paisToolStripMenuItem.Text = "Pais";
            // 
            // añadirToolStripMenuItem
            // 
            añadirToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { españaToolStripMenuItem, mexicoToolStripMenuItem, argentinaToolStripMenuItem, reinoUnidoToolStripMenuItem, japonToolStripMenuItem });
            añadirToolStripMenuItem.Name = "añadirToolStripMenuItem";
            añadirToolStripMenuItem.Size = new Size(180, 22);
            añadirToolStripMenuItem.Text = "Añadir";
            // 
            // españaToolStripMenuItem
            // 
            españaToolStripMenuItem.Name = "españaToolStripMenuItem";
            españaToolStripMenuItem.Size = new Size(180, 22);
            españaToolStripMenuItem.Text = "España";
            españaToolStripMenuItem.Click += españaToolStripMenuItem_Click;
            // 
            // mexicoToolStripMenuItem
            // 
            mexicoToolStripMenuItem.Name = "mexicoToolStripMenuItem";
            mexicoToolStripMenuItem.Size = new Size(180, 22);
            mexicoToolStripMenuItem.Text = "Mexico";
            mexicoToolStripMenuItem.Click += mexicoToolStripMenuItem_Click;
            // 
            // argentinaToolStripMenuItem
            // 
            argentinaToolStripMenuItem.Name = "argentinaToolStripMenuItem";
            argentinaToolStripMenuItem.Size = new Size(180, 22);
            argentinaToolStripMenuItem.Text = "Argentina";
            argentinaToolStripMenuItem.Click += argentinaToolStripMenuItem_Click;
            // 
            // reinoUnidoToolStripMenuItem
            // 
            reinoUnidoToolStripMenuItem.Name = "reinoUnidoToolStripMenuItem";
            reinoUnidoToolStripMenuItem.Size = new Size(180, 22);
            reinoUnidoToolStripMenuItem.Text = "Reino Unido";
            reinoUnidoToolStripMenuItem.Click += reinoUnidoToolStripMenuItem_Click;
            // 
            // japonToolStripMenuItem
            // 
            japonToolStripMenuItem.Name = "japonToolStripMenuItem";
            japonToolStripMenuItem.Size = new Size(180, 22);
            japonToolStripMenuItem.Text = "Japon";
            japonToolStripMenuItem.Click += japonToolStripMenuItem_Click;
            // 
            // borrarToolStripMenuItem
            // 
            borrarToolStripMenuItem.Name = "borrarToolStripMenuItem";
            borrarToolStripMenuItem.Size = new Size(180, 22);
            borrarToolStripMenuItem.Text = "Borrar";
            borrarToolStripMenuItem.Click += borrarToolStripMenuItem_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(23, 44);
            label1.Name = "label1";
            label1.Size = new Size(36, 15);
            label1.TabIndex = 1;
            label1.Text = "Hora:";
            // 
            // textBox1
            // 
            textBox1.Location = new Point(23, 62);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(178, 23);
            textBox1.TabIndex = 2;
            // 
            // textBox2
            // 
            textBox2.Location = new Point(23, 140);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(178, 23);
            textBox2.TabIndex = 4;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(23, 122);
            label2.Name = "label2";
            label2.Size = new Size(49, 15);
            label2.TabIndex = 3;
            label2.Text = "Hora en";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(68, 122);
            label3.Name = "label3";
            label3.Size = new Size(36, 15);
            label3.TabIndex = 5;
            label3.Text = "[Pais]";
            // 
            // timer1
            // 
            timer1.Tick += timer1_Tick;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(432, 245);
            Controls.Add(label3);
            Controls.Add(textBox2);
            Controls.Add(label2);
            Controls.Add(textBox1);
            Controls.Add(label1);
            Controls.Add(menuStrip1);
            MainMenuStrip = menuStrip1;
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuStrip1;
        private ToolStripMenuItem paisToolStripMenuItem;
        private ToolStripMenuItem añadirToolStripMenuItem;
        private ToolStripMenuItem borrarToolStripMenuItem;
        private Label label1;
        private TextBox textBox1;
        private TextBox textBox2;
        private Label label2;
        private Label label3;
        private ToolStripMenuItem españaToolStripMenuItem;
        private ToolStripMenuItem mexicoToolStripMenuItem;
        private ToolStripMenuItem argentinaToolStripMenuItem;
        private ToolStripMenuItem reinoUnidoToolStripMenuItem;
        private ToolStripMenuItem japonToolStripMenuItem;
        private System.Windows.Forms.Timer timer1;
    }
}
