CREATE OR REPLACE TRIGGER TM AFTER UPDATE on Vasarlo for each row
Begin
  insert into naplo5 VALUES('Módosítás', 
  :new.VID||'_'||:old.VID
  ||','||:new.Cim||'_'||:old.Cim||
  :new.Nev||'_'||:old.Nev
  ||','||:new.Fizmod||'_'||:old.Fizmod, sysdate);
End;