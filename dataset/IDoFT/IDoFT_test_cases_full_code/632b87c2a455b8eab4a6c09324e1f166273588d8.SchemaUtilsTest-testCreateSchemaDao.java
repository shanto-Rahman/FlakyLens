@Test public void testCreateSchemaDao() throws SQLException {
  Dao<Schema,Integer> dao=createDao(Schema.class,false);
  SchemaUtils.dropSchema(connectionSource,Schema.class,true);
  assertTrue(SchemaUtils.createSchema(dao) > 0);
}
