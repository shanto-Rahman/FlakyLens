/** 
 * Asserts that the SMDMethod annotation is also detected on the interfaces and superclasses when ignoreSMDMethodInterfaces is false
 */
public void testInterfaces(){
  Method[] smdMethodsA=JSONUtil.listSMDMethods(ClassA.class,false);
  assertEquals(3,smdMethodsA.length);
  assertEquals("getZ",smdMethodsA[0].getName());
  assertEquals("getX",smdMethodsA[1].getName());
  assertEquals("getB",smdMethodsA[2].getName());
  Method[] smdMethodsB=JSONUtil.listSMDMethods(ClassB.class,false);
  assertEquals(2,smdMethodsB.length);
  assertEquals("getX",smdMethodsB[0].getName());
  assertEquals("getB",smdMethodsB[1].getName());
  Method[] smdMethodsC=JSONUtil.listSMDMethods(ClassC.class,false);
  assertEquals(1,smdMethodsC.length);
  assertEquals("getX",smdMethodsC[0].getName());
}
