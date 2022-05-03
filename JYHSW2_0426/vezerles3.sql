DECLARE
a NUMBER := 140;
BEGIN
IF a >= 10 AND a<= 100 THEN
  DBMS_OUTPUT.PUT_LINE('A szám bent van az intervallumban');
ELSE
  DBMS_OUTPUT.PUT_LINE('Nem esik bele a 10 és 100 intervallumba');
end if;
END;