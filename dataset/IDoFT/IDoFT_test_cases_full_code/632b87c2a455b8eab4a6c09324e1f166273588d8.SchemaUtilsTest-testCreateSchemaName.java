@Test public void testCreateSchemaName() throws SQLException {
  SchemaUtils.dropSchema(connectionSource,SCHEMA_NAME,true);
  assertTrue(SchemaUtils.createSchema(connectionSource,SCHEMA_NAME) > 0);
}
