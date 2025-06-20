@Test public void testRegisterUnregister() throws Exception {
Assert.assertEquals(3,handlers.size());
Assert.assertNotNull(h);
Assert.assertTrue(h1 == h);
Assert.assertNotNull(h);
Assert.assertTrue(h2 == h);
Assert.assertNotNull(h);
Assert.assertTrue(h3 == h);
Assert.assertNull(h);
Assert.assertEquals(2,handlers.size());
Assert.assertEquals(3,handlers.size());
Assert.assertNull(h);
Assert.assertNull(h);
Assert.assertNotNull(h);
Assert.assertTrue(h1 == h);
}