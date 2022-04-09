DECLARE
a Number := 3;
b Number := 4;
c Number := 5;
BEGIN
IF a + b > c AND a + c > b AND b + c > a THEN
  DBMS_OUTPUT.PUT_LINE('Lehet háromszög');
ELSE
  DBMS_OUTPUT.PUT_LINE('Nem lehet háromszög');
end if;
END;