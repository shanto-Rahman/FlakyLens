@Test public void testAttributePrefix() throws IOException, InitializationException {
InputStream is=new FileInputStream("src/test/resources/xml/people.xml");
assertEquals(4,records.size());
assertEquals("MapRecord[{COUNTRY=USA, ATTR_ID=P1, NAME=Cleve Butler, AGE=42}]",records.get(0));
assertEquals("MapRecord[{COUNTRY=UK, ATTR_ID=P2, NAME=Ainslie Fletcher, AGE=33}]",records.get(1));
assertEquals("MapRecord[{COUNTRY=FR, ATTR_ID=P3, NAME=Amélie Bonfils, AGE=74}]",records.get(2));
assertEquals("MapRecord[{COUNTRY=USA, ATTR_ID=P4, NAME=Elenora Scrivens, AGE=16}]",records.get(3));
}