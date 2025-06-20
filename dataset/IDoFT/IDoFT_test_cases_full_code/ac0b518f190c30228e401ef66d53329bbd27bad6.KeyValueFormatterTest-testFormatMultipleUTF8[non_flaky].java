@Test public void testFormatMultipleUTF8(){
  HashMap<String,String> params=new HashMap<String,String>();
  params.put("a ","b, ");
  params.put("c","32626&");
  String s=KeyValueFormatter.format(params,true);
  Assert.assertTrue(("a =b%2C+&c=32626%26").equals(s) || ("c=32626%26&a =b%2C+").equals(s));
}
