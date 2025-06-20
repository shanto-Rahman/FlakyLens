@Test public void assertGetDatabaseProductName() throws SQLException {
when(masterDataSource.getConnection()).thenReturn(masterConnection);
when(slaveDataSource1.getConnection()).thenReturn(slaveConnection1);
when(slaveDataSource2.getConnection()).thenReturn(slaveConnection2);
assertThat(((MasterSlaveDataSource)MasterSlaveDataSourceFactory.createDataSource(dataSourceMap,new MasterSlaveRuleConfiguration("ds","masterDataSource",Arrays.asList("slaveDataSource1","slaveDataSource2"),new LoadBalanceStrategyConfiguration("ROUND_ROBIN")),new Properties())).getDatabaseType(),instanceOf(H2DatabaseType.class));
}