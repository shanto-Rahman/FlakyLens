@Test public void test(){
  final Jackson2Parser jacksonParser=getJackson2Parser();
  final Class<?> bean=DummyBean.class;
  final Model model=jacksonParser.parseModel(bean);
  Assert.assertTrue(model.getBeans().size() > 0);
  final BeanModel beanModel=model.getBeans().get(0);
  Assert.assertEquals("DummyBean",beanModel.getOrigin().getSimpleName());
  Assert.assertTrue(beanModel.getProperties().size() > 0);
  Assert.assertEquals("firstProperty",beanModel.getProperties().get(0).getName());
}
