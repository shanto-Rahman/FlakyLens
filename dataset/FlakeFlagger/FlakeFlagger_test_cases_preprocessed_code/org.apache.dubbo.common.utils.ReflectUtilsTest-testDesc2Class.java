@Test public void testDesc2Class() throws Exception {
assertEquals(void.class,ReflectUtils.desc2class("V"));
assertEquals(boolean.class,ReflectUtils.desc2class("Z"));
assertEquals(boolean[].class,ReflectUtils.desc2class("[Z"));
assertEquals(byte.class,ReflectUtils.desc2class("B"));
assertEquals(char.class,ReflectUtils.desc2class("C"));
assertEquals(double.class,ReflectUtils.desc2class("D"));
assertEquals(float.class,ReflectUtils.desc2class("F"));
assertEquals(int.class,ReflectUtils.desc2class("I"));
assertEquals(long.class,ReflectUtils.desc2class("J"));
assertEquals(short.class,ReflectUtils.desc2class("S"));
assertEquals(String.class,ReflectUtils.desc2class("Ljava.lang.String;"));
assertEquals(int[][].class,ReflectUtils.desc2class(ReflectUtils.getDesc(int[][].class)));
assertEquals(ReflectUtilsTest[].class,ReflectUtils.desc2class(ReflectUtils.getDesc(ReflectUtilsTest[].class)));
assertSame(cs,ReflectUtils.desc2classArray(desc));
assertSame(cs,ReflectUtils.desc2classArray(desc));
assertSame(cs,ReflectUtils.desc2classArray(desc));
}