@Test public void testUpdateHeader(){
Assert.assertEquals(4,headergroup.getAllHeaders().length);
Assert.assertEquals("newvalue",headergroup.getFirstHeader("name2").getValue());
}