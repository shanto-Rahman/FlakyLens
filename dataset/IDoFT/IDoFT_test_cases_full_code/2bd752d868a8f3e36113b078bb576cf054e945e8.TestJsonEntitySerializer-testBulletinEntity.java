@Test public void testBulletinEntity() throws Exception {
  final ObjectMapper jsonCodec=new ObjectMapper();
  jsonCodec.registerModule(new JaxbAnnotationModule());
  jsonCodec.setSerializationInclusion(Include.NON_NULL);
  final Date timestamp=new Date();
  final TimeAdapter adapter=new TimeAdapter();
  final String formattedTimestamp=adapter.marshal(timestamp);
  final JsonEntitySerializer serializer=new JsonEntitySerializer(jsonCodec);
  try (final ByteArrayOutputStream baos=new ByteArrayOutputStream()){
    final BulletinDTO bulletinDto=new BulletinDTO();
    bulletinDto.setCategory("test");
    bulletinDto.setLevel("INFO");
    bulletinDto.setTimestamp(timestamp);
    final BulletinEntity bulletin=new BulletinEntity();
    bulletin.setBulletin(bulletinDto);
    serializer.serialize(bulletin,baos);
    final String serialized=new String(baos.toByteArray(),StandardCharsets.UTF_8);
    assertEquals("{\"bulletin\":{\"category\":\"test\",\"level\":\"INFO\",\"timestamp\":\"" + formattedTimestamp + "\"}}",serialized);
  }
 }
