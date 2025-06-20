@Override public void getValidationQuery(){
assertEquals("SELECT FROM FOO",new HikariDataSourcePoolMetadata(dataSource).getValidationQuery());
}