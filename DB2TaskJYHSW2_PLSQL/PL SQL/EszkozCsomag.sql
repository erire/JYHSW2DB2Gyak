create or replace package EszkozCsomag is
    procedure ujEszkoz(p_eszkozkulcs number, p_gyartas_ido number, p_magassag number,
      p_irszam number, p_varos varchar, p_utca varchar, p_hazszam number, p_tipus varchar, p_gyarto varchar);
    procedure ujEszkoz2(p_eszkozkulcs number, p_gyartas_ido number, p_magassag number,
      p_irszam number, p_varos varchar, p_utca varchar, p_hazszam number, p_tipus varchar, p_gyarto varchar);
    procedure eszkozModositas(p_eszkozkulcs number, p_gyartas_ido number,
      p_magassag number, p_irszam number, p_varos varchar, p_utca varchar, p_hazszam number,
      p_tipus varchar, p_gyarto varchar);
    procedure Eszkoztorles(p_eszkozkulcs number);
    function eszkozAdatok(eszkozSzam in Meroeszkoz.eszkozkulcs%TYPE) return meroeszkoz%ROWTYPE; 
end EszkozCsomag;


create or replace package body EszkozCsomag is
procedure ujEszkoz(p_eszkozkulcs number, p_gyartas_ido number, p_magassag number,
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

procedure ujEszkoz2(p_gyartas_ido number, p_magassag number,
p_irszam number, p_varos varchar, p_utca varchar, p_hazszam number, p_tipus varchar, p_gyarto varchar) is
Begin
    insert into meroeszkoz values(null, p_gyartas_ido, p_magassag, p_irszam, p_varos,
        p_utca, p_hazszam, p_tipus, p_gyarto);
End;

procedure eszkozModositas(p_eszkozkulcs number, p_gyartas_ido number,
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

procedure Eszkoztorles(p_eszkozkulcs number) is
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

function eszkozAdatok(eszkozSzam in Meroeszkoz.eszkozkulcs%TYPE) return
meroeszkoz%ROWTYPE as f_result meroeszkoz%ROWTYPE;
begin
    select * into f_result from meroeszkoz WHERE eszkozkulcs = eszkozSzam;
    return f_result;
end;
end package;