@Test public void test_LoopPojoInList() throws Exception {
p.setAge(10);//IT
p.setName("jerry");//IT
c.setToy("haha");//IT
p.setChild(c);//IT
c.setParent(p);//IT
assertEquals(10,parent.getAge());//IT
assertEquals("jerry",parent.getName());//IT
assertEquals("haha",parent.getChild().getToy());//IT
assertSame(parent,parent.getChild().getParent());//IT
assertTrue(((List)objects[0]).get(0) instanceof Parent);
}