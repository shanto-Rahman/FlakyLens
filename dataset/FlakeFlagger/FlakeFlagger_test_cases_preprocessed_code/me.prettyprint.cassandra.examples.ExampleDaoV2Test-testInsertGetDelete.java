@Test public void testInsertGetDelete() throws HectorException {
assertNull(dao.get("key",StringSerializer.get()));
assertEquals("value",dao.get("key",StringSerializer.get()));
assertNull(dao.get("key",StringSerializer.get()));
}