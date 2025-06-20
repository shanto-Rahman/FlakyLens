@Test public void testNestedTransactions() throws Exception {
assertEquals(1,dao.create(foo));
assertNotNull(result);
fail("Should have thrown");
assertNotNull(result);
}