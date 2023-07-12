package board.demo.config;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@RequiredArgsConstructor
public class WriteDbConfig {

    private final ApplicationContext applicationContext;

    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource writeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name= "writeTransactionManager")
    public PlatformTransactionManager writeTransactionManager(@Qualifier("writeDataSource") DataSource writeDataSource) {
        return new DataSourceTransactionManager(writeDataSource);
    }

    @Bean(name = "writeSqlSessionFactory")
    SqlSessionFactory writeSqlSessionFactory(@Qualifier("writeDataSource") DataSource writeDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // ! Select SqlSessionFactory DataSource
        sqlSessionFactoryBean.setDataSource(writeDataSource);

        // Set base package alias path
        // sqlSessionFactoryBean.setTypeAliasesPackage("com.boardapp.boardapi");
        // ! MyBatis .xml mapper file locations
        sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResources("classpath:mapper/write/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "writeSqlSessionTemplate")
    SqlSessionTemplate writeSqlSessionTemplate(SqlSessionFactory writeSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(writeSqlSessionFactory);
    }
}
