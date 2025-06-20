@Test public void testGenerateSchema(){
assertEquals("0",field.getType().getMetadataString(CassandraRowMapperFn.KEY_ORDER_METADATA_KEY));
}