-- phpMyAdmin SQL Dump
-- version 4.0.5
-- http://www.phpmyadmin.net
--
-- Host: 127.5.60.2:3306
-- Generato il: Mag 14, 2014 alle 17:12
-- Versione del server: 5.1.73
-- Versione PHP: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `socialstudy`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `ANNUNCIO`
--

CREATE TABLE IF NOT EXISTS `ANNUNCIO` (
  `ID` bigint(20) NOT NULL,
  `TESTO` varchar(255) DEFAULT NULL,
  `LOCATION_ID` bigint(20) DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ANNUNCIO_LOCATION_ID` (`LOCATION_ID`),
  KEY `FK_ANNUNCIO_USER_ID` (`USER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `CORSO`
--

CREATE TABLE IF NOT EXISTS `CORSO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CORSODISTUDI` varchar(255) DEFAULT NULL,
  `CREDITI` int(11) DEFAULT NULL,
  `DESCRIZIONE` varchar(255) DEFAULT NULL,
  `DOCENTE` varchar(255) DEFAULT NULL,
  `MFU` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `NUM_ISCRITTI` int(11) DEFAULT NULL,
  `SEMESTRE` int(11) DEFAULT NULL,
  `LOCATION_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CORSO_LOCATION_ID` (`LOCATION_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=113 ;

--
-- Dump dei dati per la tabella `CORSO`
--

INSERT INTO `CORSO` (`ID`, `CORSODISTUDI`, `CREDITI`, `DESCRIZIONE`, `DOCENTE`, `MFU`, `NOME`, `NUM_ISCRITTI`, `SEMESTRE`, `LOCATION_ID`) VALUES
(111, 'altro', 2, 'aaa', 'a', '4343', 'altro', 4, 2, 102),
(101, 'Informatica', 6, 'Modelli generali di agenti. \r\nPractical reasoning agents. Agenti BDI. \r\nFormalismi per modellare agenti: \r\n - logiche modali, temporali, epistemiche \r\n - ragionamento sulle azioni \r\nLinguaggi per agenti \r\nSistemi multi-agente: \r\n - Agent Communication Lan', 'Martelli, Baldoni', 'mfn1348', 'Agenti intelligenti', NULL, 2, 102),
(102, 'Informatica', 6, 'Progetto e analisi di Algoritmi \r\n- Programmazione dinamica. Uso "top-down" e \r\n"bottom-up" di definizioni ricorsive di funzioni. \r\nEsempi: Zaino, Cammini minimi nei grafi, Prodotto di \r\nmatrici. \r\n- Backtracking. Esempi: Il problema delle n regine, \r\nCom', 'Zacchi', 'mfn0997', 'Algoritmi e Complessità A', NULL, 1, 102),
(103, 'Informatica', 9, '• Introduzione e motivazioni \r\n• Il processo di KDD (estrazione di conoscenza dati \r\ndati) \r\n• Processi di pre-processing (campionamento, selezione \r\ndegli attributi, trasformazione) \r\n• Vincoli di estrazione della conoscenza che specificano \r\nl’interesse', 'Baroglio, Meo', 'mfn0943', 'Apprendimento Automatico e Analisi Intelligente dei Dati \r\n', NULL, 1, 102),
(104, 'Informatica', 6, '• PARTE I: \r\n• Concetti di base delle architetture RISC \r\n• Concetti di base del Pipelining \r\n• Instruction Level Parallelism (ILP) dinamico \r\n• Instruction Level Parallelism (ILP) statico \r\n• Concetti fondamentali di Caching \r\n• PARTE II: \r\n• Introduzion', 'Gunetti', 'mfn0969', 'Architettura degli Elaboratori II', NULL, 1, 102),
(105, 'Informatica', 9, 'Introduzione al problema della gestione di dati \r\neterogenei in applicazioni multimediali \r\n- rassegna dei modelli di dati “tradizionali” \r\n- Introduzione a modelli dei dati per applicazioni \r\nmultimediali; features di basso livello e gap semantico. \r\n- L', 'Sapino', 'mfn0947', 'Basi di Dati Multimediali ', NULL, 2, 102),
(106, 'Informatica', 6, 'Introduzione alla biologia molecolare. Algoritmi di \r\nallineamento di sequenze. Algoritmi di allineamento \r\nmultiplo. Costruzione di alberi filogenetici. Struttura \r\ndelle proteine e predizione della struttura. Reti di \r\nregolazione genica: modelli e algo', 'Botta, Cordero', 'mfn0951', 'Bioinformatica', NULL, 1, 102),
(107, 'Informatica', 6, 'Calcolabilita'': \r\n- Problemi decidibili e non \r\n- Macchine di Turing \r\n- La tesi di Church \r\n- Il problema dell''alt \r\n- Decidibilita'' e semi-decibilita'' \r\n \r\nComplessita'': \r\n- Problemi trattabili e intrattabili \r\n- Misure della complessita'' \r\n- Riducibili', 'de’ Liguoro', 'mfn0939', 'Calcolabilità e Complessità B', NULL, 1, 102),
(108, 'Informatica', 6, 'Attese condizionate e relative proprietà; Catene di \r\nMarkov: principali proprietà; Equazione di Chapman \r\nKolmogorov; Classificazione degli stati; Proprietà \r\nlimite; Processo di Poisson. \r\nRichiami di Algebra Lineare; Trasformate di Laplace e \r\nFourier:', 'Benenti, Bibbona', 'mfn0971', 'Complementi di Analisi e Probabilità', NULL, 1, 102),
(109, 'Informatica', 6, 'Analisi di bilancio economico-finanziaria. \r\n- analisi per indici \r\n- analisi per flussi \r\n- analisi comparata \r\nAnalisi dei principali modelli strategici: \r\n- analisi di Porter \r\n- swot analysis \r\n- ciclo di vita \r\n- catena del valore \r\n \r\nLavori di Grup', 'Pironti, Pisano', 'mfn0946', 'Economia e Gestione delle Imprese Net Based', NULL, 1, 102),
(110, 'Informatica', 9, 'Introduzione. \r\nElaborazione di Immagini: definizioni. \r\nEsempi di ambiti d’uso dell’elaborazione di immagini. \r\nPassi fondamentali nell’elaborazione di immagini. \r\nComponenti di un sistema per l’elaborazione di \r\nimmagini. \r\n \r\nImmagini digitali: fondame', 'Balossino, Cavagnino, Grangetto', 'mfn0972', 'Elaborazione di Immagini e Visione Artificiale \r\n', NULL, 1, 102);

-- --------------------------------------------------------

--
-- Struttura della tabella `GRUPPO`
--

CREATE TABLE IF NOT EXISTS `GRUPPO` (
  `ID` bigint(20) NOT NULL,
  `ARGOMENTI` varchar(255) DEFAULT NULL,
  `INCONTRI` longblob,
  `NOME` varchar(255) DEFAULT NULL,
  `UTENTI` longblob,
  `CORSO_ID` bigint(20) DEFAULT NULL,
  `FONDATORE_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_GRUPPO_CORSO_ID` (`CORSO_ID`),
  KEY `FK_GRUPPO_FONDATORE_ID` (`FONDATORE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `GRUPPO_UTENTE`
--

CREATE TABLE IF NOT EXISTS `GRUPPO_UTENTE` (
  `Gruppo_ID` bigint(20) NOT NULL,
  `utenti_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`Gruppo_ID`,`utenti_ID`),
  KEY `FK_GRUPPO_UTENTE_utenti_ID` (`utenti_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `INCONTRO`
--

CREATE TABLE IF NOT EXISTS `INCONTRO` (
  `ID` bigint(20) NOT NULL,
  `DATAINCONTRO` date DEFAULT NULL,
  `GRUPPO_ID` bigint(20) DEFAULT NULL,
  `LOCATION_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_INCONTRO_GRUPPO_ID` (`GRUPPO_ID`),
  KEY `FK_INCONTRO_LOCATION_ID` (`LOCATION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `LIBRETTO`
--

CREATE TABLE IF NOT EXISTS `LIBRETTO` (
  `ID` bigint(20) NOT NULL,
  `CORSI` longblob,
  `VOTI` longblob,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `LOCATION`
--

CREATE TABLE IF NOT EXISTS `LOCATION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LAT` float DEFAULT NULL,
  `LNG` float NOT NULL,
  `DESCRIZIONE` varchar(255) DEFAULT NULL,
  `INDIRIZZO` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=153 ;

--
-- Dump dei dati per la tabella `LOCATION`
--

INSERT INTO `LOCATION` (`ID`, `LAT`, `LNG`, `DESCRIZIONE`, `INDIRIZZO`, `TYPE`) VALUES
(102, 45.09, 7.65914, 'Dipartimento di Informatica', 'Via Pessinetto, 12', 'Dipartimento'),
(130, 45.0487, 7.67885, 'SALA STUDIO PIETRO GIURIA', 'via Pietro Giuria 17', 'Aula Studio'),
(105, 45.0499, 7.67391, 'DIPARTIMENTO DI BIOTECNOLOGIE MOLECOLARI E SCIENZE PER LA SALUTE', 'Via Nizza, 52', 'Dipartimento'),
(106, 45.0513, 7.68074, 'DIPARTIMENTO DI CHIMICA', 'Via P. Giuria, 7', 'Dipartimento'),
(107, 45.0679, 7.69394, 'DIPARTIMENTO DI FILOSOFIA E SCIENZE DELL''EDUCAZIONE', 'Via S. Ottavio, 20', 'Dipartimento'),
(108, 45.0747, 7.7015, 'DIPARTIMENTO DI CULTURE, POLITICA E SOCIETÀ', 'Lungo Dora Siena 100 A', 'Dipartimento'),
(109, 45.0747, 7.7015, 'DIPARTIMENTO DI ECONOMIA E STATISTICA "COGNETTI DE MARTIIS"', 'Lungo Dora Siena 100 A', 'Dipartimento'),
(110, 45.0521, 7.68146, 'DIPARTIMENTO DI FISICA', 'Via P. Giuria, 1', 'Dipartimento'),
(111, 45.0747, 7.7015, 'DIPARTIMENTO DI GIURISPRUDENZA', 'Lungo Dora Siena 100 A', 'Dipartimento'),
(112, 45.0539, 7.68485, 'DIPARTIMENTO INTERATENEO DI SCIENZE, PROGETTO E POLITICHE DEL TERRITORIO', 'Viale Mattioli, 39', 'Dipartimento'),
(113, 45.0679, 7.69394, 'DIPARTIMENTO DI LINGUE E LETTERATURE STRANIERE E CULTURE MODERNE', 'Via S. Ottavio, 20', 'Dipartimento'),
(114, 45.0376, 7.65158, 'DIPARTIMENTO DI MANAGEMENT', 'C.so Unione Sovietica, 218 Bis', 'Dipartimento'),
(115, 45.0677, 7.68572, 'DIPARTIMENTO DI MATEMATICA "GIUSEPPE PEANO"', 'Via Carlo Alberto, 10', 'Dipartimento'),
(116, 45.0387, 7.67261, 'DIPARTIMENTO DI NEUROSCIENZE "RITA LEVI MONTALCINI"', 'Via Cherasco, 15', 'Dipartimento'),
(118, 45.068, 7.57568, 'DIPARTIMENTO DI PSICOLOGIA', 'Via Verdi, 10', 'Dipartimento'),
(119, 45.0509, 7.68039, 'DIPARTIMENTO DI SCIENZA E TECNOLOGIA DEL FARMACO', 'Via P. Giuria, 9', 'Dipartimento'),
(120, 45.0412, 7.67636, 'DIPARTIMENTO DI SCIENZE CHIRURGICHE', 'C.So Dogliotti, 14', 'Dipartimento'),
(121, 45.036, 7.67513, 'DIPARTIMENTO DI SCIENZE DELLA SANITÀ PUBBLICA E PEDIATRICHE', 'P.zza Polonia, 94', 'Dipartimento'),
(122, 45.0526, 7.68178, 'DIPARTIMENTO DI SCIENZE DELLA TERRA', 'Via Valperga Caluso, 35', 'Dipartimento'),
(123, 45.0376, 7.65158, 'DIPARTIMENTO DI SCIENZE ECONOMICO-SOCIALI E MATEMATICO-STATISTICHE', 'C.so Unione Sovietica, 218 Bis', 'Dipartimento'),
(124, 45.0663, 7.58865, 'DIPARTIMENTO DI SCIENZE VETERINARIE', 'Via Leonardo Da Vinci, 44', 'Dipartimento'),
(125, 45.0679, 7.69394, 'DIPARTIMENTO DI STUDI STORICI', 'Via S. Ottavio, 20', 'Dipartimento'),
(127, 45.0679, 7.69394, 'DIPARTIMENTO DI STUDI UMANISTICI', 'Via S. Ottavio, 20', 'Dipartimento'),
(128, 45.0679, 7.6629, 'SALA STUDIO CASTELFIDARDO', 'corso Castelfidardo 30/A', 'Aula Studio'),
(131, 45.0508, 7.67803, 'SALA STUDIO MICHELANGELO BUONARROTI', 'via Michelangelo Buonarroti 17 bis', 'Aula Studio'),
(132, 45.0671, 7.69327, 'SALA STUDIO SANT''OTTAVIO', 'via Sant''Ottavio 12', 'Aula Studio'),
(133, 45.0904, 7.66093, 'SALA STUDIO SVIZZERA', 'corso Svizzera 185', 'Aula Studio'),
(134, 45.1492, 7.70962, 'SALA STUDIO VERDI', 'via Verdi 26', 'Aula Studio'),
(135, 45.0701, 7.67009, 'Murazzi Student Zone', 'Via Murazzi del Po, 26', 'Aula Studio'),
(136, 45.0749, 7.6734, 'Civica centrale', 'Via della Cittadella, 5', 'Biblioteca'),
(137, 45.073, 7.57528, 'Musicale A. Della Corte', 'Corso Francia 186', 'Biblioteca'),
(138, 45.0324, 7.65327, 'Dietrich Bonhoeffer', 'Corso Corsica, 55', 'Biblioteca'),
(139, 45.0862, 7.67822, 'Italo Calvino', 'Lungo Dora Agrigento, 94', 'Biblioteca'),
(140, 45.0686, 7.62664, 'Luigi Carluccio', 'Via Monte Ortigara, 95', 'Biblioteca'),
(141, 45.0973, 7.69222, 'Cascina Marchesa', 'C.so Vercelli, 141/7', 'Biblioteca'),
(142, 45.0976, 7.63883, 'Francesco Cognasso', 'Corso Cincinnato, 115', 'Biblioteca'),
(143, 45.1326, 7.6285, 'Punto prestito G. D’Annunzio', 'Via Saccarelli, 18', 'Biblioteca'),
(144, 45.1269, 7.70989, 'Falchera', 'Via dei Pioppi, 43', 'Biblioteca'),
(145, 45.0709, 7.7273, 'Alberto Geisser', 'Corso Casale, 5', 'Biblioteca'),
(146, 45.0563, 7.6826, 'Natalia Ginzburg', 'Via Cesare Lombroso, 16', 'Biblioteca'),
(147, 45.0856, 7.69777, 'Primo Levi', 'Via Leoncavallo, 17', 'Biblioteca'),
(148, 45.0188, 7.63033, 'Mirafiori', 'Corso Unione Sovietica, 490', 'Biblioteca'),
(149, 45.0406, 7.62872, 'A. Passerin d’Entrèves', 'Via Guido Reni 102', 'Biblioteca'),
(150, 45.0155, 7.64924, 'Cesare Pavese', 'Via Candiolo, 79', 'Biblioteca'),
(151, 45.0749, 7.6734, 'Torino Centro', 'Via della Cittadella, 5', 'Biblioteca'),
(152, 45.0429, 7.63971, 'Villa Amoretti', 'Corso Orbassano, 200', 'Biblioteca');

-- --------------------------------------------------------

--
-- Struttura della tabella `MAPPA`
--

CREATE TABLE IF NOT EXISTS `MAPPA` (
  `ID` bigint(20) NOT NULL,
  `LOCATION` longblob,
  `UTENTE` longblob,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(20) NOT NULL,
  `recipient` varchar(20) NOT NULL,
  `ts_sent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `message` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sender_idx` (`sender`),
  KEY `fk_recipient_idx` (`recipient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `phone_numbers`
--

CREATE TABLE IF NOT EXISTS `phone_numbers` (
  `phone_number` varchar(20) NOT NULL,
  `device_type` varchar(15) NOT NULL,
  `device_id` varchar(255) NOT NULL,
  `private_key` char(32) NOT NULL,
  PRIMARY KEY (`phone_number`),
  KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `phone_numbers`
--

INSERT INTO `phone_numbers` (`phone_number`, `device_type`, `device_id`, `private_key`) VALUES
('+393207870608', 'iOs', '10293u1203120939123', '5c78bd94-438f-45d7-a2ca-146c5191'),
('+393476364301', 'Android', 'APA91bGg3HDsCwv3CU7G2aVl4DzqDoZg_gDFQbZ9RIePBE1Z-nASS8JBgwPcN35NSEBU5qhBHENrE3PUsH4BSmJyEXc6B4V0jwHM4idWQ-qGMY7W7Q4JGnT3V4aZM8saYXnF0aR6hYX5XupkZnAmragcjgTdCQXE_w', 'bdde47c8-74dc-4780-b75a-833a4997');

-- --------------------------------------------------------

--
-- Struttura della tabella `SEQUENCE`
--

CREATE TABLE IF NOT EXISTS `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `SEQUENCE`
--

INSERT INTO `SEQUENCE` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '150');

-- --------------------------------------------------------

--
-- Struttura della tabella `UTENTE`
--

CREATE TABLE IF NOT EXISTS `UTENTE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COGNOME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `IDLOG` varchar(255) NOT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `LIBRETTO_ID` bigint(20) DEFAULT NULL,
  `PHONE_NUMBER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_UTENTE_LIBRETTO_ID` (`LIBRETTO_ID`),
  KEY `PHONE_NUMBER` (`PHONE_NUMBER`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Dump dei dati per la tabella `UTENTE`
--

INSERT INTO `UTENTE` (`ID`, `COGNOME`, `EMAIL`, `IDLOG`, `NOME`, `USERNAME`, `LIBRETTO_ID`, `PHONE_NUMBER`) VALUES
(27, 'Barresi', 'barresi.daniele@gmail.com', '114353837635511545560', 'Daniele', 'dani', NULL, '+393463582271'),
(28, 'Valente', 'oneiros.valente@gmail.com', '113763096077848920275', 'Lorenzo', 'Oneiros', NULL, '+393207870608'),
(29, 'Cataudella', 'drugomic@yahoo.it', '556302910', 'Michele', 'mic', NULL, '+393476364301');

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `fk_recipient` FOREIGN KEY (`recipient`) REFERENCES `phone_numbers` (`phone_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sender` FOREIGN KEY (`sender`) REFERENCES `phone_numbers` (`phone_number`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
