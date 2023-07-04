//package board.demo.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DBConfig {
//
//    @Bean(name = "slaveDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    DataSource slaveDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "slaveSqlSessionFactory")
//    SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
//        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//
//        sqlSessionFactoryBean.setDataSource(slaveDataSource);
//
//        // MyBatis XML mapper resource file path
//        sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResources("classpath:mybatis/mapper/slave/slave-mapper.xml"));
//
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean(name = "slaveSqlSessionTemplate")
//    SqlSessionTemplate slaveSqlSessionTemplate(SqlSessionFactory slaveSqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(slaveSqlSessionFactory);
//    }
//}
