@Test void testLoadBalancerSameNamespace(){
  createTestData("service-a","test");
  String response=restTemplate.getForObject("http://service-a/greeting",String.class);
  Assertions.assertNotNull(response);
  Assertions.assertEquals("greeting",response);
}
