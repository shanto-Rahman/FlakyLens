@Test public void testCreateIfNotExists() throws SQLException {
assertTrue(SchemaUtils.createSchemaIfNotExists(connectionSource,Schema.class) > 0);
assertTrue(SchemaUtils.createSchemaIfNotExists(connectionSource,SCHEMA_NAME) > 0);
}