@Test public void specifically_exclude_control_chars() throws UnsupportedEncodingException {
assertFalse(data.contains(s));
assertEquals(1,outMap.size());
assertEquals(s,outMap.get("a"));
}