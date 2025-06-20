@Test public void testMigrateHA() throws Exception {
assertFalse(additionalInitialization.extensionAdded);
assertTrue(model.get(SUBSYSTEM,SUBSYSTEM_NAME).isDefined());
assertFalse(model.get(SUBSYSTEM,MESSAGING_ACTIVEMQ_SUBSYSTEM_NAME).isDefined());
assertEquals(warnings.toString(),1 + 1 + 3,warnings.asList().size());
assertFalse(model.get(SUBSYSTEM,MESSAGING_ACTIVEMQ_SUBSYSTEM_NAME,"server","unmigrated-backup","ha-policy").isDefined());
assertFalse(model.get(SUBSYSTEM,MESSAGING_ACTIVEMQ_SUBSYSTEM_NAME,"server","unmigrated-shared-store","ha-policy").isDefined());
assertTrue(haPolicyForDefaultServer.isDefined());
assertFalse(haPolicyForDefaultServer.get("failback-delay").isDefined());
assertEquals(false,haPolicyForDefaultServer.get("failover-on-server-shutdown").asBoolean());
assertTrue(haPolicyForSharedStoreMasterServer.isDefined());
assertFalse(haPolicyForSharedStoreMasterServer.get("failback-delay").isDefined());
assertEquals("${failover.on.shutdown:true}",haPolicyForSharedStoreMasterServer.get("failover-on-server-shutdown").asString());
assertTrue(haPolicyForSharedStoreSlaveServer.isDefined());
assertEquals("${allow.failback.1:false}",haPolicyForSharedStoreSlaveServer.get("allow-failback").asString());
assertFalse(haPolicyForSharedStoreSlaveServer.get("failback-delay").isDefined());
assertEquals("${failover.on.shutdown.1:true}",haPolicyForSharedStoreSlaveServer.get("failover-on-server-shutdown").asString());
assertTrue(haPolicyForReplicationMasterServer.isDefined());
assertEquals("${check.for.live.server:true}",haPolicyForReplicationMasterServer.get("check-for-live-server").asString());
assertEquals("${replication.master.group.name:mygroup}",haPolicyForReplicationMasterServer.get("group-name").asString());
assertTrue(haPolicyForReplicationSlaveServer.isDefined());
assertEquals("${allow.failback.2:false}",haPolicyForReplicationSlaveServer.get("allow-failback").asString());
assertFalse(haPolicyForReplicationSlaveServer.get("failback-delay").isDefined());
assertEquals("${max.saved.replicated.journal.size:2}",haPolicyForReplicationSlaveServer.get("max-saved-replicated-journal-size").asString());
assertEquals("${replication.master.group.name:mygroup2}",haPolicyForReplicationSlaveServer.get("group-name").asString());
}