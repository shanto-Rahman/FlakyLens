@Test public void testDeserializeBean(){
Assertions.assertTrue(deser instanceof Bean);
Assertions.assertEquals(bean.getDate(),deserBean.getDate());
Assertions.assertEquals(bean.getStatus(),deserBean.getStatus());
Assertions.assertEquals(bean.getType(),deserBean.getType());
Assertions.assertEquals(bean.getCollection().size(),deserBean.getCollection().size());
Assertions.assertEquals(bean.getCollection().iterator().next().getClass(),deserBean.getCollection().iterator().next().getClass());
Assertions.assertEquals(bean.getAddresses().size(),deserBean.getAddresses().size());
Assertions.assertEquals(bean.getAddresses().entrySet().iterator().next().getKey(),deserBean.getAddresses().entrySet().iterator().next().getKey());
Assertions.assertEquals(bean.getAddresses().entrySet().iterator().next().getValue().getClass(),deserBean.getAddresses().entrySet().iterator().next().getValue().getClass());
}