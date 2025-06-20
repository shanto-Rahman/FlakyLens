@Test public void testFindAndSetAttributesEJBWithParameter(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("AlbumServiceImpl");
  sourceCode="@Stateless\n" + "@EJB(name = \"java:global/galleria/galleria-ejb/AlbumService\", beanInterface = AlbumService.class)\n" + "@RolesAllowed({ \"RegisteredUsers\" })\n"+ "@TransactionAttribute(TransactionAttributeType.REQUIRED)\n"+ "public class AlbumServiceImpl implements AlbumService\n"+ "{\n"+ "private static final Logger logger = LoggerFactory.getLogger(AlbumServiceImpl.class);\n"+ " @Resource\n"+ "	private SessionContext context;\n"+ "	@EJB\n"+ "	private UserRepository userRepository;\n"+ "	@EJB(name = \"java:global/test/test-ejb/TestService\", beanInterface = TestService.class)\n"+ "	private AlbumRepository albumRepository;\n"+ "	@Override\n"+ "	public Album createAlbum(Album album) throws AlbumException\n"+ "	{\n"+ "		validateAlbum(album);\n"+ "		User user = findCurrentUser(CREATE_ALBUM_INTERNAL_ERROR);\n"+ "		logger.debug(\"User's albums: {}\", user.getAlbums());\n"+ "		if (user.getAlbums().contains(album))\n"+ "		{\n"+ "			logger.error(\"The album to be created, already exists.\");\n"+ "			throw new AlbumException(DUPLICATE_ALBUM);\n"+ "		}\n"+ "		user.addToAlbums(album);\n"+ "		Album createdAlbum = albumRepository.create(album);\n"+ "		return createdAlbum;\n"+ "	}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(2,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.EJB,dependency.getDependencyType());
  assertEquals("AlbumServiceImpl",dependency.getJavaSourceFrom().getName());
  assertEquals("UserRepository",dependency.getJavaSourceTo().getName());
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(1);
  assertEquals(DependencyType.EJB,dependency.getDependencyType());
  assertEquals("AlbumServiceImpl",dependency.getJavaSourceFrom().getName());
  assertEquals("AlbumRepository",dependency.getJavaSourceTo().getName());
}
