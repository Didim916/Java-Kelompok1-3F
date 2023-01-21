-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2023 at 11:16 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbbarokah`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` varchar(8) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nohp` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `nama`, `username`, `password`, `nohp`) VALUES
('WRB001', 'Kelompok 1', 'kelompok1', 'kelompok1', '081111111111');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` varchar(8) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `harga` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `nama`, `harga`) VALUES
('BRG001', 'panadol', 1000),
('BRG002', 'bpdrex', 1500),
('BRG003', 'tolak angin', 4500),
('BRG004', 'pege linu', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `id` varchar(8) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nohp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kasir`
--

INSERT INTO `kasir` (`id`, `nama`, `username`, `password`, `nohp`) VALUES
('wrb001', 'nana', 'nana', 'nana', '085219337119'),
('wrb002', 'imam maulana', 'imam', 'imam123', '082384721843'),
('wrb003', 'prasetyo', 'pras', 'pras123', '08279264261');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(8) NOT NULL,
  `id_transaksi` varchar(10) NOT NULL,
  `id_barang` varchar(8) NOT NULL,
  `NamaBarang` varchar(25) NOT NULL,
  `HarSatuan` int(10) NOT NULL,
  `JmlBarang` int(10) NOT NULL,
  `TotalBarang` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `id_transaksi`, `id_barang`, `NamaBarang`, `HarSatuan`, `JmlBarang`, `TotalBarang`) VALUES
(139, 'TRX001', 'brg001', 'panadol', 1000, 11, 11000),
(140, 'TRX001', 'brg002', 'bpdrex', 1500, 12, 18000),
(141, 'TRX001', 'brg003', 'tolak angin', 4500, 13, 58500),
(142, 'TRX001', 'brg004', 'pege linu', 4000, 14, 56000),
(143, 'TRX002', 'brg003', 'tolak angin', 4500, 33, 148500),
(144, 'TRX002', 'brg002', 'bpdrex', 1500, 22, 33000),
(145, 'TRX003', 'brg001', 'panadol', 1000, 1, 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
