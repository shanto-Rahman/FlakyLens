@Test public void test(){
Assert.assertTrue(model.getBeans().size() > 0);
Assert.assertEquals("DummyBean",beanModel.getOrigin().getSimpleName());
Assert.assertTrue(beanModel.getProperties().size() > 0);
Assert.assertEquals("firstProperty",beanModel.getProperties().get(0).getName());
}