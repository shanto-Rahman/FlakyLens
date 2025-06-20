@Test public void test() throws Exception {
assertEquals(4,das.size());
if (da instanceof TestDA2) {
assertEquals("myString",da2.getTwo());
if (da instanceof TestDA3) {
assertNotNull(da3.getList());
assertTrue(da3.getList().contains("One"));
assertTrue(da3.getList().contains("Two"));
if (da instanceof TestDA4) {
assertEquals(true,da4.isBool());
assertNotNull(da4.getMap());
assertEquals(1,(int)da4.getMap().get("One"));
assertEquals(3,(int)da4.getMap().get("Three"));
if (da instanceof TestDA1) {
}
}
}
}
assertTrue(da1Found);
assertTrue(da2Found);
assertTrue(da3Found);
assertTrue(da4Found);
if (is != null) {
}
}