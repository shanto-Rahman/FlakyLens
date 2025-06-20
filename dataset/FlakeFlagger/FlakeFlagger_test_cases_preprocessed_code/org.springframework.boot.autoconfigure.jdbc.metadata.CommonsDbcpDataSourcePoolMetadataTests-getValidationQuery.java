@Override public void getValidationQuery(){
assertEquals("SELECT FROM FOO",new CommonsDbcpDataSourcePoolMetadata(dataSource).getValidationQuery());
}