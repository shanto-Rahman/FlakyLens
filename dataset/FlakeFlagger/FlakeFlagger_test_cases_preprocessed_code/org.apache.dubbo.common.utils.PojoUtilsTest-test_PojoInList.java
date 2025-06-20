@Test public void test_PojoInList() throws Exception {
p.setAge(10);//IT
p.setName("jerry");//IT
assertEquals(10,parent.getAge());//IT
assertEquals("jerry",parent.getName());//IT
}