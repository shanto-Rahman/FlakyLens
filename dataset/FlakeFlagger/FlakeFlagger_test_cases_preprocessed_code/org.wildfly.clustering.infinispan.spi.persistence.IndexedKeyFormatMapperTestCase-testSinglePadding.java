@Test public void testSinglePadding(){
Assert.assertTrue(mapper.isSupportedType(Type.TYPE00.getClass()));
Assert.assertTrue(mapper.isSupportedType(Type.TYPE15.getClass()));
Assert.assertFalse(mapper.isSupportedType(Type.TYPE16.getClass()));
Assert.assertFalse(mapper.isSupportedType(Type.TYPE17.getClass()));
Assert.assertSame(Type.TYPE00,mapper.getKeyMapping(result));
Assert.assertEquals("0TYPE00",result);
Assert.assertSame(Type.TYPE15,mapper.getKeyMapping(result));
Assert.assertEquals("FTYPE15",result);
}