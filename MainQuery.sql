CREATE DATABASE im;
USE im;

CREATE TABLE students (
	student_id int,
	student_name text,
	student_address text,
	student_course text,
	student_gender text,
	student_year text
);
    
CREATE TABLE subjects(
	subject_id int,
    subject_code text,
    subject_desc text,
    subject_units int,
    subject_sched text
);

CREATE TABLE teachers (
	teacher_id int,
    teacher_name text,
    teacher_department text,
    teacher_address text,
    teacher_contact text,
    teacher_status text
);

CREATE TABLE enroll (
	student_id int,
    subject_id int
);

CREATE TABLE assign (
	teacher_id int,
    subject_id int
);
    