/*============================== INSERT DATABASE =======================================*/


INSERT INTO Address		(AddressName		) 
VALUES					(N'Ha Noi'	),
						(N'Nam dinh'),
						(N'Thai Binh');

-- Add data Department
INSERT INTO Department(DepartmentName	, author_id	, CreateDate	 	, ModifiedDate	 ,	AddressID	)
VALUES 					(N'Marketing'	, 1			, 	 '2020-03-05'	, 	'2020-03-05' ,		1		),
					   (N'Sale'			, 2			,	'2020-03-05'	,	'2020-03-05' ,		2		),
					   (N'Bảo vệ'		, 3			, 	'2020-03-07'	, 	'2020-03-07' ,		2		),
					   (N'Nhân sự'		, 3			, 	'2020-03-08'	, 	'2020-03-08' ,		2		),
					   (N'Kỹ thuật'		, 4			,	'2020-03-10'	,	'2020-03-10' ,		1		),
					   (N'Tài chính'	, 5			, 	NOW()			, 	'0202-02-01' ,		1		),
					   (N'Phó giám đốc'	, 6			, 	NOW()			, 	NOW()		 ,		3		),
					   (N'Giám đốc'		, 7			, 	'2020-04-07'	, 	'2020-04-07' ,		3		),
					   (N'Thư kí'		, 8			,	'2020-04-07'	,	'2020-04-07' ,		1		),
					   (N'Bán hàng'		, 9			, 	'2020-04-09'	, 	'2020-04-09' ,		2		),
																				         
                       (N'Kỹ thuật điện', 10		, 	'2019-03-05'	, 	'2019-03-05' ,		2		),
					   (N'Tư vấn'		, 12		,	'2018-02-03'	,	'2018-02-03' ,		3		),
					   (N'Lễ tân'		, 13		, 	'2017-11-09'	, 	'2017-11-09' ,		1		),
					   (N'Sự kiện'		, 3			, 	'2020-12-08'	, 	'2020-12-08' ,		3		),
					   (N'Văn Phòng'	, 15		, 	NOW()			, 	'2018-02-02' ,		3		),
					   (N'Quản lý'		, 6			, 	NOW()			, 	NOW()		 ,		1		),
					   (N'Trực ban'		, 17		, 	'2020-01-01'	, 	'2020-01-01' ,		3		),
					   (N'Vệ sinh'		, 8			,	'2019-01-01'	,	'2019-01-01' ,		2		);


-- password=123456
-- Add data Account
INSERT INTO `Account`	(Email								, Username		,`Password`														,FirstName	, LastName		,		`Role`			, DepartmentID	, 	CreateDate)
VALUES 				   ('haidang29productions@gmail.com'	, 'dangblack'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Dang'	, 'Nguyen Hai'	,		'Manager'		, '5'			,  '2020-01-05'),
					   ('account1@gmail.com'				, 'quanganh'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Anh'		, 'Tong Quang'	,		'Employee'		, '1'			,  '2020-02-05'),
					   ('account2@gmail.com'				, 'vanchien'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Chien'	, 'Nguyen Van'	,		'Manager'		, '1'			,  '2020-03-07'),
					   ('account3@gmail.com'				, 'cocoduongqua','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Do'		, 'Duong'		,		'Admin'			, '3'			,  '2020-04-08'),
					   ('account4@gmail.com'				, 'doccocaubai'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Thang'	, 'Nguyen Chien',		'Admin'		    , '4'			,  '2020-05-10'),
					   ('dapphatchetngay@gmail.com'			, 'khabanh'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Kha'		, 'Ngo Ba'		,		'Employee'		, '6'			,  NOW()),
					   ('songcodaoly@gmail.com'				, 'huanhoahong'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Huan'	, 'Bui Xuan'	,		'Manager'		, '7'			,  NOW()),
					   ('sontungmtp@gmail.com'				, 'tungnui'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Tung'	, 'Nguyen Thanh',		'Employee'		, '8'			,  '2020-06-07'),
					   ('duongghuu@gmail.com'				, 'duongghuu'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Huu'		, 'Duong Van'	,		'Manager'		, '1'			,  '2020-07-07'),
					   ('vtiaccademy@gmail.com'				, 'vtiaccademy'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Ai'		, 'Vi Ti'		,		'Employee'		, '10'			,  '2020-08-09'),
																																									
                       ('nguyenvantrung@gmail.com'			, 'trungone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Trung'	, 'Nguyen Van'	,		'Employee'		, '5'			,  '2020-09-05'),
					   ('nguyenvancuong@gmail.com'			, 'cuongone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Cuong'	, 'Nguyen Van'	,		'Manager'			, '11'			,  '2020-10-05'),
					   ('tranvantrung@gmail.com'			, 'truntranone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Tran'	, 'Tran Van'	,		'Employee'		, '1'			,  '2020-11-07'),
					   ('hongvantuan@gmail.com'				, 'tuanhoaone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Tuan'	, 'Hong Van'	,		'Admin'			, '13'			,  '2020-12-08'),
					   ('nguyenbathuc@gmail.com'			, 'thucohcone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Thuc'	, 'Nguyen Ba'	,		'Manager'		, '14'			,  '2020-03-01'),
					   ('nguyenngocvu@gmail.com'			, 'vutrongone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Vu'		, 'Nguyen Ngo'	,		'Manager'			, '16'			,  NOW()),
					   ('tonghongson@gmail.com'				, 'sontongone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Son'		, 'Tong Hong'	,		'Admin'		, '17'			,  NOW()),
					   ('trungtruntrung@gmail.com'			, 'truntrunone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Trun'	, 'Trung Trun'	,		'Manager'		, '8'			,  '2020-04-02'),
					   ('tringuyen@gmail.com'				, 'nguyentrione','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Tri'		, 'Nguyen'		,		'Manager'		, '1'			,  '2020-04-03'),
					   ('nguyenvan@gmail.com'				, 'vanvoone'	,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'Vo'		, 'Nguyen Van'	,		'Employee'		,  '10'			,  '2020-04-04');


ALTER TABLE Department
ADD FOREIGN KEY (author_id) REFERENCES `Account`(AccountID);