CREATE OR REPLACE TRIGGER MeresiAdatMod BEFORE UPDATE on meresiadatok for each row
Begin
  insert into naplo VALUES('M�dos�t�s',
  :new.meresiadatkulcs||'_'||:old.meresiadatkulcs
  ||','||:new.homerseklet||'_'||:old.homerseklet
  ||','||:new.meres_ideje||'_'||:old.meres_ideje
  ||','||:new.paratartalom||'_'||:old.paratartalom
  ||','||:new.szallopor||'_'||:old.szallopor
  ||','||:new.kendioxid||'_'||:old.kendioxid
  ||','||:new.szenmonoxid||'_'||:old.szenmonoxid
  ||','||:new.nitrog�ndioxid||'_'||:old.nitrog�ndioxid
  ||','||:new.eszkozkulcs||'_'||:old.eszkozkulcs, CURRENT_TIMESTAMP);
End;