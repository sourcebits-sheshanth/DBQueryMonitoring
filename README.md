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

CREATE TABLE `City` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `map` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

=========================================================================================
Table Data:

id	country		map		name	state
1	India		52.35	Mysore	Karnataka
2	India		46.89	Bangalore	Karnataka