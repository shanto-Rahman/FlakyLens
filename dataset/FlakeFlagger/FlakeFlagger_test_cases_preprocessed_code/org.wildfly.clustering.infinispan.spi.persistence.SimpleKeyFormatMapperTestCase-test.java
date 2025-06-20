@Test public void test(){
Assert.assertSame(formatted,mapper.getStringMapping(key));
Assert.assertSame(key,mapper.getKeyMapping(formatted));
Assert.assertTrue(mapper.isSupportedType(Object.class));
Assert.assertFalse(mapper.isSupportedType(Integer.class));
}