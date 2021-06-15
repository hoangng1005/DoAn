<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản</title>
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

#searchForm{
	padding-bottom:10px;
	font-family: Arial, Helvetica, sans-serif;
	
}

#searchButton{
  font-family: Arial, Helvetica, sans-serif;
	float: left;
	margin-top:17px;
	padding:5px;
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

.searchFormBox{
	width: 25%;
	float: left;
	font-family: Arial, Helvetica, sans-serif;
	
}
.inputBox{
	padding: 5px;
	
}
.lableBox{
	padding-bottom: 5px;
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

	<h1>Thông tin tài khoản </h1>
	
	<form id="searchForm" action="search" method="post">
		<div class = "searchFormBox">
			<label class = "lableBox" >Số tài khoản</label><br>
  			<input class="inputBox" type="text" id="acc" name="SoTK" placeholder="Nhập số tài khoản"><br>
		</div>
		<div class = "searchFormBox">
			<label class = "lableBox" >Nhập ngày bắt đầu</label><br>
  			<input class="inputBox" type="text" id="startDate" name="NgayBatDau" placeholder = "Nhập ngày giao dịch"><br><br>
		</div>
		<div class = "searchFormBox">
  			<label class = "lableBox" >Nhập ngày đích</label><br>
  			<input class="inputBox" type="text" id="endDate" name="NgayKetThuc" placeholder = "Nhập ngày giao dịch"><br><br>		
		</div>
  		<input id="searchButton" type="submit" value="Tìm kiếm">
	</form>
	
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