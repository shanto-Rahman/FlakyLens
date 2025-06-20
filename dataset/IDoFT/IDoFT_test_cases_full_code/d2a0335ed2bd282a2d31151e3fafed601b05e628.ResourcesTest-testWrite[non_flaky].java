public void testWrite() throws Exception {
  Resources res=new Resources();
  res.put("menu_open","\u00D6ffnen");
  res.put("menu_save","Speichern");
  ByteArrayOutputStream baos=new ByteArrayOutputStream();
  res.save(baos);
  assertTrue(Arrays.equals(example.getBytes("utf-8"),baos.toByteArray()) || Arrays.equals(example2.getBytes("utf-8"),baos.toByteArray()));
}
