<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Khach Hang</title>
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

	<h1>Danh sách khách hàng</h1>
	
	<a href="new" class="button">Thêm mới khách hàng</a>
	
	<table id="customers">
		<tr>
			<th>Mã khách hàng</th>
			<th>Số tài khoản</th>
			<th>Họ tên</th>
			<th>Ngày sinh</th>
			<th>Địa chỉ</th>
			<th>Số CMND</th>
			<th>Số điện thoại</th>
			<th>Nghề Nghiệp</th>
			<th>Ngày cập nhật</th>
			<th>Giới tính</th>
			<th>Email</th>
			<th>Mã chi nhánh</th>
		</tr>
		<c:forEach items="${khachHang}" var="kh">
		<tr>
			<td>${kh.getMaKH() }</td>
			<td>${kh.getSoTK() }</td>
			<td>${kh.getHoTen() }</td>
			<td>${kh.getNgaySinh() }</td>
			<td>${kh.getDiaChi() }</td>
			<td>${kh.getCMND() }</td>
			<td>${kh.getSoDT() }</td>
			<td>${kh.getNgheNghiep() }</td>
			<td>${kh.getNgayCapNhat() }</td>
			<td>${kh.getGioiTinh() }</td>
			<td>${kh.getEmail() }</td>
			<td>${kh.getMaCN() }</td>
			<td><a href="edit?id=${kh.getMaKH() }">Sửa</a></td>
			<td><a href="delete?id=${kh.getMaKH() }">Xóa</a></td>	
			<td><a href="detail?id=${kh.getMaKH() }">Xem chi tiết</a></td>
					
		</tr>
	</c:forEach>
</body>
</html>