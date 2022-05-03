create or replace procedure VDbKiir(p_Sorszam Number) is
notexsisterror exception;
rows_found number;
begin
    select count(*)
    into rows_found
    from Vasarlas
    where Sorszam = p_Sorszam;
    
    if rows_found = 0 then raise notexsisterror;
    else
      select count(Sorszam) from Vasarlas;
    end if;
end;