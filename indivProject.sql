-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Ноя 01 2022 г., 14:47
-- Версия сервера: 5.6.51
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `indivProject`
--

-- --------------------------------------------------------

--
-- Структура таблицы `basket`
--

CREATE TABLE `basket` (
  `id` bigint(20) NOT NULL,
  `quantity` bigint(20) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `productss_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `basket`
--

INSERT INTO `basket` (`id`, `quantity`, `order_id`, `productss_id`) VALUES
(34, 2, 16, 33),
(35, 2, 16, 33);

-- --------------------------------------------------------

--
-- Структура таблицы `cheque`
--

CREATE TABLE `cheque` (
  `id` bigint(20) NOT NULL,
  `quantity` bigint(20) NOT NULL,
  `timesell` time NOT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `employees_id` bigint(20) DEFAULT NULL,
  `products_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `middlename` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `client`
--

INSERT INTO `client` (`id`, `address`, `email`, `middlename`, `name`, `surname`, `user_id`) VALUES
(13, 'Нахимовский проспект 21', 'hekpuisol@mail.ru', 'Иванович', 'Иван', 'Иванов', 12);

-- --------------------------------------------------------

--
-- Структура таблицы `current_balance`
--

CREATE TABLE `current_balance` (
  `id` bigint(20) NOT NULL,
  `quantity` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `current_balance`
--

INSERT INTO `current_balance` (`id`, `quantity`) VALUES
(22, 200),
(23, 130);

-- --------------------------------------------------------

--
-- Структура таблицы `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `middlename` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `numberpassport` bigint(20) NOT NULL,
  `numberphone` bigint(20) NOT NULL,
  `serialpassport` bigint(20) NOT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `employee`
--

INSERT INTO `employee` (`id`, `address`, `middlename`, `name`, `numberpassport`, `numberphone`, `serialpassport`, `surname`, `post_id`, `user_id`) VALUES
(4, 'микрорайон 4А, дом 2', 'Александровна', 'Анастасия', 543342, 79663171778, 5434, 'Никонова', 3, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(36);

-- --------------------------------------------------------

--
-- Структура таблицы `manufacturer`
--

CREATE TABLE `manufacturer` (
  `id` bigint(20) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `stamp_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `manufacturer`
--

INSERT INTO `manufacturer` (`id`, `name`, `stamp_id`) VALUES
(31, 'Японский производитель косметики SHISEIDO', 29),
(32, 'Французская компания L\'Oréal Paris', 30);

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `data` date NOT NULL,
  `noter` varchar(250) DEFAULT NULL,
  `clients_id` bigint(20) DEFAULT NULL,
  `order_status_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`id`, `data`, `noter`, `clients_id`, `order_status_id`) VALUES
(16, '2022-10-31', 'fghjkuytfvbn', 13, 8);

-- --------------------------------------------------------

--
-- Структура таблицы `order_status`
--

CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL,
  `name` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `order_status`
--

INSERT INTO `order_status` (`id`, `name`) VALUES
(8, 'Готов к выдаче'),
(9, 'В обработке'),
(17, 'Выдан');

-- --------------------------------------------------------

--
-- Структура таблицы `post`
--

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `salary` double NOT NULL,
  `titlepost` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `post`
--

INSERT INTO `post` (`id`, `salary`, `titlepost`) VALUES
(3, 125000, 'Директор магазина');

-- --------------------------------------------------------

--
-- Структура таблицы `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `cost` double NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `titleproducts` varchar(250) DEFAULT NULL,
  `current_balance_id` bigint(20) DEFAULT NULL,
  `product_content_id` bigint(20) DEFAULT NULL,
  `stamp_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `products`
--

INSERT INTO `products` (`id`, `cost`, `description`, `titleproducts`, `current_balance_id`, `product_content_id`, `stamp_id`) VALUES
(33, 2371, 'Тушь позволяет идеально подчеркнуть, удлинить и разделить ресницы. Создает легкое регулируемое покрытие благодаря аппликатору, щетинки которого расположены в шахматном порядке и позволяют набрать необходимое количество туши.', 'Тушь-Империал MascaraInk: длина, объем, разделение', 23, 19, 29);

-- --------------------------------------------------------

--
-- Структура таблицы `product_category`
--

CREATE TABLE `product_category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `product_category`
--

INSERT INTO `product_category` (`id`, `name`) VALUES
(24, 'Косметика');

-- --------------------------------------------------------

--
-- Структура таблицы `product_type`
--

CREATE TABLE `product_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `product_category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `product_type`
--

INSERT INTO `product_type` (`id`, `name`, `product_category_id`) VALUES
(25, 'Тушь', 24),
(26, 'Тональный крем', 24);

-- --------------------------------------------------------

--
-- Структура таблицы `product_сontent`
--

CREATE TABLE `product_сontent` (
  `id` bigint(20) NOT NULL,
  `name` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `product_сontent`
--

INSERT INTO `product_сontent` (`id`, `name`) VALUES
(19, 'aqua CT 77499 GLYCERYLSTEARATE COPERNICIA CERIFERA CERA ACRYLATESCOPOLYMER SYNTHETIC BEESWAX CETEARYL ALCOHOL POLYVINYL ALCOHOL RICINUS COMMUNIS (CASTOR) SEED OIL VP/HEXADECENECOPOLYMER POLYBUTENE GLYCERIN PENTYLENE '),
(21, 'Aqua / Water / Eau, Isododecane, Dimethicone, Alcohol Denat., Trimethylsiloxysilicate, Butylene Glycol, Peg-10 Dimethicone, Perlite, Sodium Hyaluronate, Nylon-12, Isopropyl Lauroyl Sarcosinate, Diisopropyl Sebacate, Disteardimonium Hectorite');

-- --------------------------------------------------------

--
-- Структура таблицы `reports`
--

CREATE TABLE `reports` (
  `id` bigint(20) NOT NULL,
  `content` varchar(250) DEFAULT NULL,
  `dateend` date DEFAULT NULL,
  `datestart` date DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `stamp`
--

CREATE TABLE `stamp` (
  `id` bigint(20) NOT NULL,
  `titlestamp` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `stamp`
--

INSERT INTO `stamp` (`id`, `titlestamp`) VALUES
(29, 'SHISEIDO'),
(30, 'L\'Oréal Paris');

-- --------------------------------------------------------

--
-- Структура таблицы `type_stamp`
--

CREATE TABLE `type_stamp` (
  `stamp_id` bigint(20) NOT NULL,
  `product_type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `type_stamp`
--

INSERT INTO `type_stamp` (`stamp_id`, `product_type_id`) VALUES
(29, 25),
(29, 26),
(30, 25),
(30, 26);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `active`, `login`, `password`) VALUES
(1, b'1', 'admin', '$2a$08$.Z6oD3.E.tugxZD.6K2NVufpXp69xGj97grBpL/jF3co1kUdXA7A.'),
(2, b'1', 'inf1RRR', '$2a$08$n0d0zRD9qJV2up0gj5iWBOjfdtFduSCGmRH0DpWuYa7gRE4xPSkkq'),
(12, b'1', 'qwe123', '$2a$08$QWOLYJyb.Kl1BFJ/EigmfuS8uuFTRnLjK04JUjSAuAgb7Hz9Oayci');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'ADMIN'),
(2, 'EMPLOYEE'),
(12, 'USER');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `basket`
--
ALTER TABLE `basket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgiie01snwnw0amns59hwy8er2` (`productss_id`),
  ADD KEY `FKcu5e5yctvkyo4gpst0haw4d43` (`order_id`);

--
-- Индексы таблицы `cheque`
--
ALTER TABLE `cheque`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsh6l8y3fus47g1telxxypbja9` (`client_id`),
  ADD KEY `FKdvbxaqgx3ckvcm3bnr9pqcm4o` (`employees_id`),
  ADD KEY `FKroui85k9kxafdish80nuckqhp` (`products_id`);

--
-- Индексы таблицы `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk1fi84oi1yyuswr40h38kjy1s` (`user_id`);

--
-- Индексы таблицы `current_balance`
--
ALTER TABLE `current_balance`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcm3b9d5fiw8s6co7lkw8c0lbs` (`post_id`),
  ADD KEY `FK6lk0xml9r7okjdq0onka4ytju` (`user_id`);

--
-- Индексы таблицы `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkwf86840ubbeqlru9kuwutyrb` (`stamp_id`);

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd4eiqal2v65pkjcil9i16rs5m` (`clients_id`),
  ADD KEY `FK2n7p8t83wo7x0lep1q06a6cvy` (`order_status_id`);

--
-- Индексы таблицы `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKojxwdf4osx1gli2meppdgheas` (`current_balance_id`),
  ADD KEY `FKr566xeb52u7j1pw47i826m2pt` (`product_content_id`),
  ADD KEY `FKmwm96yqfj50kya3uw4weh6bkd` (`stamp_id`);

--
-- Индексы таблицы `product_category`
--
ALTER TABLE `product_category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `product_type`
--
ALTER TABLE `product_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1kf0jqpi79x9p0wwa4fsah38i` (`product_category_id`);

--
-- Индексы таблицы `product_сontent`
--
ALTER TABLE `product_сontent`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKevqa7krfgaoaoiab4c3j5jkyl` (`employee_id`);

--
-- Индексы таблицы `stamp`
--
ALTER TABLE `stamp`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `type_stamp`
--
ALTER TABLE `type_stamp`
  ADD KEY `FK22me5cpg5iw35qaalern6hdgt` (`product_type_id`),
  ADD KEY `FKby8ohg2vv7kfg0b25lrd95b1o` (`stamp_id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `basket`
--
ALTER TABLE `basket`
  ADD CONSTRAINT `FKcu5e5yctvkyo4gpst0haw4d43` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `FKgiie01snwnw0amns59hwy8er2` FOREIGN KEY (`productss_id`) REFERENCES `products` (`id`);

--
-- Ограничения внешнего ключа таблицы `cheque`
--
ALTER TABLE `cheque`
  ADD CONSTRAINT `FKdvbxaqgx3ckvcm3bnr9pqcm4o` FOREIGN KEY (`employees_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKroui85k9kxafdish80nuckqhp` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKsh6l8y3fus47g1telxxypbja9` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

--
-- Ограничения внешнего ключа таблицы `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKk1fi84oi1yyuswr40h38kjy1s` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FK6lk0xml9r7okjdq0onka4ytju` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKcm3b9d5fiw8s6co7lkw8c0lbs` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Ограничения внешнего ключа таблицы `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD CONSTRAINT `FKkwf86840ubbeqlru9kuwutyrb` FOREIGN KEY (`stamp_id`) REFERENCES `stamp` (`id`);

--
-- Ограничения внешнего ключа таблицы `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK2n7p8t83wo7x0lep1q06a6cvy` FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`id`),
  ADD CONSTRAINT `FKd4eiqal2v65pkjcil9i16rs5m` FOREIGN KEY (`clients_id`) REFERENCES `client` (`id`);

--
-- Ограничения внешнего ключа таблицы `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKmwm96yqfj50kya3uw4weh6bkd` FOREIGN KEY (`stamp_id`) REFERENCES `stamp` (`id`),
  ADD CONSTRAINT `FKojxwdf4osx1gli2meppdgheas` FOREIGN KEY (`current_balance_id`) REFERENCES `current_balance` (`id`),
  ADD CONSTRAINT `FKr566xeb52u7j1pw47i826m2pt` FOREIGN KEY (`product_content_id`) REFERENCES `product_сontent` (`id`);

--
-- Ограничения внешнего ключа таблицы `product_type`
--
ALTER TABLE `product_type`
  ADD CONSTRAINT `FK1kf0jqpi79x9p0wwa4fsah38i` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`id`);

--
-- Ограничения внешнего ключа таблицы `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `FKevqa7krfgaoaoiab4c3j5jkyl` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Ограничения внешнего ключа таблицы `type_stamp`
--
ALTER TABLE `type_stamp`
  ADD CONSTRAINT `FK22me5cpg5iw35qaalern6hdgt` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`id`),
  ADD CONSTRAINT `FKby8ohg2vv7kfg0b25lrd95b1o` FOREIGN KEY (`stamp_id`) REFERENCES `stamp` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
