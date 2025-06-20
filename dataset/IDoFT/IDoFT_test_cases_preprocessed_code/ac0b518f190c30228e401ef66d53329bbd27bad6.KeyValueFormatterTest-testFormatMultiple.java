@Test public void testFormatMultiple(){
Assert.assertTrue(("a=b&b=c").equals(KeyValueFormatter.format(params,true)) || ("b=c&a=b").equals(KeyValueFormatter.format(params,true)));
}