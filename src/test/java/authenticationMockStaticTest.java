import authenticationStatic.Authentication;
import authenticationStatic.CredentialsStaticService;
import authenticationStatic.PermissionStaticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class authenticationMockStaticTest {
    @Test
    public void verifyLogin(){
        MockedStatic<CredentialsStaticService> objectMockedCredentials = Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> objectMockedPermission = Mockito.mockStatic(PermissionStaticService.class);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno1","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno2","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno3","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno4","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno5","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno6","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno7","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno8","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno9","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno10","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno11","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno12","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno13","123456")).thenReturn(true);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno14","123456")).thenReturn(true);
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno1")).thenReturn("C");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno2")).thenReturn("R");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno3")).thenReturn("U");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno4")).thenReturn("D");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno5")).thenReturn("CR");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno6")).thenReturn("CU");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno7")).thenReturn("CD");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno8")).thenReturn("RU");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno9")).thenReturn("RD");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno10")).thenReturn("UD");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno11")).thenReturn("CRU");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno12")).thenReturn("CUD");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno13")).thenReturn("RUD");
        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno14")).thenReturn("CRUD");


        Authentication authentication = new Authentication();
        String expectedResult = "user authenticated successfully with permission: [C]";
        String actualResult = authentication.login("mkuno1","123456");

        Assertions.assertEquals(expectedResult, actualResult, "ERROR");
        objectMockedCredentials.close();
        objectMockedPermission.close();

    }
    @Test
    public void verifyIncorrectLogin(){
        MockedStatic<CredentialsStaticService> objectMockedCredentials = Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> objectMockedPermission = Mockito.mockStatic(PermissionStaticService.class);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno2","123456")).thenReturn(false);

        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno2")).thenReturn("C");


        Authentication authentication = new Authentication();
        String expectedResult = "user or password incorrect";
        String actualResult = authentication.login("mkuno2","123456");

        Assertions.assertEquals(expectedResult, actualResult, "ERROR");
        objectMockedCredentials.close();
        objectMockedPermission.close();

    }
    @Test
    public void verifyWithoutPermissionLogin(){
        MockedStatic<CredentialsStaticService> objectMockedCredentials = Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> objectMockedPermission = Mockito.mockStatic(PermissionStaticService.class);
        objectMockedCredentials.when(()->CredentialsStaticService.isValidCredential("mkuno3","123456")).thenReturn(true);

        objectMockedPermission.when(()->PermissionStaticService.getPermission("mkuno3")).thenReturn("");


        Authentication authentication = new Authentication();
        String expectedResult = "user authenticated successfully with permission: []";
        String actualResult = authentication.login("mkuno3","123456");

        Assertions.assertEquals(expectedResult, actualResult, "ERROR");
        objectMockedCredentials.close();
        objectMockedPermission.close();

    }
}
