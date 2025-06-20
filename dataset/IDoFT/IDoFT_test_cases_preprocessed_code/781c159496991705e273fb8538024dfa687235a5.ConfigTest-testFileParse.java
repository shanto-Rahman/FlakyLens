@Test public void testFileParse(){
assertNull(object);
assertNotNull(object);
Assert.assertEquals(globalBehavior.isMappingNullValue(),true);
Assert.assertEquals(globalBehavior.isMappingEmptyStrings(),true);
Assert.assertEquals(globalBehavior.isDebug(),false);
Assert.assertEquals(globalBehavior.isTrimStrings(),true);
Assert.assertEquals(beanBehavior.isMappingNullValue(),false);
Assert.assertEquals(beanBehavior.isDebug(),true);
Assert.assertEquals(beanBehavior.isMappingEmptyStrings(),true);
Assert.assertEquals(beanBehavior.isTrimStrings(),true);
Assert.assertEquals(fieldBehavior.isMappingNullValue(),true);
Assert.assertEquals(fieldBehavior.isDebug(),true);
Assert.assertEquals(fieldBehavior.isMappingEmptyStrings(),true);
Assert.assertEquals(fieldBehavior.isTrimStrings(),true);
}