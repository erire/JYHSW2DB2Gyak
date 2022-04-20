CREATE OR REPLACE PROCEDURE tlpfor AS
    CURSOR cur IS SELECT * FROM Kategoria;
BEGIN
    for cv in cur
    LOOP
        dbms_output.put_line('Név: '||cv.nev);
        dbms_output.put_line('Feldolgozva: '||cur%notfound);
    END LOOP;
END;