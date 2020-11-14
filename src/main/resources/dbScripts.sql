#DDL 

CREATE SCHEMA `users_tree` ;


CREATE TABLE `users_tree`.`user` (
  `user_id` BIGINT(30) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(100) NOT NULL,
  `department` VARCHAR(100) NOT NULL,
  `boss_id` BIGINT(30) NULL,
  PRIMARY KEY (`user_id`));


ALTER TABLE `users_tree`.`user` 
ADD INDEX `User_id_FK_idx` (`boss_id` ASC) VISIBLE;
;


# BOSS_ID references the USER_ID in the same USER table.

ALTER TABLE `users_tree`.`user` 
ADD CONSTRAINT `User_id_FK`
  FOREIGN KEY (`boss_id`)
  REFERENCES `users_tree`.`user` (`user_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

#DML
# Added few users as per the Tree view diagram provided in the requirement with CEO as the root of the node tree.


INSERT INTO `users_tree`.`user` (`user_id`, `user_name`, `department`) VALUES ('1', 'Stella', 'CEO');
INSERT INTO `users_tree`.`user` (`user_id`, `user_name`, `department`, `boss_id`) VALUES ('2', 'Luke', 'VP Mktg', '1');
INSERT INTO `users_tree`.`user` (`user_id`, `user_name`, `department`, `boss_id`) VALUES ('3', 'Peggy', 'VP Engg', '1');
INSERT INTO `users_tree`.`user` (`user_id`, `user_name`, `department`, `boss_id`) VALUES ('4', 'Meg', 'Sales', '2');
INSERT INTO `users_tree`.`user` (`user_id`, `user_name`, `department`, `boss_id`) VALUES ('5', 'Ligori', 'Mktg', '2');
INSERT INTO `users_tree`.`user` (`user_id`, `user_name`, `department`, `boss_id`) VALUES ('6', 'Saul', 'Manufg', '3');
INSERT INTO `users_tree`.`user` (`user_id`, `user_name`, `department`, `boss_id`) VALUES ('7', 'Xavier', 'Engg', '3');
