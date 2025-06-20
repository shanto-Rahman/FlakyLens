public void testQueryByResourceNameLike(){
assertEquals("org/activiti/engine/test/repository/one%.bpmn20.xml",query.singleResult().getResourceName());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertEquals("org/activiti/engine/test/repository/two_.bpmn20.xml",query.singleResult().getResourceName());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}