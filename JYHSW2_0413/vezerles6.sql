DECLARE
a Number := 3;
b Number := 4;
c Number := 5;
s NUMBER := (a + b + c)/2;
T NUMBER :=s*(s-a)*(s-b)*(s-c);
BEGIN
DBMS_OUTPUT.PUT_LINE('Az s az egyenlö: ' || s);
DBMS_OUTPUT.PUT_LINE('A héron képlet alapján ' ||SQRT(T));
END;