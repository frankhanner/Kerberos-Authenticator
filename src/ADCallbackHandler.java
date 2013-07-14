import javax.security.auth.callback.*;

/**
 * ADCallbackHandler is used in conjunction with ADAuthenticator. It
 * creates a new callback handler to be used with the login context by setting
 * the username and password accordingly. This information is then used to
 * authenticate against the Active Directory via ADAuthenticator.
 *
 * @author Frank Hanner
 */
public class ADCallbackHandler implements CallbackHandler {

    private String ADUserId;
    private char[] ADPassword;

    /**
     * {@inheritDoc}
     */
    @Override
    public void handle(Callback[] callbacks) throws java.io.IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                NameCallback cb = (NameCallback) callbacks[i];
                cb.setName(ADUserId);
            } else if (callbacks[i] instanceof PasswordCallback) {
                PasswordCallback cb = (PasswordCallback) callbacks[i];
                cb.setPassword(ADPassword);
            } else {
                throw new UnsupportedCallbackException(callbacks[i]);
            }
        }
    }

    /**
     * Set callback handler username
     *
     * @param userid username being set.
     */
    public void setUserId(String userid) {
        ADUserId = userid;
    }

    /**
     * Set callback handler password
     *
     * @param password password being set.
     */
    public void setPassword(String password) {
        ADPassword = new char[password.length()];
        password.getChars(0, ADPassword.length, ADPassword, 0);
    }
}