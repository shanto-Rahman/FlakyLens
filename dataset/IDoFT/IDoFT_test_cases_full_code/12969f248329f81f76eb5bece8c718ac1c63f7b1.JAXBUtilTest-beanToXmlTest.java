@Test public void beanToXmlTest(){
  SchoolVo schoolVo=new SchoolVo();
  schoolVo.setSchoolName("西安市第一中学");
  schoolVo.setSchoolAddress("西安市雁塔区长安堡一号");
  SchoolVo.RoomVo roomVo=new SchoolVo.RoomVo();
  roomVo.setRoomName("101教室");
  roomVo.setRoomNo("101");
  schoolVo.setRoom(roomVo);
  Assert.assertEquals(xmlStr,JAXBUtil.beanToXml(schoolVo));
}
