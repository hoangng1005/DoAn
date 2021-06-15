package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GiaoDich;
import model.KhachHang;
import model.TaiKhoan;

public class KhachHangDAO {
	private String jdbcURL = "jdbc:sqlserver://WIN-K8V40RRR3OE\\MSSQLSERVER01;database=QLTKNH";
    private String jdbcUsername = "sa";
    private String jdbcPassword = "123456";

    private static final String INSERT_USERS_SQL = "insert into KhachHang(MaKH,HoTen,NgaySinh,DiaChi,CMND,SoDT,NgheNghiep,GioiTinh, Email, MaCN)"
    		+ " values (?,?,?,?,?,?,?,?,?,'CN1');";

    private static final String SELECT_USER_BY_ID = "Select * from KhachHang where MaKH=?";
    private static final String SELECT_ALL_USERS = "select * from KhachHang";
    private static final String DELETE_USERS_SQL = "delete from KhachHang where MaKH = ?;";
    private static final String UPDATE_USERS_SQL = "Update KhachHang set HoTen = ?,NgaySinh=?,DiaChi=?,CMND=?,SoDT=?,NgheNghiep=?,GioiTinh=?,Email=? where MaKH= ?";
    private static final String SELECT_ACCOUNT_BY_ID = "Select * from TaiKhoan where MaKH=?";
    private static final String SELECT_ALL_ACCS = "select * from TaiKhoan";
    private static final String SELECT_TRANSACTION = "Select * from GiaoDich where (SoTK = ?) and (NgayGD between ? and ?)";

    public KhachHangDAO(){}
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    public List < KhachHang > showAllKhachHang() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < KhachHang > khachHang = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String MaKH = rs.getString("MaKH");
                String SoTK = rs.getString("SoTK");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String DiaChi = rs.getString("DiaChi");
                String CMND = rs.getString("CMND");
                String SoDT = rs.getString("SoDT");
                String NgheNghiep = rs.getString("NgheNghiep");
                Date NgayCapNhat = rs.getDate("NgayCapNhat");
                String GioiTinh = rs.getString("GioiTinh");
                String Email = rs.getString("Email");
                String MaCN = rs.getString("MaCN");

                khachHang.add(new KhachHang(MaKH,SoTK,HoTen,NgaySinh, DiaChi,CMND,SoDT,NgheNghiep,NgayCapNhat,GioiTinh,Email,MaCN));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return khachHang;
    }
    
    public List < TaiKhoan > showAllTaiKhoan() {

        List < TaiKhoan > taiKhoan = new ArrayList < > ();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String SoTK = rs.getString("SoTK");
                String MaLoaiTK = rs.getString("MaLoaiTK");
                String MaKH = rs.getString("MaKH");                
                float SoDu = rs.getFloat("SoDu");
                Date NgayCapNhat = rs.getDate("NgayCapNhat");
                String TrangThaiTK = rs.getString("TrangThaiTK");

                taiKhoan.add(new TaiKhoan(SoTK, MaLoaiTK,MaKH, SoDu, NgayCapNhat, TrangThaiTK));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return taiKhoan;
    }
    
    
    
    public List<KhachHang> selectKhachHang(String MaKH) {
        KhachHang khachHang = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setString(1, MaKH);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            List<KhachHang> list = new ArrayList<>();

            while (rs.next()) {
                String SoTK = rs.getString("SoTK");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String DiaChi = rs.getString("DiaChi");
                String CMND = rs.getString("CMND");
                String SoDT = rs.getString("SoDT");
                String NgheNghiep = rs.getString("NgheNghiep");
                Date NgayCapNhat = rs.getDate("NgayCapNhat");
                String GioiTinh = rs.getString("GioiTinh");
                String Email = rs.getString("Email");
                String MaCN = rs.getString("MaCN");

                khachHang = new KhachHang(MaKH,SoTK,HoTen,NgaySinh, DiaChi,CMND,SoDT,NgheNghiep,NgayCapNhat,GioiTinh,Email,MaCN);
                list.add(khachHang);
            }
            
            return list;

        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
    
    public boolean deleteKhachHang(String MaKH) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setString(1, MaKH);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean updateKhachHang(KhachHang a, String ngaysinh) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_USERS_SQL);) {
			ps.setString(1, a.getHoTen());
			ps.setString(2, ngaysinh);
			ps.setString(3, a.getDiaChi());
			ps.setString(4, a.getCMND());
			ps.setString(5, a.getSoDT());
			ps.setString(6, a.getNgheNghiep());
//			ps.setDate(7, a.getNgayCapNhat());
			ps.setString(7, a.getGioiTinh());
			ps.setString(8,a.getEmail());
			ps.setString(9, a.getMaKH());

            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public void insertKhachHang(KhachHang a, String ngaysinh) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
			ps.setString(1, a.getMaKH());
//			ps.setString(2, a.getSoTK());
			ps.setString(2, a.getHoTen());
			ps.setString(3, ngaysinh);
			ps.setString(4, a.getDiaChi());
			ps.setString(5, a.getCMND());
			ps.setString(6, a.getSoDT());
			ps.setString(7, a.getNgheNghiep());
//			ps.setDate(9, a.getNgayCapNhat());
			ps.setString(8, a.getGioiTinh());
			ps.setString(9,a.getEmail());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public List<TaiKhoan> selectTaiKhoan(String MaKH) {
    	TaiKhoan taiKhoan = null;
//        List < TaiKhoan > taiKhoan = new ArrayList < > ();
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID);) {
                preparedStatement.setString(1, MaKH);
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();
                List<TaiKhoan> list = new ArrayList<>();

                while (rs.next()) {
                    String SoTK = rs.getString("SoTK");
                    String MaLoaiTK = rs.getString("MaLoaiTK");
                	String maKH = rs.getString("MaKH");
                    Date NgayCapNhat = rs.getDate("NgayCapNhat");
                    String TrangThaiTK = rs.getString("TrangThaiTK");
                    int SoDu = rs.getInt("SoDu");
              

                    taiKhoan = new TaiKhoan(SoTK,MaLoaiTK,maKH,SoDu,NgayCapNhat,TrangThaiTK);
                    list.add(taiKhoan);
                }
                return list;
            } catch (SQLException e) {
                printSQLException(e);
            }
            return null;
    }
    
    public List<GiaoDich> searchTransaction (String SoTK, String ngayBatDau, String ngayKetThuc) {
    	GiaoDich giaoDich = null;
    	try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANSACTION);) {
                preparedStatement.setString(1, SoTK);
                preparedStatement.setString(2, ngayBatDau);
                preparedStatement.setString(3, ngayKetThuc);                
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                List<GiaoDich> list = new ArrayList<>();
                
                while (rs.next()) {
                    String MaGD = rs.getString("MaGD");
                    String soTK = rs.getString("SoTK");
                    String MaLoaiGD = rs.getString("MaLoaiGD");
                    int SoTienGD = rs.getInt("SoTienGD");
                    Date NgayGD = rs.getDate("NgayGD");
                    String NoiDung = rs.getString("NoiDung");

                    giaoDich = new GiaoDich(MaGD,soTK,MaLoaiGD,SoTienGD,NgayGD,NoiDung);
                    list.add(giaoDich);
                }
                return list;
            } catch (SQLException e) {
                printSQLException(e);
            }
            return null;
    }
    
    
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
