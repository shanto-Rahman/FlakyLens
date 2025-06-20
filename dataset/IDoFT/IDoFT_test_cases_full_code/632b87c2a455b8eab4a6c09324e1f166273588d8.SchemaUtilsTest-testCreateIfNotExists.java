@Test public void testCreateIfNotExists() throws SQLException {
  SchemaUtils.dropSchema(connectionSource,Schema.class,true);
  SchemaUtils.dropSchema(connectionSource,SCHEMA_NAME,true);
  assertTrue(SchemaUtils.createSchemaIfNotExists(connectionSource,Schema.class) > 0);
  assertTrue(SchemaUtils.createSchemaIfNotExists(connectionSource,SCHEMA_NAME) > 0);
}
