CREATE OR REPLACE FUNCTION aut_arnov2(szinbe in char, ert in int) RETURN szin IS
    CURSOR cur_a IS SELECT * FROM auto where szin=szinbe
    for update of ar;
    a cur_a%rowtype;
BEGIN
    OPEN cur_a;
    LOOP
        FETCH cur_a INTO a;
        EXIT WHEN cur_a%notfound;
        update auto set ar=a.ar*(1+ert/100) where current of cur_a;
    END LOOP;
    CLOSE cur_a;
END;