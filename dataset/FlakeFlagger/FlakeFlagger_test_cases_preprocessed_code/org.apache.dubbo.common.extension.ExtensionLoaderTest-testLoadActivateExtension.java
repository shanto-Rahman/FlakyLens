@Test public void testLoadActivateExtension() throws Exception {
Assert.assertEquals(1,list.size());
Assert.assertTrue(list.get(0).getClass() == ActivateExt1Impl1.class);
Assert.assertEquals(1,list.size());
Assert.assertTrue(list.get(0).getClass() == GroupActivateExtImpl.class);
Assert.assertEquals(2,list.size());
Assert.assertTrue(list.get(0).getClass() == OldActivateExt1Impl2.class || list.get(0).getClass() == OldActivateExt1Impl3.class);
Assert.assertEquals(1,list.size());
Assert.assertTrue(list.get(0).getClass() == ValueActivateExtImpl.class);
Assert.assertEquals(2,list.size());
Assert.assertTrue(list.get(0).getClass() == OrderActivateExtImpl1.class);
Assert.assertTrue(list.get(1).getClass() == OrderActivateExtImpl2.class);
}