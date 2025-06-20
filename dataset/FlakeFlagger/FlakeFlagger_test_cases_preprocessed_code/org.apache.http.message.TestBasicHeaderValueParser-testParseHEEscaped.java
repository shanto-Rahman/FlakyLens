@Test public void testParseHEEscaped(){
Assert.assertEquals(3,elements.length);
Assert.assertEquals("test1",elements[0].getName());
Assert.assertEquals("\\\"stuff\\\"",elements[0].getValue());
Assert.assertEquals("test2",elements[1].getName());
Assert.assertEquals("\\\\",elements[1].getValue());
Assert.assertEquals("test3",elements[2].getName());
Assert.assertEquals("stuff, stuff",elements[2].getValue());
}