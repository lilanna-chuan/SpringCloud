package xyz.quellanan.views;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.quellanan.views.pool.IpPool;
import xyz.quellanan.views.pool.UrlPool;
import xyz.quellanan.views.util.FileUtils;
import xyz.quellanan.views.vist.VistThread;

@SpringBootApplication
public class ViewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViewsApplication.class, args);
	}

}
