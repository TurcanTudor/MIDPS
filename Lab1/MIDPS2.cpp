//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop
#include <stdio.h>

#include "dos.h"
#include "MIDPS2.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm1 *Form1;

struct date d;
struct time t;

unsigned int S=0;
unsigned int M=0;
unsigned int H=0;
//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
        : TForm(Owner)
{
Edit2->Clear();
}
//---------------------------------------------------------------------------


void __fastcall TForm1::Timer1Timer(TObject *Sender)
{

char buf[20];
getdate(&d);
gettime(&t);
sprintf(buf,"%02d-%02d-%4d %02d:%02d:%02d",d.da_day,d.da_mon,d.da_year,
t.ti_hour,t.ti_min,t.ti_sec);
Edit1->Text=(AnsiString)buf;

}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button1Click(TObject *Sender)
{
   Timer2->Enabled=true;

}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button2Click(TObject *Sender)
{
      Timer2->Enabled=false;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::Timer2Timer(TObject *Sender)
{
S+=1;
if(S==60){
M+=1;
S=0;
}
if(M==60){
H+=1; M=0;
}

if(H=24){
H=0;
}
Edit2->Text=IntToStr(H)+":"+IntToStr(M)+":"+IntToStr(S);


}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button3Click(TObject *Sender)
{
  S=0;
 M=0;
 H=0;

 Edit2->Text=IntToStr(H)+":"+IntToStr(M)+":"+IntToStr(S);
}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button4Click(TObject *Sender)
{
Close();
}
//---------------------------------------------------------------------------

