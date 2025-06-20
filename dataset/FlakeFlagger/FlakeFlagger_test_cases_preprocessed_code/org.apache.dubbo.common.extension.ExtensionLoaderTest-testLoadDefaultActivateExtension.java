@Test public void testLoadDefaultActivateExtension() throws Exception {
Assert.assertEquals(2,list.size());
Assert.assertTrue(list.get(0).getClass() == OrderActivateExtImpl1.class);
Assert.assertTrue(list.get(1).getClass() == ActivateExt1Impl1.class);
Assert.assertEquals(2,list.size());
Assert.assertTrue(list.get(0).getClass() == ActivateExt1Impl1.class);
Assert.assertTrue(list.get(1).getClass() == OrderActivateExtImpl1.class);
}