@Test public void testInsertGetDelete(){
assertEquals("value1",simpleCassandraDao.get("fk1","colName1"));
assertNull(simpleCassandraDao.get("fk1","colName1"));
}