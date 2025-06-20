@Test public void envEndpointNotHidden(){
assertNotNull(body);
assertTrue("Wrong body: \n" + body,body.contains("spring-boot-actuator"));
}