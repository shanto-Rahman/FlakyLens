@Test public void testMultiHeaderSameLine(){
Assert.assertEquals("The two header values must be equal","value0",elem.getName());
Assert.assertEquals("The two header values must be equal","value1",elem.getName());
Assert.assertEquals("The two header values must be equal","cookie1",elem.getName());
Assert.assertEquals("The two header values must be equal","1",elem.getValue());
Assert.assertEquals("The two header values must be equal","cookie2",elem.getName());
Assert.assertEquals("The two header values must be equal","2",elem.getValue());
}