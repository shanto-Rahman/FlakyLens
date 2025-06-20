@Test public void testCreateSchema() throws SQLException {
  SchemaUtils.dropSchema(connectionSource,Schema.class,true);
  assertTrue(SchemaUtils.createSchema(connectionSource,Schema.class) > 0);
}
