USE [master]
GO
/****** Object:  Database [NFTMark]    Script Date: 7/29/2024 3:40:14 PM ******/
CREATE DATABASE [NFTMark]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'NFTMark', FILENAME = N'D:\FPT POLYTECHNIC\MSSQL16.MSSQLSERVER\MSSQL\DATA\NFTMark.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'NFTMark_log', FILENAME = N'D:\FPT POLYTECHNIC\MSSQL16.MSSQLSERVER\MSSQL\DATA\NFTMark_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [NFTMark] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [NFTMark].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [NFTMark] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [NFTMark] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [NFTMark] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [NFTMark] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [NFTMark] SET ARITHABORT OFF 
GO
ALTER DATABASE [NFTMark] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [NFTMark] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [NFTMark] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [NFTMark] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [NFTMark] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [NFTMark] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [NFTMark] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [NFTMark] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [NFTMark] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [NFTMark] SET  ENABLE_BROKER 
GO
ALTER DATABASE [NFTMark] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [NFTMark] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [NFTMark] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [NFTMark] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [NFTMark] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [NFTMark] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [NFTMark] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [NFTMark] SET RECOVERY FULL 
GO
ALTER DATABASE [NFTMark] SET  MULTI_USER 
GO
ALTER DATABASE [NFTMark] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [NFTMark] SET DB_CHAINING OFF 
GO
ALTER DATABASE [NFTMark] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [NFTMark] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [NFTMark] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [NFTMark] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'NFTMark', N'ON'
GO
ALTER DATABASE [NFTMark] SET QUERY_STORE = ON
GO
ALTER DATABASE [NFTMark] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [NFTMark]
GO
/****** Object:  Table [dbo].[accounts]    Script Date: 7/29/2024 3:40:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[accounts](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[username] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_k8h1bgqoplx0rkngj01pm1rgp] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[authorities]    Script Date: 7/29/2024 3:40:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[authorities](
	[account_id] [int] NOT NULL,
	[role_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[comment]    Script Date: 7/29/2024 3:40:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comment](
	[comment_id] [int] IDENTITY(1,1) NOT NULL,
	[createdate] [datetime2](7) NULL,
	[description] [varchar](255) NULL,
	[username] [varchar](255) NULL,
	[nft_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[comment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 7/29/2024 3:40:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[account_id] [int] NOT NULL,
	[email] [varchar](255) NULL,
	[fullname] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[photo] [varchar](255) NULL,
	[walletkey] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[imagenft]    Script Date: 7/29/2024 3:40:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[imagenft](
	[nftid] [int] IDENTITY(1,1) NOT NULL,
	[image] [varchar](max) NULL,
	[name] [varchar](255) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	[username] [varchar](255) NOT NULL,
	[key_wallet] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[nftid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 7/29/2024 3:40:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[rolename] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_jdhyvh8di85ai37phukfemdnx] UNIQUE NONCLUSTERED 
(
	[rolename] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transactions]    Script Date: 7/29/2024 3:40:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transactions](
	[transactions_id] [int] IDENTITY(1,1) NOT NULL,
	[transactions_date] [datetime2](7) NULL,
	[transactionsdetails] [varchar](255) NULL,
	[username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[transactions_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transactions_detail]    Script Date: 7/29/2024 3:40:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transactions_detail](
	[transactions_detail_id] [int] IDENTITY(1,1) NOT NULL,
	[image] [varchar](255) NULL,
	[price] [float] NOT NULL,
	[transactionsdetails] [varchar](255) NULL,
	[transactions_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[transactions_detail_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[authorities]  WITH CHECK ADD  CONSTRAINT [FK7kj74d912rytfp5su91jfv0tg] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([role_id])
GO
ALTER TABLE [dbo].[authorities] CHECK CONSTRAINT [FK7kj74d912rytfp5su91jfv0tg]
GO
ALTER TABLE [dbo].[authorities]  WITH CHECK ADD  CONSTRAINT [FKt5w1w5h5plhl8j2rd6p71vjrw] FOREIGN KEY([account_id])
REFERENCES [dbo].[accounts] ([account_id])
GO
ALTER TABLE [dbo].[authorities] CHECK CONSTRAINT [FKt5w1w5h5plhl8j2rd6p71vjrw]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK778c3h0awa7m8m22cbg679k9p] FOREIGN KEY([username])
REFERENCES [dbo].[accounts] ([username])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FK778c3h0awa7m8m22cbg679k9p]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FKmr5wqwg8i7tv1er47mwlxoatk] FOREIGN KEY([nft_id])
REFERENCES [dbo].[imagenft] ([nftid])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FKmr5wqwg8i7tv1er47mwlxoatk]
GO
ALTER TABLE [dbo].[customer]  WITH CHECK ADD  CONSTRAINT [FKse75ax979f9lf6i7162100plm] FOREIGN KEY([account_id])
REFERENCES [dbo].[accounts] ([account_id])
GO
ALTER TABLE [dbo].[customer] CHECK CONSTRAINT [FKse75ax979f9lf6i7162100plm]
GO
ALTER TABLE [dbo].[imagenft]  WITH CHECK ADD  CONSTRAINT [FKlmef2xmve62hcmi2d7ejooe8m] FOREIGN KEY([username])
REFERENCES [dbo].[accounts] ([username])
GO
ALTER TABLE [dbo].[imagenft] CHECK CONSTRAINT [FKlmef2xmve62hcmi2d7ejooe8m]
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD  CONSTRAINT [FK4vs9bjcda4p0l5i96fshdsa68] FOREIGN KEY([username])
REFERENCES [dbo].[accounts] ([username])
GO
ALTER TABLE [dbo].[transactions] CHECK CONSTRAINT [FK4vs9bjcda4p0l5i96fshdsa68]
GO
ALTER TABLE [dbo].[transactions_detail]  WITH CHECK ADD  CONSTRAINT [FKwjlq2jjgde5ydkikwa9ui65t] FOREIGN KEY([transactions_id])
REFERENCES [dbo].[transactions] ([transactions_id])
GO
ALTER TABLE [dbo].[transactions_detail] CHECK CONSTRAINT [FKwjlq2jjgde5ydkikwa9ui65t]
GO
USE [master]
GO
ALTER DATABASE [NFTMark] SET  READ_WRITE 
GO
-- sửa lại photo nvarchar 
-- Bước 1: Thêm một cột tạm thời với kiểu dữ liệu chính xác
ALTER TABLE customer
ADD photo_temp VARBINARY(MAX);

-- Bước 2: Chuyển đổi dữ liệu của cột `photo` hiện tại sang cột `photo_temp` mới
UPDATE customer
SET photo_temp = CONVERT(VARBINARY(MAX), photo);

-- Bước 3: Xóa cột `photo` cũ
ALTER TABLE customer
DROP COLUMN photo;

-- Bước 4: Đổi tên `photo_temp` thành `photo`
EXEC sp_rename 'customer.photo_temp', 'photo', 'COLUMN';

