@Test public void createValidModel(){
Assert.assertNotNull(model);
Assert.assertEquals(Arrays.asList("g1","g2"),new WroModelInspector(model).getGroupNames());
}