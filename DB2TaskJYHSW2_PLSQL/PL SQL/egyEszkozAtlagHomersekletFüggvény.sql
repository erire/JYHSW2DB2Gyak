create or replace function egyEszkozAtlagHomerseklet(eszkozSzam in int) return int as f_result int;
begin
    select avg(homerseklet) into f_result from meresiadatok WHERE eszkozkulcs = eszkozSzam;
    return(f_result);
end;