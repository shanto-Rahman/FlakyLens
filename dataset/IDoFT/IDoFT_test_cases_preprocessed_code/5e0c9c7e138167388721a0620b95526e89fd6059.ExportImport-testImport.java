@Test public void testImport() throws Exception {
Assert.assertNotNull(db.getDatasource("speed"));
Assert.assertNotNull(db.getDatasource("weight"));
}