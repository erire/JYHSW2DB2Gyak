CREATE OR REPLACE TRIGGER TB AFTER INSERT on Vasarlo for each row
Begin
  insert into naplo5 VALUES('Besz�r�s', :new.VID||'_'||:new.Nev||'_'||:new.Cim, sysdate);
End;
