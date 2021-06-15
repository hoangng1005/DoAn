package controller;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhachHangDAO;
import model.GiaoDich;
import model.KhachHang;
import model.TaiKhoan;

@WebServlet("/")
public class KhachHangController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private KhachHangDAO khachHangDAO;
	
	public void init() {
        khachHangDAO = new KhachHangDAO();
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertKhachHang(request, response);
                    break;
                case "/delete":
                    deleteKhachHang(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateKhachHang(request, response);
                    break;
                case "/detail":
                	showDetailedAccount(request, response);
                	break;
                case "/accounts":
                	listAllTaiKhoan (request, response);
                	break;
                case "/search":
                	searchGiaoDich (request, response);
                	break;
                default:
                    listAllKhachHang(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
            } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        
        private void listAllKhachHang(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, IOException, ServletException {
        	        List < KhachHang > listKhachHang = khachHangDAO.showAllKhachHang();
        	        request.setAttribute("khachHang", listKhachHang);
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listKhachHang.jsp");
        	        dispatcher.forward(request, response);
        	    }
        
        private void listAllTaiKhoan (HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, IOException, ServletException{
        	List <TaiKhoan> listTaiKhoan = khachHangDAO.showAllTaiKhoan();
	        request.setAttribute("taiKhoan", listTaiKhoan);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listTaiKhoan.jsp");
	        dispatcher.forward(request, response);
        }
        
        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
        	    throws ServletException, IOException {
        	response.setContentType("text/html; charset=UTF-8");
        	request.setCharacterEncoding("UTF-8");
        	response.setCharacterEncoding("UTF-8");
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newKhachHang.jsp");
        	        dispatcher.forward(request, response);
        	    }
        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, ServletException, IOException {
        	        String MaKH = request.getParameter("id");
        	        List<KhachHang> khachHang = khachHangDAO.selectKhachHang(MaKH);
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editKhachHang.jsp");
        	        request.setAttribute("khachhang", khachHang);
        	        dispatcher.forward(request, response);

        	    }
        private void insertKhachHang(HttpServletRequest rs, HttpServletResponse response)
        	    throws SQLException, IOException, ParseException {
        	response.setContentType("text/html; charset=UTF-8");
        	rs.setCharacterEncoding("UTF-8");
        	response.setCharacterEncoding("UTF-8");
//        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            String MaKH = rs.getParameter("MaKH");
//            String SoTK = rs.getParameter("SoTK");
            String HoTen = rs.getParameter("HoTen");
//            Date NgaySinh = formatter.parse(rs.getParameter("NgaySinh"));
            String NgaySinh = rs.getParameter("NgaySinh");
            String DiaChi = rs.getParameter("DiaChi");
            String CMND = rs.getParameter("CMND");
            String SoDT = rs.getParameter("SoDT");
            String NgheNghiep = rs.getParameter("NgheNghiep");
//            String NgayCapNhat = rs.getParameter("NgayCapNhat");
            String GioiTinh = rs.getParameter("GioiTinh");
            String Email = rs.getParameter("Email");
        	
        			KhachHang kh = new KhachHang();
        			kh.setMaKH(MaKH);
//        			kh.setSoTK(SoTK);
        			kh.setHoTen(HoTen);
//        			kh.setNgaySinh(new java.sql.Date(NgaySinh.getTime()));
        			kh.setDiaChi(DiaChi);
        			kh.setCMND(CMND);
        			kh.setSoDT(SoDT);
        			kh.setNgheNghiep(NgheNghiep);
//        			kh.setNgayCapNhat(NgayCapNhat);
        			kh.setGioiTinh(GioiTinh);
        			kh.setEmail(Email);
        			
        	        khachHangDAO.insertKhachHang(kh, NgaySinh);
        	        response.sendRedirect("listkhachhang");
        	    }
        private void updateKhachHang(HttpServletRequest rs, HttpServletResponse response)
        	    throws SQLException, IOException, ParseException {
        	response.setContentType("text/html; charset=UTF-8");
        	rs.setCharacterEncoding("UTF-8");
        	response.setCharacterEncoding("UTF-8");
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            String MaKH = rs.getParameter("MaKH");
            String SoTK = rs.getParameter("SoTK");
            String HoTen = rs.getParameter("HoTen");
            String NgaySinh = rs.getParameter("NgaySinh");
//            Date NgaySinh = formatter.parse(rs.getParameter("NgaySinh"));
            String DiaChi = rs.getParameter("DiaChi");
            String CMND = rs.getParameter("CMND");
            String SoDT = rs.getParameter("SoDT");
            String NgheNghiep = rs.getParameter("NgheNghiep");
//            String NgayCapNhat = rs.getParameter("NgayCapNhat");
            String GioiTinh = rs.getParameter("GioiTinh");
            String Email = rs.getParameter("Email");
            String MaCN = rs.getParameter("MaCN");

			KhachHang kh = new KhachHang();
			kh.setMaKH(MaKH);
			kh.setSoTK(SoTK);
			kh.setHoTen(HoTen);
//			kh.setNgaySinh(new java.sql.Date(NgaySinh.getTime()));
			kh.setDiaChi(DiaChi);
			kh.setCMND(CMND);
			kh.setSoDT(SoDT);
			kh.setNgheNghiep(NgheNghiep);
//			kh.setNgayCapNhat(NgayCapNhat);
			kh.setGioiTinh(GioiTinh);
			kh.setEmail(Email);
			kh.setMaCN(MaCN);
			
	        khachHangDAO.updateKhachHang(kh,NgaySinh);
	        response.sendRedirect("listkhachhang");
        	    }
        
        private void showDetailedAccount(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, ServletException, IOException {
        	        String MaKH = request.getParameter("id");
        	        List<TaiKhoan> taiKhoan= khachHangDAO.selectTaiKhoan(MaKH);
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detailedTaiKhoan.jsp");
        	        request.setAttribute("taiKhoan", taiKhoan);
        	        dispatcher.forward(request, response);

        	    }
        
        private void deleteKhachHang(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, IOException {
        	        String MaKH = request.getParameter("id");
        	        khachHangDAO.deleteKhachHang(MaKH);
        	        response.sendRedirect("listkhachhang");

        	    }
        
        private void searchGiaoDich(HttpServletRequest rs, HttpServletResponse response)
        	    throws SQLException, IOException, ParseException, ServletException {
        	String SoTK = rs.getParameter("SoTK");
        	String NgayBatDau = rs.getParameter("NgayBatDau");
        	String NgayKetThuc = rs.getParameter("NgayKetThuc");
        	List<GiaoDich> giaoDich = khachHangDAO.searchTransaction(SoTK,NgayBatDau,NgayKetThuc);
	        rs.setAttribute("giaoDich", giaoDich);
	        RequestDispatcher dispatcher = rs.getRequestDispatcher("/WEB-INF/jsp/searchGiaoDich.jsp");
	        dispatcher.forward(rs, response);
        } 
    
}
