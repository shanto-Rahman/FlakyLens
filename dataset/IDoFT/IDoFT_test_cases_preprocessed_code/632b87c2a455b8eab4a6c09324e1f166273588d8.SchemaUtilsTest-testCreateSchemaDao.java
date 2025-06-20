@Test public void testCreateSchemaDao() throws SQLException {
assertTrue(SchemaUtils.createSchema(dao) > 0);
}