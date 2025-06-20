@Test public void testFormatMultiple(){
  HashMap<String,String> params=new HashMap<String,String>();
  params.put("a","b");
  params.put("a","b");
  params.put("b","c");
  String s=KeyValueFormatter.format(params,true);
  Assert.assertTrue(("a=b&b=c").equals(s) || ("b=c&a=b").equals(s));
}
