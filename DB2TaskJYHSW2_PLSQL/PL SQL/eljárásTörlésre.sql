create or replace procedure Eszkoztorles(p_eszkozkulcs number) is
notexsisterror exception;
rows_found number;
begin
    select count(*)
    into rows_found
    from meroeszkoz
    where eszkozkulcs = p_eszkozkulcs;
    
    if rows_found = 0 then raise notexsisterror;
    else
        delete from meroeszkoz where eszkozkulcs = p_eszkozkulcs;
    end if;
exception
    when notexsisterror then
    dbms_output.put_line('Ilyen azonosítójú termék nem létezik!');
end;