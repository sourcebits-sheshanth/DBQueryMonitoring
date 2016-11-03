1. Configure DB credentials and URL accordingly.
2. Run "JDBCExample.java" program
3. Logs are like below.

LOGS:
Connecting to a selected database...
Connected database successfully...
Creating statement...
[City [id=1, country=India, map=52.35, name=Mysore, state=Karnataka], City [id=2, country=India, map=46.89, name=Bangalore, state=Karnataka]]
[{"country":"India","name":"Mysore","id":1,"state":"Karnataka","map":52.35},{"country":"India","name":"Bangalore","id":2,"state":"Karnataka","map":46.89}]
{"CityList":[{"country":"India","name":"Mysore","id":1,"state":"Karnataka","map":52.35},{"country":"India","name":"Bangalore","id":2,"state":"Karnataka","map":46.89}]}
Goodbye!


==================================Database Configuration===================================
Database : MySQL
DatabaseName : Development
TableName : City

CREATE TABLE City (
  id int(20) NOT NULL,
  country varchar(255) DEFAULT NULL,
  map varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  state varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE population (
  id int(11) unsigned NOT NULL,
  year int(11) NOT NULL,
  humans int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

=========================================================================================
Table Data:
INSERT INTO City (id, name, state, country, map)
VALUES
	(1, 'Mysore', 'Karnataka', 'India', 52.35000000),
	(2, 'Bangalore', 'Karnataka', 'India', 46.89000000),
	(3, 'Udpi', 'Karnataka', 'India', 12.00000000),
	(4, 'Pune', 'Maharasta', 'India', 67.00000000);



INSERT INTO population (id, year, humans)
VALUES
	(1, 1990, 200),
	(2, 1995, 270),
	(3, 2000, 320),
	(4, 2010, 500),
	(5, 2016, 690);
