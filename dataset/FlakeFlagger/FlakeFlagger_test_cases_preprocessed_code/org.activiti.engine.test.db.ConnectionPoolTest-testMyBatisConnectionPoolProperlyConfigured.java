public void testMyBatisConnectionPoolProperlyConfigured(){
assertEquals(maxActive,config.getJdbcMaxActiveConnections());
assertEquals(maxIdle,config.getJdbcMaxIdleConnections());
assertEquals(maxCheckoutTime,config.getJdbcMaxCheckoutTime());
assertEquals(maxWaitTime,config.getJdbcMaxWaitTime());
assertTrue(datasource instanceof PooledDataSource);
assertEquals(maxActive,pooledDataSource.getPoolMaximumActiveConnections());
assertEquals(maxIdle,pooledDataSource.getPoolMaximumIdleConnections());
assertEquals(maxCheckoutTime,pooledDataSource.getPoolMaximumCheckoutTime());
assertEquals(maxWaitTime,pooledDataSource.getPoolTimeToWait());
}