@Test public void testGetBeanPropertyFields() throws Exception {
assertThat(map.size(),is(2));
assertThat(map,hasKey("set"));
assertThat(map,hasKey("property"));
if (!f.isAccessible()) {
fail();
}
}