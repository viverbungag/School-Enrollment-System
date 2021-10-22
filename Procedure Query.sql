USE `1st_sy2021_2022`;
DROP procedure IF EXISTS `check_time`;

DELIMITER $$
CREATE PROCEDURE check_time(IN sched VARCHAR(30), IN id INT, OUT checkIfValid BOOLEAN, OUT subCode TEXT)
BEGIN

	DECLARE day_sched TEXT DEFAULT "";
	DECLARE time_sched_begin TIME DEFAULT "";
	DECLARE time_sched_end TIME DEFAULT "";
    
    DECLARE day_input TEXT DEFAULT "";
    DECLARE time_input_begin TIME DEFAULT "";
    DECLARE time_input_end TIME DEFAULT "";
    
    DECLARE count INT DEFAULT 0;
    DECLARE x INT DEFAULT 0;
    DECLARE sCode TEXT DEFAULT "";

    SELECT COUNT(*) FROM subjects INNER JOIN enroll ON subjects.subject_id = enroll.subject_id AND enroll.student_id = id INTO count;

	SET x = 0;
    
    SET day_input = SUBSTRING(sched, 1, 2);
    SET time_input_begin = STR_TO_DATE(SUBSTRING(sched, 4, 8), "%l:%i %p");
    SET time_input_end = STR_TO_DATE(SUBSTRING(sched, 14, 9), "%l:%i %p");
    
    SET checkIfValid = TRUE;
    WHILE x < count DO
    
        SELECT SUBSTRING(subject_sched, 1, 2), STR_TO_DATE(SUBSTRING(subject_sched, 4, 8), "%l:%i %p"), STR_TO_DATE(SUBSTRING(subject_sched, 14, 9), "%l:%i %p"), subject_code INTO day_sched, time_sched_begin, time_sched_end, sCode FROM subjects INNER JOIN enroll ON subjects.subject_id = enroll.subject_id AND enroll.student_id = id LIMIT x, 1;
        SET x = x + 1;
        
        IF day_input = day_sched AND (((time_input_begin BETWEEN time_sched_begin AND time_sched_end) OR (time_input_end BETWEEN time_sched_begin AND time_sched_end)) OR ((time_sched_begin BETWEEN time_input_begin AND time_input_end) OR (time_sched_end BETWEEN time_input_begin AND time_input_end))) THEN
			SET checkIfValid = FALSE;
            SET subCode = sCode;
            
		END IF;
    
    END WHILE;

    
END$$
DELIMITER ;



