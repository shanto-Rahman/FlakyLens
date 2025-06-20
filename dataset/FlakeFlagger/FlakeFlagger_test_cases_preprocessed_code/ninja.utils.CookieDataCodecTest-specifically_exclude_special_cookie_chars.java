@Test public void specifically_exclude_special_cookie_chars() throws UnsupportedEncodingException {
assertFalse(data.contains(" "));
assertFalse(data.contains("\""));
assertFalse(data.contains(","));
assertFalse(data.contains(";"));
assertFalse(data.contains("\\"));
assertEquals(1,outMap.size());
assertEquals(" \",;\\",outMap.get("a"));
}