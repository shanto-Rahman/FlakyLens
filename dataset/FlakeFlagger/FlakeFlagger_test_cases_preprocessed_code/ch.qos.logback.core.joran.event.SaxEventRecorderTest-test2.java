@Test public void test2() throws Exception {
assertTrue(statusChecker.getHighestLevel(0) == Status.INFO);
assertEquals(3,seList.size());
assertEquals("xxx & yyy",be.getText());
}