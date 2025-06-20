@Test public void testPublicField() throws Exception {
parent.setEmail("securityemail@host.com");//IT
parent.setChild(child);//IT
child.setAge(20);//IT
child.setParent(parent);//IT
Assertions.assertEquals(parent.gender,realizedParent.gender);
Assertions.assertEquals(child.gender,parent.getChild().gender);//IT
Assertions.assertEquals(child.age,realizedParent.getChild().getAge());//IT
Assertions.assertEquals(parent.getEmail(),realizedParent.getEmail());//IT
Assertions.assertNull(realizedParent.email);
}