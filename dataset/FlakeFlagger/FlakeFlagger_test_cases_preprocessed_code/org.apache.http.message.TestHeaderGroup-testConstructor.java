@Test public void testConstructor(){
Assert.assertNotNull(headergroup.getAllHeaders());
Assert.assertEquals(0,headergroup.getAllHeaders().length);
}