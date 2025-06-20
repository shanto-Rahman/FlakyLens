@Test public void test_Loop_pojo() throws Exception {
p.setAge(10);//IT
p.setName("jerry");//IT
c.setToy("haha");//IT
p.setChild(c);//IT
c.setParent(p);//IT
assertEquals(10,parent.getAge());//IT
assertEquals("jerry",parent.getName());//IT
assertEquals("haha",parent.getChild().getToy());//IT
assertSame(parent,parent.getChild().getParent());//IT
}