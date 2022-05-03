DECLARE
i NUMBER(2) := 1;
n NUMBER(2) := 10;
BEGIN
for i in 1..n loop
 DBMS_OUTPUT.PUT_LINE(i);
end loop;
END;