@Test public void testFormatMultiple(){
Assert.assertTrue(("a=b&b=c").equals(s) || ("b=c&a=b").equals(s));
}