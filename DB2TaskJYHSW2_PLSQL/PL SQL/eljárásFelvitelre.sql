create or replace procedure ujEszkoz(p_eszkozkulcs number, p_gyartas_ido number, p_magassag number,
p_irszam number, p_varos varchar, p_utca varchar, p_hazszam number, p_tipus varchar, p_gyarto varchar) is
exsisterror exception;
rows_found number;
begin
    select count(*)
    into rows_found
    from meroeszkoz
    where eszkozkulcs = p_eszkozkulcs;
    
    if rows_found != 0 then raise exsisterror;
    else
        insert into meroeszkoz values(p_eszkozkulcs, p_gyartas_ido, p_magassag, p_irszam, p_varos,
        p_utca, p_hazszam, p_tipus, p_gyarto);
    end if;
exception
    when exsisterror then
    dbms_output.put_line('Ez a mer?eszköz már létezik!');
end;