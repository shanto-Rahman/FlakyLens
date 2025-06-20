@Test public void testBasics() throws Exception {
Assert.assertEquals("route1",entry1.getRoute());
Assert.assertTrue(now >= entry1.getCreated());
Assert.assertEquals(entry1.getValidUnit(),entry1.getExpiry());
Assert.assertEquals(entry1.getCreated() + 10L,entry1.getValidUnit());
}