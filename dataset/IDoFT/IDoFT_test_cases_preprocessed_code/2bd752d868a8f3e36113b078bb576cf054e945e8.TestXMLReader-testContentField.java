@Test public void testContentField() throws IOException, InitializationException {
InputStream is=new FileInputStream("src/test/resources/xml/people_tag_in_characters.xml");
assertEquals(5,records.size());
assertEquals("MapRecord[{ID=P1, NAME=MapRecord[{CONTENT=Cleve Butler, ATTR=attr content, INNER=inner content}], AGE=42}]",records.get(0));
assertEquals("MapRecord[{ID=P2, NAME=MapRecord[{CONTENT=Ainslie Fletcher, ATTR=attr content, INNER=inner content}], AGE=33}]",records.get(1));
assertEquals("MapRecord[{ID=P3, NAME=MapRecord[{CONTENT=Amélie Bonfils, ATTR=attr content, INNER=inner content}], AGE=74}]",records.get(2));
assertEquals("MapRecord[{ID=P4, NAME=MapRecord[{CONTENT=Elenora Scrivens, ATTR=attr content, INNER=inner content}], AGE=16}]",records.get(3));
assertEquals("MapRecord[{ID=P5, NAME=MapRecord[{INNER=inner content}]}]",records.get(4));
}