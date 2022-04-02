DECLARE
a NUMBER := 10;
b NUMBER := 81;
BEGIN
if a > b then
  DBMS_OUTPUT.PUT_LINE(a);
else
  DBMS_OUTPUT.PUT_LINE(b);
end if;
END;