@Test public void testParseSubsystem() throws Exception {
assertEquals(5,operations.size());
assertEquals("java:jboss/uuid2",uuid2.get(JNDI_NAME).asString());
assertEquals("java:/jdbc/DB1",hilo1.get(DATA_SOURCE).asString());
assertEquals("HILOSEQUENCES1",hilo1.get(TABLE_NAME).asString());
assertEquals("SEQUENCENAME1",hilo1.get(SEQUENCE_COLUMN).asString());
assertEquals("HIGHVALUES1",hilo1.get(ID_COLUMN).asString());
assertEquals("create table HILOSEQUENCES1",hilo1.get(CREATE_TABLE_DDL).asString());
assertEquals("general1",hilo1.get(SEQUENCE_NAME).asString());
assertEquals(true,hilo1.get(CREATE_TABLE).asBoolean());
assertEquals(true,hilo1.get(DROP_TABLE).asBoolean());
assertEquals(10,hilo1.get(BLOCK_SIZE).asLong());
assertEquals("java:jboss/hilo2",hilo2.get(JNDI_NAME).asString());
assertEquals("java:/jdbc/DB2",hilo2.get(DATA_SOURCE).asString());
assertEquals("HILOSEQUENCES2",hilo2.get(TABLE_NAME).asString());
assertEquals("SEQUENCENAME2",hilo2.get(SEQUENCE_COLUMN).asString());
assertEquals("HIGHVALUES2",hilo2.get(ID_COLUMN).asString());
assertEquals("create table HILOSEQUENCES2",hilo2.get(CREATE_TABLE_DDL).asString());
assertEquals("general2",hilo2.get(SEQUENCE_NAME).asString());
assertEquals(false,hilo2.get(CREATE_TABLE).asBoolean());
assertEquals(false,hilo2.get(DROP_TABLE).asBoolean());
assertEquals(11,hilo2.get(BLOCK_SIZE).asLong());
}