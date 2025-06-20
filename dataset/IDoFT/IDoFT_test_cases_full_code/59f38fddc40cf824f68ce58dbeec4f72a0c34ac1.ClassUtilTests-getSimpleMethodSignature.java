@Test public void getSimpleMethodSignature() throws Exception {
  Method m1=MyClass.class.getDeclaredMethod("func");
  Method m2=MyClass.class.getDeclaredMethod("func",String.class,long[].class);
  assertMethod(null,null,false,false,false,false);
  assertMethod("public final void ClassUtilTests.MyClass.func()",m1,true,true,true,true);
  assertMethod("private static int ClassUtilTests.MyClass.func(String, long[]) throws IOException, RuntimeException",m2,true,true,true,true);
  assertMethod("public final void ClassUtilTests.MyClass.func()",m1,true,true,true,true);
  assertMethod("private static int ClassUtilTests.MyClass.func(String, long[]) throws IOException, RuntimeException",m2,true,true,true,true);
  assertMethod("void ClassUtilTests.MyClass.func()",m1,false,true,true,true);
  assertMethod("int ClassUtilTests.MyClass.func(String, long[]) throws IOException, RuntimeException",m2,false,true,true,true);
  assertMethod("ClassUtilTests.MyClass.func()",m1,false,false,true,true);
  assertMethod("ClassUtilTests.MyClass.func(String, long[]) throws IOException, RuntimeException",m2,false,false,true,true);
  assertMethod("func()",m1,false,false,false,true);
  assertMethod("func(String, long[]) throws IOException, RuntimeException",m2,false,false,false,true);
  assertMethod("func()",m1,false,false,false,false);
  assertMethod("func(String, long[])",m2,false,false,false,false);
  assertEquals(null,ClassUtil.getSimpleMethodSignature(null));
  assertEquals("func()",ClassUtil.getSimpleMethodSignature(m1));
  assertEquals("func(String, long[])",ClassUtil.getSimpleMethodSignature(m2));
  assertEquals(null,ClassUtil.getSimpleMethodSignature(null,true));
  assertEquals("ClassUtilTests.MyClass.func()",ClassUtil.getSimpleMethodSignature(m1,true));
  assertEquals("func()",ClassUtil.getSimpleMethodSignature(m1,false));
  assertEquals("ClassUtilTests.MyClass.func(String, long[])",ClassUtil.getSimpleMethodSignature(m2,true));
  assertEquals("func(String, long[])",ClassUtil.getSimpleMethodSignature(m2,false));
}
