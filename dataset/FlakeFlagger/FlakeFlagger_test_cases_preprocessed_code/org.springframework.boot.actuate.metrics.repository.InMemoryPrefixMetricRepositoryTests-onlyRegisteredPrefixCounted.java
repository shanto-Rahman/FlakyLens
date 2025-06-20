@Test public void onlyRegisteredPrefixCounted(){
assertEquals(1,names.size());
assertTrue(names.contains("foo.bar"));
}