object Form1: TForm1
  Left = 330
  Top = 166
  Width = 928
  Height = 471
  Caption = 'MIDPS'
  Color = clActiveBorder
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel
    Left = 96
    Top = 16
    Width = 366
    Height = 25
    Caption = 'Realizarea unui cronometru in C++ Builder'
    Color = clBtnShadow
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clRed
    Font.Height = -20
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentColor = False
    ParentFont = False
  end
  object Label2: TLabel
    Left = 328
    Top = 184
    Width = 316
    Height = 29
    Caption = 'C++ Builder  CRONOMETRU'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clRed
    Font.Height = -24
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Button1: TButton
    Left = 88
    Top = 224
    Width = 105
    Height = 41
    Caption = 'Start'
    TabOrder = 0
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 88
    Top = 288
    Width = 105
    Height = 41
    Caption = 'Stop'
    TabOrder = 1
    OnClick = Button2Click
  end
  object Button3: TButton
    Left = 88
    Top = 352
    Width = 105
    Height = 41
    Caption = 'Zero'
    TabOrder = 2
    OnClick = Button3Click
  end
  object Edit1: TEdit
    Left = 224
    Top = 88
    Width = 273
    Height = 21
    TabOrder = 3
    Text = 'Edit1'
  end
  object Edit2: TEdit
    Left = 328
    Top = 288
    Width = 289
    Height = 21
    TabOrder = 4
    Text = 'Edit2'
  end
  object Button4: TButton
    Left = 592
    Top = 360
    Width = 113
    Height = 41
    Caption = 'Exit'
    TabOrder = 5
    OnClick = Button4Click
  end
  object Timer1: TTimer
    OnTimer = Timer1Timer
    Left = 96
    Top = 96
  end
  object Timer2: TTimer
    Enabled = False
    Interval = 100
    OnTimer = Timer2Timer
    Left = 96
    Top = 152
  end
end
