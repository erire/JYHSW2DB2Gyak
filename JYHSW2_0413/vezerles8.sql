DECLARE
a Number;
b Number;
c Number;
n NUMBER;
BEGIN
n:=20;
a:=0;
b:=1;
DBMS_OUTPUT.PUT_LINE(0);
DBMS_OUTPUT.PUT_LINE(1);
for i in 2..n loop
 c:=a+b;
 DBMS_OUTPUT.PUT_LINE(c);
 a:=b;
 b:=c;
end loop;
END;