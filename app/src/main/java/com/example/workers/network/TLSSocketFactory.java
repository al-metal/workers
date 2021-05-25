package com.example.workers.network;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory {

    private SSLSocketFactory socketFactory;

    public TLSSocketFactory() {
        super();
        try {
            final SSLContext sContext = SSLContext.getInstance("TLSv1.2");
            sContext.init(null, null, null);
            socketFactory = sContext.getSocketFactory();
        } catch (final NoSuchAlgorithmException | KeyManagementException e) {
            System.out.println(e);;
        }
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return socketFactory.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return socketFactory.getSupportedCipherSuites();
    }

    @Override
    public Socket createSocket(final Socket s, final String host, final int port, final boolean autoClose)
            throws IOException {
        final SSLSocket ss = (SSLSocket) socketFactory.createSocket(s, host, port, autoClose);
        ss.setEnabledProtocols(ss.getSupportedProtocols());
        ss.setEnabledCipherSuites(ss.getSupportedCipherSuites());
        return ss;
    }

    @Override
    public Socket createSocket(final String host, final int port) throws IOException {
        final SSLSocket ss = (SSLSocket) socketFactory.createSocket(host, port);
        ss.setEnabledProtocols(ss.getSupportedProtocols());
        ss.setEnabledCipherSuites(ss.getSupportedCipherSuites());
        return ss;
    }

    @Override
    public Socket createSocket(final String host, final int port, final InetAddress localHost, final int localPort)
            throws IOException {
        final SSLSocket ss = (SSLSocket) socketFactory.createSocket(host, port, localHost, localPort);
        ss.setEnabledProtocols(ss.getSupportedProtocols());
        ss.setEnabledCipherSuites(ss.getSupportedCipherSuites());
        return ss;
    }

    @Override
    public Socket createSocket(final InetAddress host, final int port) throws IOException {
        final SSLSocket ss = (SSLSocket) socketFactory.createSocket(host, port);
        ss.setEnabledProtocols(ss.getSupportedProtocols());
        ss.setEnabledCipherSuites(ss.getSupportedCipherSuites());
        return ss;
    }

    @Override
    public Socket createSocket(final InetAddress address, final int port, final InetAddress localAddress,
                               final int localPort) throws IOException {
        final SSLSocket ss = (SSLSocket) socketFactory
                .createSocket(address, port, localAddress, localPort);
        ss.setEnabledProtocols(ss.getSupportedProtocols());
        ss.setEnabledCipherSuites(ss.getSupportedCipherSuites());
        return ss;
    }
}
