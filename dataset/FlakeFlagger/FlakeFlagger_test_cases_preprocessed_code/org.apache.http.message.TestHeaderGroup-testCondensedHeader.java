@Test public void testCondensedHeader(){
Assert.assertNull(headergroup.getCondensedHeader("name"));
Assert.assertEquals("value1, value2, value3",headergroup.getCondensedHeader("name").getValue());
Assert.assertEquals(header1,headergroup.getCondensedHeader("name"));
}