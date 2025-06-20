@Test public void testFirstLastHeaders(){
Assert.assertNull(headergroup.getFirstHeader("whatever"));
Assert.assertNull(headergroup.getLastHeader("whatever"));
Assert.assertEquals("value1",headergroup.getFirstHeader("name").getValue());
Assert.assertEquals("value3",headergroup.getLastHeader("name").getValue());
}