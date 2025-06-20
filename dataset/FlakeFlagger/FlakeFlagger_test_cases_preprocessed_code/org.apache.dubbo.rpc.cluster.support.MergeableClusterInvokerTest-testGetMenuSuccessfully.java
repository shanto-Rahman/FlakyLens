@Test public void testGetMenuSuccessfully() throws Exception {
if ("getUrl".equals(method.getName())) {
}
if ("getInterface".equals(method.getName())) {
}
if ("invoke".equals(method.getName())) {
}
if ("getUrl".equals(method.getName())) {
}
if ("getInterface".equals(method.getName())) {
}
if ("invoke".equals(method.getName())) {
}
Assert.assertTrue(result.getValue() instanceof Menu);
assertEquals(expected.keySet(),menu.getMenus().keySet());
assertEquals(values1,values2);
}