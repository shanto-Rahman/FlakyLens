@Test public void testDetailConfigInfo() throws Exception {
Assert.assertEquals(configAllInfo.getDataId(),resConfigAllInfo.getDataId());
Assert.assertEquals(configAllInfo.getGroup(),resConfigAllInfo.getGroup());
Assert.assertEquals(configAllInfo.getCreateIp(),resConfigAllInfo.getCreateIp());
Assert.assertEquals(configAllInfo.getCreateUser(),resConfigAllInfo.getCreateUser());
}