import authentication.Authentication;
import authentication.CredentialsService;
import authentication.PermissionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class authenticationMockTest {
    PermissionService permissionServiceMock = Mockito.mock(PermissionService.class);
    CredentialsService credentialsServiceMock = Mockito.mock(CredentialsService.class);

    @Test
    public void verifyLoginMockCorrect(){
        //paso 3 configurarlo como se comporta nuestro objeto falso
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno1","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno2","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno3","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno4","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno5","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno6","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno7","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno8","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno9","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno10","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno11","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno12","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno13","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno14","123456")).thenReturn(true);
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno15","123456")).thenReturn(true);

        Mockito.when(permissionServiceMock.getPermission("mkuno1")).thenReturn("C");
        Mockito.when(permissionServiceMock.getPermission("mkuno2")).thenReturn("R");
        Mockito.when(permissionServiceMock.getPermission("mkuno3")).thenReturn("U");
        Mockito.when(permissionServiceMock.getPermission("mkuno4")).thenReturn("D");
        Mockito.when(permissionServiceMock.getPermission("mkuno5")).thenReturn("CR");
        Mockito.when(permissionServiceMock.getPermission("mkuno6")).thenReturn("CU");
        Mockito.when(permissionServiceMock.getPermission("mkuno7")).thenReturn("CD");
        Mockito.when(permissionServiceMock.getPermission("mkuno8")).thenReturn("RU");
        Mockito.when(permissionServiceMock.getPermission("mkuno9")).thenReturn("RD");
        Mockito.when(permissionServiceMock.getPermission("mkuno0")).thenReturn("UD");
        Mockito.when(permissionServiceMock.getPermission("mkuno10")).thenReturn("CRU");
        Mockito.when(permissionServiceMock.getPermission("mkuno11")).thenReturn("RUD");
        Mockito.when(permissionServiceMock.getPermission("mkuno12")).thenReturn("CRD");
        Mockito.when(permissionServiceMock.getPermission("mkuno13")).thenReturn("CUD");
        Mockito.when(permissionServiceMock.getPermission("mkuno14")).thenReturn("CRUD");


        //paso 4 utilizar el objeto falso - mock
        Authentication authentication = new Authentication();
        authentication.setPermissions(permissionServiceMock);
        authentication.setCredentials(credentialsServiceMock);

        String expectedResult ="user authenticated successfully with permission: [CRUD]";
        String actualResult=authentication.login("mkuno1", "123456");
        Assertions.assertEquals(expectedResult, actualResult, "ERROR");

        //step 5 para garantizar que utilizamos el objeto mock se necesita verificarlo

        Mockito.verify(permissionServiceMock).getPermission("mkuno1");
        /*Mockito.verify(permissionServiceMock).getPermission("mkuno2");
        Mockito.verify(permissionServiceMock).getPermission("mkuno3");
        Mockito.verify(permissionServiceMock).getPermission("mkuno4");
        Mockito.verify(permissionServiceMock).getPermission("mkuno5");
        Mockito.verify(permissionServiceMock).getPermission("mkuno6");
        Mockito.verify(permissionServiceMock).getPermission("mkuno7");
        Mockito.verify(permissionServiceMock).getPermission("mkuno8");
        Mockito.verify(permissionServiceMock).getPermission("mkuno9");
        Mockito.verify(permissionServiceMock).getPermission("mkuno10");
        Mockito.verify(permissionServiceMock).getPermission("mkuno11");
        Mockito.verify(permissionServiceMock).getPermission("mkuno12");
        Mockito.verify(permissionServiceMock).getPermission("mkuno13");
        Mockito.verify(permissionServiceMock).getPermission("mkuno14");*/

    }

    @Test
    public void verifyLoginMockIncorrect(){
        //paso 3 configurarlo como se comporta nuestro objeto falso
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno2","123456")).thenReturn(false);

        Mockito.when(permissionServiceMock.getPermission("mkuno2")).thenReturn("CRUD");

        //paso 4 utilizar el objeto falso - mock
        Authentication authentication = new Authentication();
        authentication.setPermissions(permissionServiceMock);
        authentication.setCredentials(credentialsServiceMock);

        String expectedResult ="user or password incorrect";
        String actualResult=authentication.login("mkuno2", "123456");
        Assertions.assertEquals(expectedResult, actualResult, "ERROR");

        //step 5 para garantizar que utilizamos el objeto mock se necesita verificarlo
        Mockito.verify(credentialsServiceMock).isValidCredential("mkuno2","123456");
    }

    @Test
    public void verifyLoginMockWithoutPermission(){
        //paso 3 configurarlo como se comporta nuestro objeto falso
        Mockito.when(credentialsServiceMock.isValidCredential("mkuno3","123456")).thenReturn(true);
        Mockito.when(permissionServiceMock.getPermission("mkuno3")).thenReturn("");

        //paso 4 utilizar el objeto falso - mock
        Authentication authentication = new Authentication();
        authentication.setPermissions(permissionServiceMock);
        authentication.setCredentials(credentialsServiceMock);

        String expectedResult ="user authenticated successfully with permission: []";
        String actualResult=authentication.login("mkuno3", "123456");
        Assertions.assertEquals(expectedResult, actualResult, "ERROR");

        //step 5 para garantizar que utilizamos el objeto mock se necesita verificarlo
        Mockito.verify(credentialsServiceMock).isValidCredential("mkuno3","123456");
    }
}
