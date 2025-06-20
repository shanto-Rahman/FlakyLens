@Test public void testSubstring(){
Assert.assertEquals(5,buffer.indexOf(':'));
Assert.assertEquals(" name",buffer.substring(0,5));
Assert.assertEquals("  value    ",buffer.substring(6,buffer.length()));
Assert.assertEquals("name",buffer.substringTrimmed(0,5));
Assert.assertEquals("value",buffer.substringTrimmed(6,buffer.length()));
Assert.assertEquals("",buffer.substringTrimmed(13,buffer.length()));
}