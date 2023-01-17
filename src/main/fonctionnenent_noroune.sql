-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 18 déc. 2022 à 21:49
-- Version du serveur : 8.0.27
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `fonctionnenent_noroune`
--

-- --------------------------------------------------------

--
-- Structure de la table `couche`
--

DROP TABLE IF EXISTS `couche`;
CREATE TABLE IF NOT EXISTS `couche` (
  `id_couche` int NOT NULL AUTO_INCREMENT,
  `id_network` int NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id_couche`),
  KEY `id_network` (`id_network`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `network`
--

DROP TABLE IF EXISTS `network`;
CREATE TABLE IF NOT EXISTS `network` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `nbr_hiddenCouche` int NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `neurone`
--

DROP TABLE IF EXISTS `neurone`;
CREATE TABLE IF NOT EXISTS `neurone` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `id_chouche` int NOT NULL,
  `bias_h` float NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `id_chouche` (`id_chouche`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `poid`
--

DROP TABLE IF EXISTS `poid`;
CREATE TABLE IF NOT EXISTS `poid` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `id_neurone` int NOT NULL,
  `point` float NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `id_neurone` (`id_neurone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `couche`
--
ALTER TABLE `couche`
  ADD CONSTRAINT `couche_ibfk_2` FOREIGN KEY (`id_network`) REFERENCES `network` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `neurone`
--
ALTER TABLE `neurone`
  ADD CONSTRAINT `neurone_ibfk_1` FOREIGN KEY (`id_chouche`) REFERENCES `couche` (`id_couche`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `poid`
--
ALTER TABLE `poid`
  ADD CONSTRAINT `poid_ibfk_1` FOREIGN KEY (`id_neurone`) REFERENCES `neurone` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
