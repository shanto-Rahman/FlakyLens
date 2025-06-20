@Test public void testBasicConstructor(){
Assert.assertEquals("name",header.getName());
Assert.assertEquals("value",header.getValue());
Assert.assertSame(buf,header.getBuffer());
Assert.assertEquals(5,header.getValuePos());
}