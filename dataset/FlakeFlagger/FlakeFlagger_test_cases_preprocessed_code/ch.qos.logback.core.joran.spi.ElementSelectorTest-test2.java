@Test public void test2(){
assertEquals(2,p.size());
assertEquals("b",p.peekLast());
assertEquals("a",p.get(0));
assertEquals("b",p.get(1));
}