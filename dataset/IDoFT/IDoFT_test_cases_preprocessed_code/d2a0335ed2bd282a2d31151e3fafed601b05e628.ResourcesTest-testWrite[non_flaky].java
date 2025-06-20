public void testWrite() throws Exception {
assertTrue(Arrays.equals(example.getBytes("utf-8"),baos.toByteArray()) || Arrays.equals(example2.getBytes("utf-8"),baos.toByteArray()));
}