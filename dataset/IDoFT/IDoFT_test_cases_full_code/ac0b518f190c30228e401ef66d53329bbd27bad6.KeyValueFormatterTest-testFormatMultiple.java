@Test public void testFormatMultiple(){
  HashMap<String,String> params=new HashMap<String,String>();
  params.put("a","b");
  params.put("a","b");
  params.put("b","c");
  Assert.assertTrue(("a=b&b=c").equals(KeyValueFormatter.format(params,true)) || ("b=c&a=b").equals(KeyValueFormatter.format(params,true)));
}
