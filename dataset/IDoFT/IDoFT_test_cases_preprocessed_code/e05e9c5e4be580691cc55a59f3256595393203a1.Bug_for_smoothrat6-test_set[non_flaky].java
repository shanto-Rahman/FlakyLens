public void test_set() throws Exception {
entity.setValue(set);//IT
Assert.assertEquals("{\"@type\":\"com.alibaba.json.bvt.bug.Bug_for_smoothrat6$Entity\",\"value\":Set[3L,4L]}",text);
Assert.assertEquals(set,entity2.getValue());//IT
}