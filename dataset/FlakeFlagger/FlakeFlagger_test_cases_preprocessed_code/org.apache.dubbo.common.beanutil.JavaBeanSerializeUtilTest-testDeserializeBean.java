@Test public void testDeserializeBean() throws Exception {
Assert.assertTrue(deser instanceof Bean);
Assert.assertEquals(bean.getDate(),deserBean.getDate());
Assert.assertEquals(bean.getStatus(),deserBean.getStatus());
Assert.assertEquals(bean.getType(),deserBean.getType());
Assert.assertEquals(bean.getCollection().size(),deserBean.getCollection().size());
Assert.assertEquals(bean.getCollection().iterator().next().getClass(),deserBean.getCollection().iterator().next().getClass());
Assert.assertEquals(bean.getAddresses().size(),deserBean.getAddresses().size());
Assert.assertEquals(bean.getAddresses().entrySet().iterator().next().getKey(),deserBean.getAddresses().entrySet().iterator().next().getKey());
Assert.assertEquals(bean.getAddresses().entrySet().iterator().next().getValue().getClass(),deserBean.getAddresses().entrySet().iterator().next().getValue().getClass());
}