@Test public void testDeserializeBean(){
  Bean bean=new Bean();
  bean.setDate(new Date());
  bean.setStatus(PersonStatus.ENABLED);
  bean.setType(Bean.class);
  bean.setArray(new Phone[]{});
  Collection<Phone> collection=new ArrayList<Phone>();
  bean.setCollection(collection);
  Phone phone=new Phone();
  collection.add(phone);
  Map<String,FullAddress> map=new HashMap<String,FullAddress>();
  FullAddress address=new FullAddress();
  map.put("first",address);
  bean.setAddresses(map);
  JavaBeanDescriptor beanDescriptor=JavaBeanSerializeUtil.serialize(bean,JavaBeanAccessor.METHOD);
  Object deser=JavaBeanSerializeUtil.deserialize(beanDescriptor);
  Assertions.assertTrue(deser instanceof Bean);
  Bean deserBean=(Bean)deser;
  Assertions.assertEquals(bean.getDate(),deserBean.getDate());
  Assertions.assertEquals(bean.getStatus(),deserBean.getStatus());
  Assertions.assertEquals(bean.getType(),deserBean.getType());
  Assertions.assertEquals(bean.getCollection().size(),deserBean.getCollection().size());
  Assertions.assertEquals(bean.getCollection().iterator().next().getClass(),deserBean.getCollection().iterator().next().getClass());
  Assertions.assertEquals(bean.getAddresses().size(),deserBean.getAddresses().size());
  Assertions.assertEquals(bean.getAddresses().entrySet().iterator().next().getKey(),deserBean.getAddresses().entrySet().iterator().next().getKey());
  Assertions.assertEquals(bean.getAddresses().entrySet().iterator().next().getValue().getClass(),deserBean.getAddresses().entrySet().iterator().next().getValue().getClass());
}
