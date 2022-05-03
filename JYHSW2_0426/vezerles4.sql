DECLARE
beosztas_rovid varchar(30);
beosztas_teljes varchar(30);
BEGIN
beosztas_rovid := 'root';
case beosztas_rovid
WHEN 'root' THEN
  beosztas_teljes := 'Rendszergazda(UNIX/LINUX)';
WHEN 'akarmi' THEN
  beosztas_teljes := 'felhasznalo(UNIX/LINUX)';
END CASE;
DBMS_OUTPUT.PUT_LINE( beosztas_teljes );
END;