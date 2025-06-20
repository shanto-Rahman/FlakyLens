public void test1(){
assertEquals("x",x.getName());
assertEquals(clc.getRootLogger(),x.parent);
assertEquals("a.b.c",abc.getName());
assertEquals(Level.DEBUG,abc.getEffectiveLevel());
}