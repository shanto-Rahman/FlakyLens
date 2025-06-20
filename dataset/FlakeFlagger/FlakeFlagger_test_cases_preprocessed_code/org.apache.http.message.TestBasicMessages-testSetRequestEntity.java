@Test public void testSetRequestEntity(){
Assert.assertNull(request.getEntity());
Assert.assertTrue(entity == request.getEntity());
}