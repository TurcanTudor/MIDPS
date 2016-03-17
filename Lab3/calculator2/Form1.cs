using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace calculator2
{
     public partial class Form1 : Form
     {
          Double resultValue = 0;
          Double valholeter;
          String operationPerformed = "";

          bool isOperationPerformed = false;
          public Form1()
          {
               InitializeComponent();
          }

          private void button_click(object sender, EventArgs e)
          {
               if ((textBox1.Text == "0")||(isOperationPerformed))
                    textBox1.Clear();

               isOperationPerformed = false;
               Button button = (Button)sender;
               if (button.Text == ",")
               {
                    if (!textBox1.Text.Contains(","))
                         textBox1.Text = textBox1.Text + button.Text;
               }
             
               else
                  
                    textBox1.Text = textBox1.Text + button.Text;
               

          }

          private void operator_click(object sender, EventArgs e)
          {
               Button button = (Button)sender;

               if (resultValue != 0)
               {
                    
                    //if (operationPerformed == string.Empty)
                    //{  //  textBox1.Text = Math.Sqrt(Double.Parse(textBox1.Text)).ToString();
                      //   resultValue = System.Double.Parse(textBox1.Text);
                       //  textBox1.Text = string.Empty;
                   // }
                   // else
                         

                    button15.PerformClick();
                    operationPerformed = button.Text;

                    
                    label_Operation.Text = resultValue + " " + operationPerformed;
                    isOperationPerformed = true;
               }
              
              // else if (button.Text == "sqrt")
               //{
               //     textBox1.Text = Math.Sqrt(Double.Parse(textBox1.Text)).ToString();
               //     resultValue = Math.Sqrt(Double.Parse(textBox1.Text));
               //}
               else
               {
                    
                    operationPerformed = button.Text;
                    resultValue = Double.Parse(textBox1.Text);
                   
                    label_Operation.Text = resultValue + " " + operationPerformed;
                    isOperationPerformed = true;
               }
               //label_Operation.Focus();
          }

          private void button17_Click(object sender, EventArgs e)
          {
               textBox1.Text = "0";
          }

          private void button16_Click(object sender, EventArgs e)
          {
               textBox1.Text = "0";
               resultValue = 0;
          }

          private void button15_Click(object sender, EventArgs e)
          {
              // valholeter = System.Double.Parse(textBox1.Text);
               switch(operationPerformed)
               {
                    case "+":
                         textBox1.Text = (resultValue + Double.Parse(textBox1.Text)).ToString();
                         break;

                    case "-":
                         textBox1.Text = (resultValue - Double.Parse(textBox1.Text)).ToString();
                         break;

                    case "*":
                         textBox1.Text = (resultValue * Double.Parse(textBox1.Text)).ToString();
                         break;

                    case "/":
                         textBox1.Text = (resultValue / Double.Parse(textBox1.Text)).ToString();
                         break;
                    case "sqrt":
                         textBox1.Text = Math.Sqrt(Double.Parse(textBox1.Text)).ToString();
                         break;
                    case "^2":
                         textBox1.Text = Math.Pow(resultValue,2).ToString();
                         break;
                    
                    default:
                         break;
               }
               resultValue = Double.Parse(textBox1.Text);
               label_Operation.Text = "";
              
          }

          private void minus(object sender, EventArgs e)
          {
               if (!textBox1.Text.Contains("-"))
                    textBox1.Text = "-" + textBox1.Text;
               else
                    textBox1.Text = textBox1.Text.Trim('-');
          }
     }
}
