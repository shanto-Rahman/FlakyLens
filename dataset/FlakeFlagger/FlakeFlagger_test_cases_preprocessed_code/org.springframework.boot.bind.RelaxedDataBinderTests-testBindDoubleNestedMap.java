@SuppressWarnings("unchecked") @Test public void testBindDoubleNestedMap() throws Exception {
assertEquals(2,target.getNested().size());
assertEquals(3,((Map<String,Object>)target.getNested().get("bar")).size());
assertEquals("123",((Map<String,Object>)target.getNested().get("bar")).get("value"));
assertEquals("bar",target.getNested().get("foo"));
assertFalse(target.getNested().containsValue(target.getNested()));
}