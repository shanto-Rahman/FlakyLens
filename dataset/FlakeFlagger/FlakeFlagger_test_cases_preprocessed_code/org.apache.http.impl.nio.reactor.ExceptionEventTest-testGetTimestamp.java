@Test public void testGetTimestamp(){
Assert.assertNotNull(ee.getTimestamp());
Assert.assertEquals(new Date(1234567890L),ee.getTimestamp());
}