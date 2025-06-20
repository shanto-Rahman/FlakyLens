@Test public void testFormatMultipleUTF8(){
Assert.assertTrue(("a =b%2C+&c=32626%26").equals(s) || ("c=32626%26&a =b%2C+").equals(s));
}