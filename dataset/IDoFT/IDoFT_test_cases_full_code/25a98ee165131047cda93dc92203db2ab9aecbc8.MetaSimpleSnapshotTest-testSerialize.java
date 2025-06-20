@Test public void testSerialize(){
  try {
    Map<PartialPath,Long> storageGroupTTLMap=new HashMap<>();
    Map<String,User> userMap=new HashMap<>();
    Map<String,Role> roleMap=new HashMap<>();
    Map<String,Template> templateMap=new HashMap<>();
    PartitionTable partitionTable=TestUtils.getPartitionTable(10);
    long lastLogIndex=10;
    long lastLogTerm=5;
    for (int i=0; i < 10; i++) {
      PartialPath partialPath=new PartialPath("root.ln.sg1");
      storageGroupTTLMap.put(partialPath,(long)i);
    }
    for (int i=0; i < 5; i++) {
      String userName="user_" + i;
      User user=new User(userName,"password_" + i);
      userMap.put(userName,user);
    }
    for (int i=0; i < 10; i++) {
      String roleName="role_" + i;
      Role role=new Role(roleName);
      roleMap.put(roleName,role);
    }
    CreateTemplatePlan createTemplatePlan=CreateTemplatePlanUtil.getCreateTemplatePlan();
    for (int i=0; i < 10; i++) {
      String templateName="template_" + i;
      Template template=new Template(createTemplatePlan);
      templateMap.put(templateName,template);
    }
    MetaSimpleSnapshot metaSimpleSnapshot=new MetaSimpleSnapshot(storageGroupTTLMap,userMap,roleMap,templateMap,partitionTable.serialize());
    metaSimpleSnapshot.setLastLogIndex(lastLogIndex);
    metaSimpleSnapshot.setLastLogTerm(lastLogTerm);
    ByteBuffer buffer=metaSimpleSnapshot.serialize();
    MetaSimpleSnapshot newSnapshot=new MetaSimpleSnapshot();
    newSnapshot.deserialize(buffer);
    assertEquals(storageGroupTTLMap,newSnapshot.getStorageGroupTTLMap());
    assertEquals(userMap,newSnapshot.getUserMap());
    assertEquals(roleMap,newSnapshot.getRoleMap());
    assertEquals(templateMap,newSnapshot.getTemplateMap());
    assertEquals(partitionTable.serialize(),newSnapshot.getPartitionTableBuffer());
    assertEquals(lastLogIndex,newSnapshot.getLastLogIndex());
    assertEquals(lastLogTerm,newSnapshot.getLastLogTerm());
    assertEquals(metaSimpleSnapshot,newSnapshot);
  }
 catch (  Exception e) {
    Assert.fail(e.getMessage());
  }
}
