@Test public void test() throws Exception {
Assert.assertNotNull(testBean.getDemoServiceFromAncestor());
Assert.assertNotNull(testBean.getDemoServiceFromParent());
Assert.assertNotNull(testBean.getDemoService());
Assert.assertEquals(testBean.getDemoServiceFromAncestor(),testBean.getDemoServiceFromParent());
Assert.assertEquals(testBean.getDemoService(),testBean.getDemoServiceFromParent());
Assert.assertEquals("annotation:Mercy",demoService.sayName("Mercy"));
}