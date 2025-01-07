# HTTP (Hypertext Transfer Protocol)

Hypertext Transfer Protocol (HTTP) is an application-layer protocol for transmitting hypermedia documents.
 
## HTTP Methods 

1. **GET** retrieves data.
1. **POST** creates resources.
1. **PUT** updates or creates a resource.
1. **PATCH** applies partial updates.
1. **DELETE** removes resources.
1. **HEAD** fetches headers - same as GET but does not return the body, only headers.
1. **OPTIONS** checks available methods - describe the communication options for the target resource.
1. **CONNECT** establishes a tunnel - establish a tunnel to the server, usually for SSL/TLS.
1. **TRACE** perform a message loop-back test along the path to the target resource.

## HTTP Status Codes

1. **1xx: Informational Resource** - indicate that the request was received, and the process is continuing.
   1. **100 Continue:** The server has received the request headers, and the client should proceed to send the request body.
1. **2xx: Successful Responses** - the action was successfully received, understood, and accepted.
   1. **200 OK:** The request was successful.
   1. **201 CREATED:** The request was successful, and a new resource was created.
   1. **204 No Content:** The request was successful, but there is no content to send in the response.
1. **3xx: Redirection Messages** - further action needs to be taken to complete the request.
   1. **301 Moved Permanently:** The resource has been moved to a new URL permanently.
   1. **302 Found:** The resource has been found at a different URL, temporarily.
   1. **304 Not Modified:** The resource has not been modified since the last request.
1. **4xx: Client Error Responses** - the request contains bad syntax or cannot be fulfilled.
   1. **400 Bad Request:** The server could not understand the request due to invalid syntax.
   1. **401 Unauthorized:** Authentication is required, and it has failed or has not been provided.
   1. **403 Forbidden:** The server understood the request but refuses to authorize it.
   1. **404 Not Found:** The requested resource could not be found on the server.
   1. **429 Too Many Requests:** The user has sent too many requests in a given amount of time ("rate limiting").
1. **5xx: Server Error Responses** - the server failed to fulfill a valid request.
   1. **500 Internal Server Error:** The server encountered an unexpected condition that prevented it from fulfilling the request.
   1. **502 Bad Gateway:** The server was acting as a gateway or proxy and received an invalid response from the upstream server.
   1. **503 Service Unavailable:** The server is not ready to handle the request, often due to maintenance or overload.
   1. **504 Gateway Timeout:** The server was acting as a gateway or proxy and did not receive a timely response from the upstream server.
   

## HTTP Headers

Authentication HTTP Headers:

- Notes:
   - **HTTP** - Always use HTTPS to encrypt the headers and protect sensitive information
   - **Token Expiration** - For token-based methods, consider token expiration and refresh mechanisms
   - **Security** - Avoid sending sensitive data like passwords in headers without encryption

1. **Basic Authentication** - Authorization: Basic < base64-encoded-username:password >
1. **Bearer Token Authentication** - Authorization: Bearer < token >
1. **API Key Authentication** - Authorization: ApiKey your-api-key
1. **Digest Authentication** - Authorization: Digest username="user", realm="example.com", nonce="xyz", uri="/", response="abc123"
1. **HMAC (Hash-Based Message Authentication Code)** - Authorization: HMAC username="user", signature="generated-signature"
1. **Custom Token-Based Authentication** - X-Auth-Token: your-custom-token

Security Related HTTP Headers:

1. **Content Security Policy (CSP):** Helps prevent XSS attacks by controlling the sources of content that the browser can load.
1. **Cross-Origin Resource Policy (CORP):** Prevents resources from being loaded cross-origin.
1. **Cross-Origin Opener Policy (COOP):** Helps isolate the browsing context to prevent certain attacks.
1. **Cross-Origin Embedder Policy (COEP):** Ensures that a document only loads cross-origin resources that explicitly grant permission.
1. **DNS Prefetch Control:** Controls DNS prefetching to prevent information leaks.
1. **Expect-CT:** Helps detect and prevent misissued **SSL/TLS** certificates.
1. **Feature Policy:** Allows control over which features and APIs can be used in the browser.
1. **Frameguard:** Prevents clickjacking attacks by controlling whether the browser can render your site in a frame.
1. **Hide Powered-By:** Removes the X-Powered-By header to make it less obvious what technology the app is using.
1. **HSTS (HTTP Strict Transport Security):** Forces the use of HTTPS to prevent man-in-the-middle attacks.
1. **IE No Open:** Sets X-Download-Options to prevent Internet Explorer from executing downloads in the site's context.
1. **No Sniff:** Helps prevent browsers from sniffing MIME types.
1. **Referrer Policy:** Controls the information sent in the Referer header.
1. **XSS Filter:**  Enables the Cross-site scripting (XSS) filter built into most browsers.

# CORS (Cross Origin Resource Sharing) 

CORS (Cross-Origin Resource Sharing) is a mechanism that allows web servers to specify who can access their resources from different origins (domains).

CORS HTTP Headers:

1. **Access-Control-Allow-Origin:** Specifies which origin(s) are allowed to access the resource. Can be a specific domain or * (to allow all domains).
1. **Access-Control-Allow-Methods:** Specifies which HTTP methods are allowed when accessing the resource.
1. **Access-Control-Allow-Headers:** Lists the headers that are allowed to be used when making the request.
1. **Access-Control-Allow-Credentials:** Indicates whether credentials (like cookies) are allowed in the request.
1. **Access-Control-Max-Age:** Specifies how long the results of a preflight request can be cached.

