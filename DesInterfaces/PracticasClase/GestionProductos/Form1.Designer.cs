namespace GestionProductos
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
            label1 = new Label();
            button1 = new Button();
            button2 = new Button();
            button3 = new Button();
            button4 = new Button();
            button5 = new Button();
            button6 = new Button();
            button7 = new Button();
            button8 = new Button();
            listView1 = new ListView();
            Id = new ColumnHeader();
            Nombre = new ColumnHeader();
            Stock = new ColumnHeader();
            label2 = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F, FontStyle.Bold);
            label1.Location = new Point(25, 20);
            label1.Name = "label1";
            label1.Size = new Size(358, 41);
            label1.TabIndex = 8;
            label1.Text = "Tienda de Alimentacion";
            // 
            // button1
            // 
            button1.Font = new Font("Segoe UI", 11F);
            button1.Location = new Point(30, 80);
            button1.Name = "button1";
            button1.Size = new Size(160, 45);
            button1.TabIndex = 0;
            button1.UseVisualStyleBackColor = true;
            button1.Click += button_Click;
            // 
            // button2
            // 
            button2.Font = new Font("Segoe UI", 11F);
            button2.Location = new Point(205, 80);
            button2.Name = "button2";
            button2.Size = new Size(160, 45);
            button2.TabIndex = 1;
            button2.UseVisualStyleBackColor = true;
            button2.Click += button_Click;
            // 
            // button3
            // 
            button3.Font = new Font("Segoe UI", 11F);
            button3.Location = new Point(380, 80);
            button3.Name = "button3";
            button3.Size = new Size(160, 45);
            button3.TabIndex = 2;
            button3.UseVisualStyleBackColor = true;
            button3.Click += button_Click;
            // 
            // button4
            // 
            button4.Font = new Font("Segoe UI", 11F);
            button4.Location = new Point(555, 80);
            button4.Name = "button4";
            button4.Size = new Size(160, 45);
            button4.TabIndex = 3;
            button4.UseVisualStyleBackColor = true;
            button4.Click += button_Click;
            // 
            // button5
            // 
            button5.Font = new Font("Segoe UI", 11F);
            button5.Location = new Point(30, 135);
            button5.Name = "button5";
            button5.Size = new Size(160, 45);
            button5.TabIndex = 4;
            button5.UseVisualStyleBackColor = true;
            button5.Click += button_Click;
            // 
            // button6
            // 
            button6.Font = new Font("Segoe UI", 11F);
            button6.Location = new Point(205, 135);
            button6.Name = "button6";
            button6.Size = new Size(160, 45);
            button6.TabIndex = 5;
            button6.UseVisualStyleBackColor = true;
            button6.Click += button_Click;
            // 
            // button7
            // 
            button7.Font = new Font("Segoe UI", 11F);
            button7.Location = new Point(380, 135);
            button7.Name = "button7";
            button7.Size = new Size(160, 45);
            button7.TabIndex = 6;
            button7.UseVisualStyleBackColor = true;
            button7.Click += button_Click;
            // 
            // button8
            // 
            button8.Font = new Font("Segoe UI", 11F);
            button8.Location = new Point(555, 135);
            button8.Name = "button8";
            button8.Size = new Size(160, 45);
            button8.TabIndex = 7;
            button8.UseVisualStyleBackColor = true;
            button8.Click += button_Click;
            // 
            // listView1
            // 
            listView1.Columns.AddRange(new ColumnHeader[] { Id, Nombre, Stock });
            listView1.Font = new Font("Segoe UI", 10F);
            listView1.FullRowSelect = true;
            listView1.GridLines = true;
            listView1.Location = new Point(30, 240);
            listView1.MultiSelect = false;
            listView1.Name = "listView1";
            listView1.Size = new Size(685, 300);
            listView1.TabIndex = 9;
            listView1.UseCompatibleStateImageBehavior = false;
            listView1.View = View.Details;
            // 
            // Id
            // 
            Id.Text = "Id";
            Id.Width = 80;
            // 
            // Nombre
            // 
            Nombre.Text = "Nombre";
            Nombre.Width = 420;
            // 
            // Stock
            // 
            Stock.Text = "Unidades en stock";
            Stock.TextAlign = HorizontalAlignment.Right;
            Stock.Width = 160;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 12F);
            label2.Location = new Point(30, 205);
            label2.Name = "label2";
            label2.Size = new Size(281, 28);
            label2.TabIndex = 10;
            label2.Text = "Pulsa una categoria para ver sus productos";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(745, 570);
            Controls.Add(label2);
            Controls.Add(listView1);
            Controls.Add(button8);
            Controls.Add(button7);
            Controls.Add(button6);
            Controls.Add(button5);
            Controls.Add(button4);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(label1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Gestion de Productos";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Button button1;
        private Button button2;
        private Button button3;
        private Button button4;
        private Button button5;
        private Button button6;
        private Button button7;
        private Button button8;
        private ListView listView1;
        private ColumnHeader Id;
        private ColumnHeader Nombre;
        private ColumnHeader Stock;
        private Label label2;
    }
}
