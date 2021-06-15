<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa thông tin khách hàng</title>
<style type="text/css">
body{
    font-family: Arial, Helvetica, sans-serif;
}
	h1{
		color: black;
		margin-left: 350px;
		font-weight: bold;
	}
	/*input{
		width:200px;
		height: 40px;
		margin-bottom: 20px;
		border-radius: 5px;
		border: 1px solid grey;
		padding-left: 10px;
	}*/
	input:hover{
		font-size:15px;
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
#editcustomer{
margin-left: 350px;
}
#editcustomer td{
border: 2px solid black;
padding: 8px;
}
	</style>
</head>
<body>
<div class="topnav">
  <a class="active" href="#home">Trang chủ</a>
  <a href="#news">Thông Báo</a>
  <a href="listkhachhang">Khách hàng</a>
  <a href="#about">Nhân viên</a>
  <a href="">Phản ánh</a>
</div>

<h1>Sửa thông tin khách hàng</h1>
	<form action="update" method="post" >
		<table id="editcustomer" border="1">
		<c:forEach items="${khachhang}" var="kh">
		<tr>
			<td>Mã khách hàng: </td>
			<td><input type="text" value="${kh.getMaKH() }" name="MaKH" readonly/></td>
		</tr>
		<tr>
			<td>Họ tên: </td>
			<td><input type="text" value="${kh.getHoTen() }" name="HoTen" /></td>
		</tr>
		<tr>
			<td>Địa chỉ: </td>
			<td><input type="text" value="${kh.getDiaChi() }" name="DiaChi" /></td>
				
		</tr>
		<tr>
			<td>Ngày sinh: </td>
			<td><input type="text" value="${kh.getNgaySinh() }" name="NgaySinh" />(yyyy/mm/dd)</td>
		</tr>
		<tr>
			<td>Giới tính: </td>
			<td><input type="radio" name="GioiTinh" value="Nam" checked="" />Nam
				<input type="radio" name="GioiTinh" value="Nữ"/>Nữ
			</td>
		</tr>
		<tr>
			<td>CMND: </td>
			<td><input type="text" value="${kh.getCMND() }" name="CMND" /></td>
		</tr>
		<tr>
			<td>Số điện thoại: </td>
			<td><input type="text" value="${kh.getSoDT() }" name="SoDT" /></td>
		</tr>
		<tr>
			<td>Nghề Nghiệp: </td>
			<td><input type="text" value="${kh.getNgheNghiep() }" name="NgheNghiep" /></td>
		</tr>
		<tr>
			<td>Email: </td>
			<td><input type="text" value="${kh.getEmail() }" name="Email" /></td>
		</tr>				
		<tr>
			<td></td>
			<td><input type="submit" value="Cập nhật" /></td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>