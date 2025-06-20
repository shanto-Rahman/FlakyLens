@Test public void testListBindings() throws Exception {
assertEquals(5,list.size());
assertEquals(4,list.size());
if (binding.getName().equals("bar")) {
assertNotNull(bean);
assertEquals(value,bean);
}
}