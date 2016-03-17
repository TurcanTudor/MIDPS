//---------------------------------------------------------------------------

#include <vcl.h>
#include <stdio.h>
#pragma hdrstop

#include "Unit1.h"
#include "dos.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm1 *Form1;
struct date data;
struct time timp;
int i, x;
//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
        : TForm(Owner)
{
}
//---------------------------------------------------------------------------

void __fastcall TForm1::Button3Click(TObject *Sender)
{
        exit(1);
}
//---------------------------------------------------------------------------

void __fastcall TForm1::FormCreate(TObject *Sender)
{
        Edit1->Clear();
        Timer1->Enabled=true;
        Timer2->Enabled=false;
        Timer1->Interval=1000;
        Timer2->Interval=500;
        Button2->Enabled=false;

}
//---------------------------------------------------------------------------
void __fastcall TForm1::Timer1Timer(TObject *Sender)
{
        char buffer[20];
        getdate(&data);
        gettime(&timp);
        sprintf(buffer,"%02d/%02d/%4d %2d:%02d:%02d", data.da_day, data.da_mon,
        data.da_year, timp.ti_hour, timp.ti_min, timp. ti_sec);


        Edit1->Text=(AnsiString)buffer;                
}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button1Click(TObject *Sender)
{
        Button1->Enabled=false;
        Button2->Enabled=true;
        Timer2->Enabled=true;

        PaintBox1->Canvas->Pen->Color=clRed;
	i = 0;
	x = 0;

        
	PaintBox1->Canvas->MoveTo(0,100);

	PaintBox1->Canvas->FloodFill(50,50,clBtnFace,fsBorder);
	PaintBox1->Repaint();
}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button2Click(TObject *Sender)
{
        Button2->Enabled=false;
        Button1->Enabled=true;
        Timer2->Enabled=false;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::Timer2Timer(TObject *Sender)
{
        x = rand()%100;
        i = i++;
        PaintBox1->Canvas->LineTo(i,x);

        Panel2->Height=x;


        if(i==100)
        {
	        Button1->Enabled=true;
	        Button2->Enabled=false;
	        Timer2->Enabled=false;
	        Timer2->Tag = 0;

	        i = 0;
	        x = 0;
        }
}
//---------------------------------------------------------------------------
