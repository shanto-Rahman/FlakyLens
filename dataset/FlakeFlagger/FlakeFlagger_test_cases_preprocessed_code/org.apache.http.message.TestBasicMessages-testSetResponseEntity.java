@Test public void testSetResponseEntity(){
Assert.assertNull(response.getEntity());
Assert.assertTrue(entity == response.getEntity());
}