package com.atella.java.security.authentication;

import javax.security.auth.callback.*;
import java.io.*;

/**
 * @author chenyuan
 */
public class ConsolePasswordCallbackHandler implements CallbackHandler {

    public void handle(Callback[] callbacks)
            throws IOException, UnsupportedCallbackException {

        for (Callback callback : callbacks) {
            if (callback instanceof TextOutputCallback) {

                // display the message according to the specified type
                TextOutputCallback toc = (TextOutputCallback) callback;
                switch (toc.getMessageType()) {
                    case TextOutputCallback.INFORMATION:
                        System.out.println(toc.getMessage());
                        break;
                    case TextOutputCallback.ERROR:
                        System.out.println("ERROR: " + toc.getMessage());
                        break;
                    case TextOutputCallback.WARNING:
                        System.out.println("WARNING: " + toc.getMessage());
                        break;
                    default:
                        throw new IOException("Unsupported message type: " +
                                toc.getMessageType());
                }

            } else if (callback instanceof NameCallback) {

                // prompt the user for a username
                NameCallback nc = (NameCallback) callback;

                // ignore the provided defaultName
                System.err.print(nc.getPrompt());
                System.err.flush();
                nc.setName((new BufferedReader
                        (new InputStreamReader(System.in))).readLine());

            } else if (callback instanceof PasswordCallback) {

                // prompt the user for sensitive information
                PasswordCallback pc = (PasswordCallback) callback;
                System.err.print(pc.getPrompt());
                System.err.flush();
                pc.setPassword(readPassword(System.in));

            } else {
                throw new UnsupportedCallbackException
                        (callback, "Unrecognized Callback");
            }
        }
    }

    // Reads user password from given input stream.
    private char[] readPassword(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        Reader reader = new InputStreamReader(in);
        char[] buff = new char[1024];
        int len;
        while ((len = reader.read(buff)) != -1) {
            sb.append(String.valueOf(buff, 0, len));
        }
        System.out.println("input password: " + sb.toString());
        return sb.toString().toCharArray();
    }
}
