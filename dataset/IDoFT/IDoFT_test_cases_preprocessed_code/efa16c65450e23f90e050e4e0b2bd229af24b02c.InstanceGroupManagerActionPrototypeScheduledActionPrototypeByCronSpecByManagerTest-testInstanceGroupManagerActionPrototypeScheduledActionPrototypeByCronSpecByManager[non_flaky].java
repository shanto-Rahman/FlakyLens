@Test public void testInstanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManager() throws Throwable {
assertEquals(instanceGroupManagerScheduledActionManagerPrototypeModel.maxMembershipCount(),Long.valueOf("10"));
assertEquals(instanceGroupManagerScheduledActionManagerPrototypeModel.minMembershipCount(),Long.valueOf("10"));
assertEquals(instanceGroupManagerScheduledActionManagerPrototypeModel.id(),"1e09281b-f177-46fb-baf1-bc152b2e391a");
assertEquals(instanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManagerModel.name(),"my-instance-group-manager-action");
assertEquals(instanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManagerModel.cronSpec(),"*/5 1,2,3 * * *");
assertEquals(instanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManagerModel.manager(),instanceGroupManagerScheduledActionManagerPrototypeModel);
assertTrue(instanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManagerModelNew instanceof InstanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManager);
assertEquals(instanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManagerModelNew.name(),"my-instance-group-manager-action");
assertEquals(instanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManagerModelNew.cronSpec(),"*/5 1,2,3 * * *");
assertEquals(JsonParser.parseString(instanceGroupManagerActionPrototypeScheduledActionPrototypeByCronSpecByManagerModelNew.manager().toString()),JsonParser.parseString(instanceGroupManagerScheduledActionManagerPrototypeModel.toString()));
}