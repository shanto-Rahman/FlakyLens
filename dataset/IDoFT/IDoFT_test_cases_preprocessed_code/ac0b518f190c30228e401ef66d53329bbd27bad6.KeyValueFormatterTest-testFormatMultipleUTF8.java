@Test public void testFormatMultipleUTF8(){
Assert.assertTrue(("a =b%2C+&c=32626%26").equals(KeyValueFormatter.format(params,true)) || ("c=32626%26&a =b%2C+").equals(KeyValueFormatter.format(params,true)));
}