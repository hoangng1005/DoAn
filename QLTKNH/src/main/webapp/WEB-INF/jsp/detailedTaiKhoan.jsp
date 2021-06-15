<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết tài khoản</title>
<style type="text/css">
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  padding-left = 150px;
  margin-top = 50px;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

.button {
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
  background-color: #008CBA;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.topnav {
  overflow: hidden;
  background-color: #333;
  padding-left:16px
 
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<div class="topnav">
  <a class="active" href="#home">Trang chủ</a>
  <a href="#news">Thông Báo</a>
  <a href="listkhachhang">Khách hàng</a>
  <a href="accounts">Tài khoản</a>
  <a href="#about">Nhân viên</a>
  <a href="">Phản ánh</a>
</div>

	<c:forEach items="${taiKhoan}" var="tk">
	<h1>Chi tiết tài khoản khách hàng ${tk.getMaKH()} </h1>
	</c:forEach>
	<table id="customers">
		<tr>
			<th>Mã khách hàng</th>
			<th>Số tài khoản</th>
			<th>Mã loại tài khoản</th>
			<th>Số dư</th>
			<th>Trạng thái tài khoản</th>
		</tr>
		<c:forEach items="${taiKhoan}" var="tk">
		<tr>
			<td>${tk.getMaKH() }</td>
			<td>${tk.getSoTK() }</td>
			<td>${tk.getMaLoaiTK() }</td>
			<td>${tk.getSoDu() }</td>
			<td>${tk.getTrangThaiTK() }</td>
			
		</tr>
	</c:forEach>
</body>
</html>