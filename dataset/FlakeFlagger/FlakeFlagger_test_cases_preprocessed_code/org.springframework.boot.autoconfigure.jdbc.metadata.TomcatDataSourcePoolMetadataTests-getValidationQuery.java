@Override public void getValidationQuery(){
assertEquals("SELECT FROM FOO",new TomcatDataSourcePoolMetadata(dataSource).getValidationQuery());
}