IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[api_produto].[flyway_schema_history]') AND type in (N'U'))
DROP TABLE [api_produto].[flyway_schema_history]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[item]') AND type in (N'U'))
DROP TABLE [dbo].[item]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[pedido]') AND type in (N'U'))
DROP TABLE [dbo].[pedido]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[orcamento]') AND type in (N'U'))
DROP TABLE [dbo].[orcamento]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[cliente]') AND type in (N'U'))
DROP TABLE [dbo].[cliente]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[produto]') AND type in (N'U'))
DROP TABLE [dbo].[produto]
GO
