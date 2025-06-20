@Test public void testGetBeanPropertyReadMethods() throws Exception {
assertThat(map.size(),is(2));
assertThat(map,hasKey("set"));
assertThat(map,hasKey("property"));
if (!m.isAccessible()) {
fail();
}
}