
CREATE TABLE TBL_Atribute
(
	AtributeID           INTEGER NOT NULL ,
	AtributeName         NVARCHAR2(128) NOT NULL ,
	AtributeTypeID       INTEGER NOT NULL ,
	isActive             SMALLINT NOT NULL  CONSTRAINT  VR_AtrbuteBool CHECK (isActive IN (0, 1)),
	EntityTypeID         INTEGER NOT NULL ,
	isRequired           SMALLINT NOT NULL  CONSTRAINT  VR_isRequiredBool CHECK (isRequired IN (0, 1)),
	SortOrder            INTEGER NOT NULL ,
	RegularExpression    NVARCHAR2(256) NOT NULL 
);



CREATE UNIQUE INDEX XPKTBL_Atribute ON TBL_Atribute
(AtributeID   ASC);



ALTER TABLE TBL_Atribute
	ADD CONSTRAINT  XPKTBL_Atribute PRIMARY KEY (AtributeID);



CREATE TABLE TBL_AtributeType
(
	AtributeTypeID       INTEGER NOT NULL ,
	AtributeTypeName     NVARCHAR2(64) NOT NULL 
);



CREATE UNIQUE INDEX XPKTBL_AtributeType ON TBL_AtributeType
(AtributeTypeID   ASC);



ALTER TABLE TBL_AtributeType
	ADD CONSTRAINT  XPKTBL_AtributeType PRIMARY KEY (AtributeTypeID);



CREATE TABLE TBL_Entity
(
	EntityID             INTEGER NOT NULL ,
	EntityName           NVARCHAR2(256) NOT NULL ,
	isActive             SMALLINT NOT NULL  CONSTRAINT  VR_BOOL CHECK (isActive IN (0, 1)),
	EntityTypeID         INTEGER NOT NULL ,
	UserID               INTEGER NOT NULL 
)
	TABLESPACE NetShop_DATA;



CREATE UNIQUE INDEX XPKTBL_Entity ON TBL_Entity
(EntityID   ASC)
	TABLESPACE NetShop_INDEX;



ALTER TABLE TBL_Entity
	ADD CONSTRAINT  XPKTBL_Entity PRIMARY KEY (EntityID);



CREATE TABLE TBL_EntityType
(
	EntityTypeID         INTEGER NOT NULL ,
	EntityTypeName       NVARCHAR2(128) NOT NULL ,
	isActive             SMALLINT NOT NULL  CONSTRAINT  VR_ObjectBool CHECK (isActive IN (0, 1))
);



CREATE UNIQUE INDEX XPKTBL_EntityType ON TBL_EntityType
(EntityTypeID   ASC);



ALTER TABLE TBL_EntityType
	ADD CONSTRAINT  XPKTBL_EntityType PRIMARY KEY (EntityTypeID);



CREATE TABLE TBL_Role
(
	RoleID               char(1) NOT NULL ,
	RoleName             NVARCHAR2(128) NOT NULL 
)
	TABLESPACE NetShop_DATA;



CREATE UNIQUE INDEX XPKTBL_Role ON TBL_Role
(RoleID   ASC)
	TABLESPACE NetShop_INDEX;



ALTER TABLE TBL_Role
	ADD CONSTRAINT  XPKTBL_Role PRIMARY KEY (RoleID);



CREATE TABLE TBL_User
(
	UserID               INTEGER NOT NULL ,
	Login                NVARCHAR2(256) NOT NULL ,
	Password             NVARCHAR2(128) NOT NULL ,
	UserName             NVARCHAR2(256) NOT NULL ,
	ContactPhone         VARCHAR2(64) NULL ,
	ContactAdress        NVARCHAR2(256) NULL ,
	RoleID               char(1) NOT NULL ,
	Email                NVARCHAR2(128) NULL 
)
	TABLESPACE NetShop_DATA;



CREATE UNIQUE INDEX XPKTBL_User ON TBL_User
(UserID   ASC)
	TABLESPACE NetShop_INDEX;



ALTER TABLE TBL_User
	ADD CONSTRAINT  XPKTBL_User PRIMARY KEY (UserID);



CREATE UNIQUE INDEX XAK1TBL_User ON TBL_User
(Login   ASC)
	TABLESPACE NetShop_INDEX;



ALTER TABLE TBL_User
ADD CONSTRAINT  XAK1TBL_User UNIQUE (Login);



CREATE TABLE TBL_Value
(
	ValueID              INTEGER NOT NULL ,
	Value                NVARCHAR2(128) NOT NULL ,
	EntityID             INTEGER NOT NULL ,
	AtributeID           INTEGER NOT NULL 
);



CREATE UNIQUE INDEX XPKTBL_Value ON TBL_Value
(ValueID   ASC);



ALTER TABLE TBL_Value
	ADD CONSTRAINT  XPKTBL_Value PRIMARY KEY (ValueID);



ALTER TABLE TBL_Atribute
	ADD (CONSTRAINT R_27 FOREIGN KEY (AtributeTypeID) REFERENCES TBL_AtributeType (AtributeTypeID));



ALTER TABLE TBL_Atribute
	ADD (CONSTRAINT R_9 FOREIGN KEY (EntityTypeID) REFERENCES TBL_EntityType (EntityTypeID));



ALTER TABLE TBL_Entity
	ADD (CONSTRAINT R_6 FOREIGN KEY (EntityTypeID) REFERENCES TBL_EntityType (EntityTypeID));



ALTER TABLE TBL_Entity
	ADD (CONSTRAINT R_14 FOREIGN KEY (UserID) REFERENCES TBL_User (UserID));



ALTER TABLE TBL_User
	ADD (CONSTRAINT R_38 FOREIGN KEY (RoleID) REFERENCES TBL_Role (RoleID));



ALTER TABLE TBL_Value
	ADD (CONSTRAINT R_10 FOREIGN KEY (EntityID) REFERENCES TBL_Entity (EntityID) ON DELETE CASCADE);



ALTER TABLE TBL_Value
	ADD (CONSTRAINT R_11 FOREIGN KEY (AtributeID) REFERENCES TBL_Atribute (AtributeID));
