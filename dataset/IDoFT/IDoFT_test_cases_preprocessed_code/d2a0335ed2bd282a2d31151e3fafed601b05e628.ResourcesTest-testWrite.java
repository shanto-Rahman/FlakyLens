public void testWrite() throws Exception {
assertTrue(Arrays.equals(example.getBytes("utf-8"),baos.toByteArray()));
}