@Test public void getSimpleMethodSignature() throws Exception {
assertEquals(null,ClassUtil.getSimpleMethodSignature(null));
assertEquals("func()",ClassUtil.getSimpleMethodSignature(m1));
assertEquals("func(String, long[])",ClassUtil.getSimpleMethodSignature(m2));
assertEquals(null,ClassUtil.getSimpleMethodSignature(null,true));
assertEquals("ClassUtilTests.MyClass.func()",ClassUtil.getSimpleMethodSignature(m1,true));
assertEquals("func()",ClassUtil.getSimpleMethodSignature(m1,false));
assertEquals("ClassUtilTests.MyClass.func(String, long[])",ClassUtil.getSimpleMethodSignature(m2,true));
assertEquals("func(String, long[])",ClassUtil.getSimpleMethodSignature(m2,false));
}