@Test public void testPropertyBasedEnvEntry() throws Exception {
assertEquals("foo" + System.getProperty("file.separator") + "bar",bean.getValue());
}