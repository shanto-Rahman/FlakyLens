@Test public void testSetHeaders(){
Assert.assertEquals(2,headergroup.getAllHeaders().length);
Assert.assertEquals(0,headergroup.getHeaders("name1").length);
Assert.assertFalse(headergroup.containsHeader("name1"));
Assert.assertEquals(1,headergroup.getHeaders("name2").length);
Assert.assertTrue(headergroup.containsHeader("name2"));
Assert.assertEquals(1,headergroup.getHeaders("name3").length);
Assert.assertTrue(headergroup.containsHeader("name3"));
Assert.assertEquals(0,headergroup.getAllHeaders().length);
}