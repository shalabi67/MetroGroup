package com.metrogroup.shalabi.url;

/**
 * URL consists of three parts(protocol, domain, and path) separated by two tokens(://, and /).
 * Protocol and domain are separated by the first occurrence of :// token, while domain and path are separated by
 * the first occurrence of /.
 * URL string can looks like this:
 * [protocol://][domain[/[path]]]
 * where any thing between [] is optional.
 */
public class URL {
    private static final String protocolToken = "://";
    private static final String pathToken = "/";

    public static URL create(String urlPath) {
        String protocol = "";
        String domain = "";
        String path ="";
        String newPath = urlPath;

        //get protocol
        int index = urlPath.indexOf(protocolToken );
        if(index>= 0)  {
            protocol = newPath.substring(0, index);
            newPath = newPath .substring(index + protocolToken.length());
        }

        //get domain
        index = newPath.indexOf(pathToken );
        if(index>= 0)  {
            domain = newPath.substring(0, index);
            path = newPath .substring(index + pathToken.length());
        }

        return new URL(protocol, domain, path);
    }

    public URL(String protocol, String domain, String path) {
        this.protocol = protocol;
        this.path = path;
        this.domain = domain;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URL url = (URL) o;

        if (protocol != null ? !protocol.equals(url.protocol) : url.protocol != null) return false;
        if (domain != null ? !domain.equals(url.domain) : url.domain != null) return false;
        return path != null ? path.equals(url.path) : url.path == null;

    }

    @Override
    public int hashCode() {
        int result = protocol != null ? protocol.hashCode() : 0;
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    private String protocol;
    private String domain;
    private String path;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
