@Test(expected=SQLException.class) public void testDropSchemaThrow() throws SQLException {
  SchemaUtils.dropSchema(connectionSource,Schema.class,true);
  SchemaUtils.dropSchema(connectionSource,Schema.class,false);
}
