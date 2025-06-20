@Test public void test() throws IOException {
assertNotNull(cp.getAllResources());
assertTrue(cp.getAllResources().size() > 0);
assertEquals(1,count);
}