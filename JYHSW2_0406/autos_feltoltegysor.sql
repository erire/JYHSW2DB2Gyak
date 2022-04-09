DECLARE
rsz varchar2(20);
tipus varchar2(20);
szin varchar2(20);
kor number(2);
ar number(10);
BEGIN
rsz:='QWE123';
tipus:='Ford';
szin:='fehér';
kor:=2;
ar:=1400000;
INSERT INTO auto (rsz,tipus,szin,kor,ar) VALUES (rsz,tipus,szin,kor,ar);
COMMIT;
END;