@Test public void testGetSize(){
Assert.assertEquals(0,ClassUtils.getSize(null));
Assert.assertEquals(1,ClassUtils.getSize(list));
Assert.assertEquals(1,ClassUtils.getSize(map));
Assert.assertEquals(1,ClassUtils.getSize(array));
Assert.assertEquals(-1,ClassUtils.getSize(new Object()));
}