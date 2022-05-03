create or replace procedure eszkozModositas(p_eszkozkulcs number, p_gyartas_ido number,
p_magassag number, p_irszam number, p_varos varchar, p_utca varchar, p_hazszam number,
p_tipus varchar, p_gyarto varchar) is
notexsisterror exception;
rows_found number;
begin
    select count(*)
    into rows_found
    from meroeszkoz
    where eszkozkulcs = p_eszkozkulcs;
    
    if rows_found = 0 then raise notexsisterror;
    else
        update meroeszkoz set gyartas_ido = p_gyartas_ido, magassag = p_magassag,
        irszam = p_irszam, varos = p_varos, utca = p_utca, hazszam = p_hazszam,
        tipus = p_tipus, gyarto = p_gyarto where eszkozkulcs = p_eszkozkulcs;
    end if;
exception
    when notexsisterror then
    dbms_output.put_line('Ilyen azonosítójú mer?eszköz nem létezik!');
end;