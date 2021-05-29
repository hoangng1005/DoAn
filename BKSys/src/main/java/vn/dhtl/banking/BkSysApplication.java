package vn.dhtl.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import vn.dhtl.banking.model.KhachHang;

import java.util.List;

@SpringBootApplication
public class BkSysApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(BkSysApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM KhachHang";
        List<KhachHang> khachHangs = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(KhachHang.class));

        khachHangs.forEach(System.out::println);
            
        }
    }
}
