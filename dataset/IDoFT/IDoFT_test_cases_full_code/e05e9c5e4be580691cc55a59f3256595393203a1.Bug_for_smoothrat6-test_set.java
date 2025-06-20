public void test_set() throws Exception {
  Set<Object> set=new HashSet<Object>();
  set.add(3L);
  set.add(4L);
  Entity entity=new Entity();
  entity.setValue(set);
  String text=JSON.toJSONString(entity,SerializerFeature.WriteClassName);
  System.out.println(text);
  Assert.assertEquals("{\"@type\":\"com.alibaba.json.bvt.bug.Bug_for_smoothrat6$Entity\",\"value\":Set[3L,4L]}",text);
  Entity entity2=JSON.parseObject(text,Entity.class);
  Assert.assertEquals(set,entity2.getValue());
}
