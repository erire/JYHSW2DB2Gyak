CREATE SEQUENCE Meres_seq;

CREATE OR REPLACE TRIGGER EszkorFelvitel
  BEFORE INSERT ON meroeszkoz
  FOR EACH ROW
BEGIN
  SELECT Meres_seq.nextval
  INTO :new.eszkozkulcs
  FROM dual;
END;


create or replace procedure ujEszkoz2(p_gyartas_ido number, p_magassag number,
p_irszam number, p_varos varchar, p_utca varchar, p_hazszam number, p_tipus varchar, p_gyarto varchar) is
Begin
    insert into meroeszkoz values(null, p_gyartas_ido, p_magassag, p_irszam, p_varos,
        p_utca, p_hazszam, p_tipus, p_gyarto);
End;