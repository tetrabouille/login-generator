package geco;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private LoginService ls ;

    @Test
    public void loginService() {
        // given
        String logins[] = {"PADO", "DOPA"};
        // when
        ls = new LoginService(logins);
        // then
        assertTrue(ls.loginExists("PADO"));
        assertTrue(ls.loginExists("DOPA"));
    }

    @Test
    public void loginExists() {
        // given
        String logins[] = {};
        ls = new LoginService(logins);
        // when
        ls.addLogin("PADO");
        // then
        assertTrue(ls.loginExists("PADO"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        // given
        String logins[] = {"PADO", "PAPA", "POPA"};
        ls = new LoginService(logins);
        // when
        List<String> result = ls.findAllLoginsStartingWith("PA");
        // then
        assertTrue(result.contains("PADO"));
        assertTrue(result.contains("PAPA"));
        assertFalse(result.contains("POPA"));
    }

    @Test
    public void findAllLogins() {
        // given
        String logins[] = {"PADO", "PAPA", "POPA"};
        ls = new LoginService(logins);
        // when
        List<String> result = ls.findAllLogins();
        // then
        assertTrue(result.contains("PADO"));
        assertTrue(result.contains("PAPA"));
        assertTrue(result.contains("POPA"));
    }
}