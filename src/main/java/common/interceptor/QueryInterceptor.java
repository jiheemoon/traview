package common.interceptor;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JHMoon
 * 
 * type : Executor.class, ParameterHandler.class, ResultSetHandler.class, StatementHandler.class
 * 
 */
@Intercepts({ 
    @Signature(type = StatementHandler.class, method ="update", args = {Statement.class}),
    @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}) 
//    @Signature(type = StatementHandler.class, method ="update", args = {MappedStatement.class, Object.class}), //queryId 출력 가능
//    @Signature(type = StatementHandler.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}) //queryId 출력 가능

})

public class QueryInterceptor implements Interceptor{ // invoke.process충돌 : DAO호출 불가
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler handler = (StatementHandler) invocation.getTarget();

        MetaObject metaStatementHandler = SystemMetaObject.forObject(handler);
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        String queryId = mappedStatement.getId(); // Id 추출

        logger.error("=============================================================================================");
//      String queryId = ((MappedStatement)invocation.getArgs()[0]).getId(); // Query Id
        logger.error("Query ID : \n" + queryId);
        
//        Object param = invocation.getArgs()[1]; //Query Parameter
//        String queryString = ((MappedStatement)invocation.getArgs()[0]).getBoundSql(param).getSql(); //Query String
//        System.err.println("Query String : \n" + queryString);
        String sql = bindSql(handler); // SQL 추출
        logger.error("Query String : \n" + sql);
        logger.error("=============================================================================================");
        
        return invocation.proceed(); // 쿼리 실행
    }
    
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    
    /**
     * <pre>
     * bindSql
     * <pre>
     *
     * @param boundSql
     * @param sql
     * @param param
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("rawtypes")
    private String bindSql(StatementHandler handler) throws NoSuchFieldException, IllegalAccessException {
        BoundSql boundSql = handler.getBoundSql();

        // 쿼리문을 가져온다(이 상태에서의 쿼리는 값이 들어갈 부분에 ?가 있다)
        String sql = boundSql.getSql();

        // 쿼리실행시 맵핑되는 파라미터를 구한다
        Object param = handler.getParameterHandler().getParameterObject();
        
        // 바인딩 파라미터가 없으면
        if (param == null) {
            sql = sql.replaceFirst("\\?", "''");
            
        } else {
            // 해당 파라미터의 클래스가 Integer, Long, Float, Double 클래스일 경우
            if (param instanceof Integer || param instanceof Long || param instanceof Float || param instanceof Double) {
                sql = sql.replaceFirst("\\?", param.toString());
            }
            // 해당 파라미터의 클래스가 String인 경우
            else if (param instanceof String) {
                sql = sql.replaceFirst("\\?", "'" + param + "'");
            }
            // 해당 파라미터의 클래스가 Map인 경우
            else if (param instanceof Map) {
                List<ParameterMapping> paramMapping = boundSql.getParameterMappings();
                
                for (ParameterMapping mapping : paramMapping) {
                    String propValue = mapping.getProperty();
                    Object value = ((Map) param).get(propValue);
                    if (value instanceof String) {
                        sql = sql.replaceFirst("\\?", "'" + value + "'");
                    } else {
                        sql = sql.replaceFirst("\\?", value.toString());
                    }
                }
            }
            // 해당 파라미터의 클래스가 사용자 정의 클래스인 경우
            else {
                List<ParameterMapping> paramMapping = boundSql.getParameterMappings();
                Class<? extends Object> paramClass = param.getClass();
    
                for (ParameterMapping mapping : paramMapping) {
                    String propValue = mapping.getProperty();
                    Field field = paramClass.getDeclaredField(propValue);
                    field.setAccessible(true);
                    Class<?> javaType = mapping.getJavaType();
                    
                    if (String.class == javaType) {
                        sql = sql.replaceFirst("\\?", "'" + field.get(param) + "'");
                    } else {
                        sql = sql.replaceFirst("\\?", field.get(param).toString());
                    }
                }
            }
            
        }
        // return sql
        return sql;
    }

    
}
