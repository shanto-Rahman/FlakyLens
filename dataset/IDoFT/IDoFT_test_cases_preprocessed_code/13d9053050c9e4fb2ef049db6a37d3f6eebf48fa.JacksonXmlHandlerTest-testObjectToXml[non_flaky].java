public void testObjectToXml() throws Exception {
assertTrue(actual.length() == xml.length() && actual.startsWith(prefix) && actual.contains(name) && actual.contains(age) && actual.contains(parents) && actual.endsWith(suffix));
}