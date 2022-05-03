create or replace function eszkozAdatok(eszkozSzam in Meroeszkoz.eszkozkulcs%TYPE) return
meroeszkoz%ROWTYPE as f_result meroeszkoz%ROWTYPE;
begin
    select * into f_result from meroeszkoz WHERE eszkozkulcs = eszkozSzam;
    return f_result;
end;