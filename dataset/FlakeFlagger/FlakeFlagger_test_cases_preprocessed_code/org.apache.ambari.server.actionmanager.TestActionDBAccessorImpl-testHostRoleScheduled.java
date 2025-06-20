@Test public void testHostRoleScheduled() throws InterruptedException {
assertEquals(HostRoleStatus.PENDING,stage.getHostRoleStatus(hostName,Role.HBASE_MASTER.toString()));
assertEquals(HostRoleStatus.PENDING,entities.get(0).getStatus());
assertEquals(HostRoleStatus.QUEUED,stage.getHostRoleStatus(hostName,Role.HBASE_MASTER.toString()));
assertEquals(HostRoleStatus.PENDING,entities.get(0).getStatus());
assertEquals(HostRoleStatus.QUEUED,entities.get(0).getStatus());
thread.start();
thread.join();
assertEquals("Concurrent update failed",HostRoleStatus.COMPLETED,entities.get(0).getStatus());
}