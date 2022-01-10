-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 10 jan. 2022 à 20:23
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `demo`
--

-- --------------------------------------------------------

--
-- Structure de la table `adminler`
--

CREATE TABLE `adminler` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adminler`
--

INSERT INTO `adminler` (`id_admin`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `calisanlar`
--

CREATE TABLE `calisanlar` (
  `id` int(11) NOT NULL,
  `ad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `soyad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `departman` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `maas` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_turkish_ci;

--
-- Déchargement des données de la table `calisanlar`
--

INSERT INTO `calisanlar` (`id`, `ad`, `soyad`, `departman`, `maas`) VALUES
(1, 'Danette', 'Emiliano', 'IT', '3000'),
(2, 'Maurice', 'Arlen', 'IT', '4000'),
(3, 'Enes', 'Rihanna', 'Ressources humaines', '3000'),
(4, 'Emelie', 'Melissa', 'IT', '2500'),
(5, 'Ismail', 'Barrie', 'Ressources humaines', '2500'),
(6, 'Carl', 'Marcia', 'IT', '5000'),
(7, 'Julio', 'Estebana', 'IT', '3000'),
(8, 'Hacer', 'Vasilisa', 'Ressources humaines', '2500'),
(9, 'Bryan', 'Roberta', 'Gestion', '6000'),
(10, 'Meryem', 'Angela', 'Gestion', '4000'),
(11, 'Danielle', 'Christopher', 'Gestion', '2000'),
(12, 'Gary', 'Matilda', 'Ressources humaines', '2000'),
(13, 'Wilhelmina', 'Kevia', 'Ressources humaines', '2000'),
(14, 'Zandra', 'Filippa', 'Gestion', '4000'),
(15, 'Lulu', 'Jemima', 'Marketing', '4500'),
(16, 'Nicholas', 'Esteban', 'Gestion', '5000'),
(17, 'Nicolette', 'Yaroslav', 'Ressources humaines', '3000'),
(18, 'Cristina', 'Kevin', 'Marketing', '2500'),
(19, 'Esra', 'Ardal', 'Gestion', '4500'),
(20, 'Umut', 'Henrika', 'IT', '4000'),
(21, 'Ryan', 'Marcello', 'Ressources humaines', '4000'),
(22, 'Cleva', 'Jennifer', 'Marketing', '5000'),
(23, 'Mustafa', 'Fifi', 'Ressources humaines', '5500'),
(24, 'Meryem', 'Adib', 'IT', '4000'),
(25, 'Enes', 'Zandra', 'IT', '3000'),
(26, 'Charles', 'Nicholas', 'Ressources humaines', '2000'),
(27, 'Neil', 'Keith', 'Marketing', '5000'),
(28, 'Judah', 'Angelus', 'Marketing', '2000'),
(29, 'Norman', 'Anuj', 'Ressources humaines', '6000'),
(30, 'Arlene', 'Paula', 'Marketing', '3000'),
(31, 'Julius', 'Marcie', 'Marketing', '2500'),
(32, 'Carla', 'Thomasina', 'Gestion', '6000'),
(33, 'Bobby', 'Aniela', 'Marketing', '3000');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adminler`
--
ALTER TABLE `adminler`
  ADD PRIMARY KEY (`id_admin`);

--
-- Index pour la table `calisanlar`
--
ALTER TABLE `calisanlar`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adminler`
--
ALTER TABLE `adminler`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `calisanlar`
--
ALTER TABLE `calisanlar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
