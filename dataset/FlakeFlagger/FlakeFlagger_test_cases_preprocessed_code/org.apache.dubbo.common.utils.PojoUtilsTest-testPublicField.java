@Test public void testPublicField() throws Exception {
parent.setEmail("securityemail@host.com");//IT
parent.setChild(child);//IT
child.setAge(20);//IT
child.setParent(parent);//IT
Assert.assertEquals(parent.gender,realizedParent.gender);
Assert.assertEquals(child.gender,parent.getChild().gender);//IT
Assert.assertEquals(child.age,realizedParent.getChild().getAge());//IT
Assert.assertEquals(parent.getEmail(),realizedParent.getEmail());//IT
Assert.assertNull(realizedParent.email);
}