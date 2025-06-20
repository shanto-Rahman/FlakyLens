@Test public void testDropSchema() throws SQLException {
assertTrue(SchemaUtils.createSchema(connectionSource,Schema.class) > 0);
assertTrue(SchemaUtils.dropSchema(connectionSource,Schema.class,true) > 0);
assertTrue(SchemaUtils.createSchema(connectionSource,Schema.class) > 0);
assertTrue(SchemaUtils.dropSchema(connectionSource,Schema.class,true) > 0);
assertTrue(SchemaUtils.dropSchema(connectionSource,Schema.class,true) > 0);
}