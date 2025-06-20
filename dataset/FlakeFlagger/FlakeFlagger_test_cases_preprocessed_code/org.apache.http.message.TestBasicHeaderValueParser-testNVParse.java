@Test public void testNVParse(){
Assert.assertEquals("test",param.getName());
Assert.assertEquals(null,param.getValue());
Assert.assertEquals("test",param.getName());
Assert.assertEquals("stuff",param.getValue());
Assert.assertEquals("test",param.getName());
Assert.assertEquals("stuff",param.getValue());
Assert.assertEquals("test",param.getName());
Assert.assertEquals("stuff",param.getValue());
Assert.assertEquals("test",param.getName());
Assert.assertEquals("  stuff\\\"",param.getValue());
Assert.assertEquals("test",param.getName());
Assert.assertEquals(null,param.getValue());
Assert.assertEquals("",param.getName());
Assert.assertEquals(null,param.getValue());
Assert.assertEquals("",param.getName());
Assert.assertEquals("stuff",param.getValue());
}