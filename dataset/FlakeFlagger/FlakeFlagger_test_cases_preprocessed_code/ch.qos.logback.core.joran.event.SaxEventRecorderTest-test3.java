@Test public void test3() throws Exception {
assertTrue(statusChecker.getHighestLevel(0) == Status.INFO);
assertEquals(4,seList.size());
assertNotNull(attr);
assertEquals("1",attr.getValue("increment"));
}