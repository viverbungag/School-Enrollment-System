CREATE DATABASE im2;
USE im;

CREATE TABLE students (
	student_id int NOT NULL,
	student_name text,
	student_address text,
	student_course text,
	student_gender text,
	student_year text,
    PRIMARY KEY (student_id)
);
    
CREATE TABLE subjects(
	subject_id int NOT NULL,
    subject_code text,
    subject_desc text,
    subject_units int,
    subject_sched text,
    PRIMARY KEY (subject_id)
);

CREATE TABLE teachers (
	teacher_id int NOT NULL,
    teacher_name text,
    teacher_department text,
    teacher_address text,
    teacher_contact text,
    teacher_status text,
    PRIMARY KEY(teacher_id)
);

CREATE TABLE enroll (
	enroll_id int NOT NULL,
	student_id int,
    subject_id int,
    PRIMARY KEY(enroll_id),
    FOREIGN KEY(student_id) REFERENCES students(student_id),
    FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
);

CREATE TABLE assign (
	date text,
    teacher_id int,
    subject_id int,
	FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id),
    FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
);

CREATE TABLE transaction_charges(
	trans_id int NOT NULL,
    deparment decimal(15, 2),
    subject_units decimal(15, 2),
    insuarance decimal(15,2),
    computer decimal(15,2),
    laboratory decimal(15,2),
    cultural decimal(15,2),
    library decimal(15,2),
    facility decimal(15,2),
    PRIMARY KEY (trans_id)
);

CREATE TABLE invoice(
	invoice_num int NOT NULL,
    due_date int,
    PRIMARY KEY (invoice_num)
);

CREATE TABLE grades(
	grade_id int NOT NULL,
    prelim text,
    midterm text,
    prefinal text,
    PRIMARY KEY (grade_id)
);
    