@Test void testLoadBalancerSameNamespace(){
Assertions.assertNotNull(response);
Assertions.assertEquals("greeting",response);
}