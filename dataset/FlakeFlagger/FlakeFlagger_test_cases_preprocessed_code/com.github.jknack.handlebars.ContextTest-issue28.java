@Test public void issue28(){
assertEquals("root",root.get("this"));
assertEquals("child1",child1.get("this"));
assertEquals("child2",child2.get("this"));
}