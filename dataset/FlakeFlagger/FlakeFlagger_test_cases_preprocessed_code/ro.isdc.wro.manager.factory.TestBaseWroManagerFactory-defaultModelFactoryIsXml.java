@Test public void defaultModelFactoryIsXml(){
Assert.assertEquals(XmlModelFactory.class,modelFactory.getClass());
}