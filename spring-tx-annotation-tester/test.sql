--DATASERVER1 dataSource1
use sandbox
CREATE TABLE reference_date(date DATETIME)
SELECT * FROM reference_date
--DELETE FROM reference_date

--DATASERVER2 dataSource2
use test
CREATE TABLE reference_date(date DATETIME)
SELECT * FROM reference_date
--DELETE FROM reference_date