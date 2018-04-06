-- "hello world" stored procedure

CREATE OR REPLACE PROCEDURE HELLO_WORLD_PROC
IS
BEGIN
    DBMS_OUT.PUT_LINE('hello world');
END;
/


SET SERVEROUTPUT ON;

BEGIN
    HELLO_WORLD_PROC();
END;
/


CREATE OR REPLACE PROCEDURE GET_ALL_EMPLOYEES (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT EMP_ID, EMP_NAME
    FROM EMPLOYEE;
    END;
    /
    
DECLARE
    S       SYS_REFCURSOR;
    TEMP_ID EMPLOYEE.EMP_ID%TYPE;
    TEMP_NAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    GET_ALL_EMPLOYEES(S);
    LOOP
        FETCH S INTO TEMP_ID, TEMP_NAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_ID||' is current id,'||TEMP_NAME||' is current name');
    END LOOP;
    CLOSE S;
END;
/

select d.dpt_name, d.monthly_budget, sum(e.monthly_salary)
from employee e
join department d
on e.dept_id = d.dpt_id
group by d.dpt_name, d.monthly_budget;



--procedure to give a raise
create or replace procedure give_raise(
input_id employee.emp_id%type,
raise_amnt employee.monthly_salary%type
)
is
dept_budget department.monthly_budget%type;
budget_used department.monthly_budget%type;
employee_name employee.emp_name%type;
current_salary employee.monthly_salary%type;
begin
--get the budget for the department that the employee is in
select department.monthly_budget
into dept_budget
from department
where dpt_id = (select dept_id from employee where emp_id = input_id);
dbms_output.put_line(dept_budget);

--get the amount of budget already used

select sum(monthly_salary)
into budget_used
from employee
where dpt_id = (select dept_id from employee where emp_id = input_id);
select emp_name, monthly_salary
into employee_name, current_salary
from employee
where emp_id = input_id;

--compare potential budget to current budget
if (budget_used + raise_amount) > dept_budget then
dbms_output.put_line('Department funds not available for raise.');
dbms_output.put_line('Monthly salary for '||employee_name||' remains '||current_salary);
else 
    --update the employee salary
    update employee
    set monthly_salary = (current_salary + raise_amnt)
    where emp_id = input_id;
    dbms_output.put_line(employee_name||' successfully increased salary'||raise_amnt||'.');
    dbms_output.put_line(employee_name||'''s new salary is '||(current_salary + raise_amnt));
    end if;
end;
/

begin
give_raise(10, 750);
end;
/


-- new fucntion
create or replace funtion find_max_char(
x in varchar2,
y in varchar2
)
return varchar2;
is
z varchar2(10)
begin
if x > y then
    z := x;
else
    z:= y;
end if;
return z;
end;
/