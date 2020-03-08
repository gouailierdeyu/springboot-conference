package conference.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * UTF-8
 * Created by CZY    Time : 2019/11/13 10:39
 */
@Configuration
public class TransactionManagerConfig {
	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
		DataSourceTransactionManager manager=new DataSourceTransactionManager(dataSource);
		return manager;
	}
}
