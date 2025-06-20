@Test public void testDefaultValueWithAliasValue(){
assertEquals(33,record.getValue("foo"));
assertEquals(33,record.getValue("bar"));
assertEquals(33,record.getValue("baz"));
}