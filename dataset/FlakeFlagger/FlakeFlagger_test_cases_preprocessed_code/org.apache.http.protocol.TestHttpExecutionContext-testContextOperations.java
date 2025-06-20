@Test public void testContextOperations(){
Assert.assertEquals("1",parentContext.getAttribute("param1"));
Assert.assertEquals("2",parentContext.getAttribute("param2"));
Assert.assertEquals(null,parentContext.getAttribute("param3"));
Assert.assertEquals("1",currentContext.getAttribute("param1"));
Assert.assertEquals("4",currentContext.getAttribute("param2"));
Assert.assertEquals("3",currentContext.getAttribute("param3"));
Assert.assertEquals(null,currentContext.getAttribute("param4"));
Assert.assertEquals("1",currentContext.getAttribute("param1"));
Assert.assertEquals("2",currentContext.getAttribute("param2"));
Assert.assertEquals(null,currentContext.getAttribute("param3"));
Assert.assertEquals(null,currentContext.getAttribute("param4"));
}