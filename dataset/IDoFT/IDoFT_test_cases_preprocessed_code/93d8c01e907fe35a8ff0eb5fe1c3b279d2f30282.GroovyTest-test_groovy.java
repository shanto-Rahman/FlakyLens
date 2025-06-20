public void test_groovy() throws Exception {
ClassLoader parent=Thread.currentThread().getContextClassLoader();
Assert.assertEquals(a.getProperty("id"),aa.getProperty("id"));
Assert.assertEquals(b.getProperty("id"),bb.getProperty("id"));
Assert.assertEquals(b.getProperty("name"),bb.getProperty("name"));
}