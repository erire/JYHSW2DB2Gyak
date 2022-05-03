declare
n number(4);
van_oszto number(1) := 0;
oszto integer := 2;
begin
l_seed := to_char(SYSTIMESTAMP, 'YYYYDDMMHH24MISSFFFF');
dbms_random.seed(l_seed);
n := 10;
dbms_output.put(n);
loop
  if mod(n,oszto)=0 then
    van_oszto:=1;
  end if;
oszto := oszto+1;
exit when van_oszto=1 or oszto>n/2;
end loop;
if van_oszto=0 then
  dbms_output.put_line(' : prímszám');
else
  dbms_output.put_line(' : nem prímszám');
end if;
end;