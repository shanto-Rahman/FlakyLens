@Test public void getSessionByIdentifier(){
assertSame(this.adapter,result.getSessionManager());
assertSame(id,result.getId());
assertEquals(creationTime.toEpochMilli(),result.getCreationTime());
assertEquals(lastAccessedTime.toEpochMilli(),result.getLastAccessedTime());
assertEquals(maxInactiveInterval.getSeconds(),result.getMaxInactiveInterval());
assertEquals(names,result.getAttributeNames());
assertSame(value,result.getAttribute(name));
}