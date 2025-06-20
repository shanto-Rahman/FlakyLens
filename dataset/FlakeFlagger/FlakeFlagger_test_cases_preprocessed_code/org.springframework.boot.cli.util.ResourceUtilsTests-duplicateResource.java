@Test public void duplicateResource() throws Exception {
URLClassLoader loader=new URLClassLoader(new URL[]//RO
assertEquals(1,urls.size());
assertTrue(urls.get(0).startsWith("file:"));
}