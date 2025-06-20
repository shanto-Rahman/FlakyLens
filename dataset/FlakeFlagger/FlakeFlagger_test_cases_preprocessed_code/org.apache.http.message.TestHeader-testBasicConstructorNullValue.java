@Test public void testBasicConstructorNullValue(){
Assert.assertEquals("name",header.getName());
Assert.assertEquals(null,header.getValue());
}