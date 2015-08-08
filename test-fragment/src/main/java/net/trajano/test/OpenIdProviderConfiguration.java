package net.trajano.test;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * The response is a set of Claims about the OpenID Provider's configuration,
 * including all necessary endpoints and public key location information. A
 * successful response MUST use the 200 OK HTTP status code and return a JSON
 * object using the application/json content type that contains a set of Claims
 * as its members that are a subset of the Metadata values defined in Section 3.
 * Other Claims MAY also be returned.
 * </p>
 * <p>
 * Claims that return multiple values are represented as JSON arrays. Claims
 * with zero elements MUST be omitted from the response.
 * </p>
 * <p>
 * An error response uses the applicable HTTP status code value.
 * </p>
 */
@XmlRootElement
public class OpenIdProviderConfiguration {

    public OpenIdProviderConfiguration() {
    }

    /**
     * JSON array containing a list of the Authentication Context Class
     * References that this OP supports.
     */
    @XmlElement(name = "acr_values_supported")
    private Set<String> acrValuesSupported;

    /**
     * URL of the OP's OAuth 2.0 Authorization Endpoint [OpenID.Core].
     */
    @XmlElement(name = "authorization_endpoint")
    private URI authorizationEndpoint;

    /**
     * URL of an OP iframe that supports cross-origin communications for session
     * state information with the RP Client, using the HTML5 postMessage API.
     * The page is loaded from an invisible iframe embedded in an RP page so
     * that it can run in the OP's security context. It accepts postMessage
     * requests from the relevant RP iframe and uses postMessage to post back
     * the login status of the End-User at the OP.
     */
    @XmlElement(name = "check_session_iframe")
    private URI checkSessionIframe;

    /**
     * Boolean value specifying whether the OP supports use of the claims
     * parameter, with true indicating support. If omitted, the default value is
     * <code>false</code>.
     */
    @XmlElement(name = "claims_parameter_supported")
    private boolean claimsParameterSupported;

    /**
     * <p>
     * claims_supported RECOMMENDED. JSON array containing a list of the Claim
     * Names of the Claims that the OpenID Provider MAY be able to supply values
     * for. Note that for privacy or other reasons, this might not be an
     * exhaustive list.
     * </p>
     * <p>
     * Implementers of the OP would set this rather than being part of the
     * framework.
     * </p>
     */
    @XmlElement(name = "claims_supported")
    private Set<String> claimsSupported;

    /**
     * OPTIONAL. JSON array containing a list of the Claim Types that the OpenID
     * Provider supports. These Claim Types are described in Section 5.6 of
     * OpenID Connect Core 1.0 [OpenID.Core]. Values defined by this
     * specification are normal, aggregated, and distributed. If omitted, the
     * implementation supports only normal Claims.
     */
    @XmlElement(name = "claim_types_supported")
    private Set<String> claimTypesSupported;

    /**
     * URL at the OP to which an RP can perform a redirect to request that the
     * End-User be logged out at the OP.
     */
    @XmlElement(name = "end_session_endpoint")
    private URI endSessionEndpoint;

    @XmlElement(name = "id_token_encryption_alg_values_supported")
    private List<String> idTokenEncryptionAlgValuesSupported;

    @XmlElement(name = "id_token_encryption_enc_values_supported")
    private List<String> idTokenEncryptionEncValuesSupported;

    @XmlElement(name = "id_token_signing_alg_values_supported")
    private List<String> idTokenSigningAlgValuesSupported;

    /**
     * URL using the https scheme with no query or fragment component that the
     * OP asserts as its Issuer Identifier. If Issuer discovery is supported
     * (see Section 2), this value MUST be identical to the issuer value
     * returned by WebFinger. This also MUST be identical to the iss Claim value
     * in ID Tokens issued from this Issuer.
     * <p>
     * In order to support Google, this is left as a string rather than a URI.
     */
    private String issuer;

    /**
     * URL of the OP's JSON Web Key Set [JWK] document. This contains the
     * signing key(s) the RP uses to validate signatures from the OP. The JWK
     * Set MAY also contain the Server's encryption key(s), which are used by
     * RPs to encrypt requests to the Server. When both signing and encryption
     * keys are made available, a use (Key Use) parameter value is REQUIRED for
     * all keys in the referenced JWK Set to indicate each key's intended usage.
     * Although some algorithms allow the same key to be used for both
     * signatures and encryption, doing so is NOT RECOMMENDED, as it is less
     * secure. The JWK x5c parameter MAY be used to provide X.509
     * representations of keys provided. When used, the bare key values MUST
     * still be present and MUST match those in the certificate.
     */
    @XmlElement(name = "jwks_uri")
    private URI jwksUri;

    /**
     * URL of the OP's Dynamic Client Registration Endpoint.
     */
    @XmlElement(name = "registration_endpoint")
    private URI registrationEndpoint;

    /**
     * <p>
     * request_object_encryption_alg_values_supported
     * </p>
     * <p>
     * OPTIONAL. JSON array containing a list of the JWE encryption algorithms
     * (alg values) supported by the Authorization Server for the Request Object
     * described in Section 2.9 of OpenID Connect Messages 1.0
     * [OpenID.Messages]. These algorithms are used both when the Request Object
     * is passed by value and when it is passed by reference.
     * </p>
     */
    @XmlElement(name = "request_object_encryption_alg_values_supported")
    private List<String> requestObjectEncryptionAlgValuesSupported;

    /**
     * <p>
     * request_object_encryption_enc_values_supported
     * </p>
     * <p>
     * OPTIONAL. JSON array containing a list of the JWE encryption algorithms
     * (enc values) supported by the Authorization Server for the Request Object
     * described in Section 2.9 of OpenID Connect Messages 1.0
     * [OpenID.Messages]. These algorithms are used both when the Request Object
     * is passed by value and when it is passed by reference.
     * </p>
     */
    @XmlElement(name = "request_object_encryption_enc_values_supported")
    private List<String> requestObjectEncryptionEncValuesSupported;

    @XmlElement(name = "request_object_signing_alg_values_supported")
    private List<String> requestObjectSigningAlgValuesSupported;

    /**
     * Boolean value specifying whether the OP supports use of the request
     * parameter, with true indicating support. If omitted, the default value is
     * <code>false</code>.
     */
    @XmlElement(name = "request_parameter_supported")
    private boolean requestParameterSupported;

    /**
     * Boolean value specifying whether the OP supports use of the request_uri
     * parameter, with true indicating support. If omitted, the default value is
     * true.
     */
    @XmlElement(name = "request_uri_parameter_supported")
    private boolean requestUriParameterSupported = true;

    /**
     * Boolean value specifying whether the OP requires any request_uri values
     * used to be pre-registered using the request_uris registration parameter.
     * Pre-registration is REQUIRED when the value is true. If omitted, the
     * default value is false.
     */
    @XmlElement(name = "require_request_uri_registration")
    private boolean requireRequestUriRegistration;

    /**
     * <p>
     * JSON array containing a list of the OAuth 2.0 response_type values that
     * this OP supports. Dynamic OpenID Providers MUST support the code,
     * id_token, and the token id_token Response Type values.
     * </p>
     * <p>
     * This is ordered by order of preference.
     * </p>
     */
    @XmlElement(name = "response_types_supported")
    private List<String> responseTypesSupported;

    @XmlElement(name = "revocation_endpoint")
    private URI revocationEndpoint;

    /**
     * URL of a page containing human-readable information that developers might
     * want or need to know when using the OpenID Provider. In particular, if
     * the OpenID Provider does not support Dynamic Client Registration, then
     * information on how to register Clients needs to be provided in this
     * documentation.
     */
    @XmlElement(name = "service_documentation")
    private URI serviceDocumentation;

    /**
     * URL of the OP's OAuth 2.0 Token Endpoint [OpenID.Core]. This is REQUIRED
     * unless only the Implicit Flow is used.
     */
    @XmlElement(name = "token_endpoint")
    private URI tokenEndpoint;

    @XmlElement(name = "token_endpoint_auth_signing_alg_values_supported")
    private Set<String> tokenEndpointAuthSigningAlgValuesSupported;

    @XmlElement(name = "ui_locales_supported")
    private Set<Locale> uiLocalesSupported;

    @XmlElement(name = "userinfo_encryption_alg_values_supported")
    private Set<String> userinfoEncryptionAlgValuesSupported;

    @XmlElement(name = "userinfo_encryption_enc_values_supported")
    private Set<String> userinfoEncryptionEncValuesSupported;

    /**
     * URL of the OP's UserInfo Endpoint [OpenID.Core]. This URL MUST use the
     * https scheme and MAY contain port, path, and query parameter components.
     */
    @XmlElement(name = "userinfo_endpoint")
    private URI userinfoEndpoint;

    @XmlElement(name = "userinfo_signing_alg_values_supported")
    private Set<String> userinfoSigningAlgValuesSupported;

    public Set<String> getAcrValuesSupported() {

        return acrValuesSupported;
    }

    public URI getAuthorizationEndpoint() {

        return authorizationEndpoint;
    }

    public URI getCheckSessionIframe() {

        return checkSessionIframe;
    }

    public Set<String> getClaimsSupported() {

        return claimsSupported;
    }

    public Set<String> getClaimTypesSupported() {

        return claimTypesSupported;
    }

    /**
     * @return the claimsParameterSupported
     */
    public boolean isClaimsParameterSupported() {

        return claimsParameterSupported;
    }

    /**
     * @param claimsParameterSupported
     *            the claimsParameterSupported to set
     */
    public void setClaimsParameterSupported(boolean claimsParameterSupported) {

        this.claimsParameterSupported = claimsParameterSupported;
    }

    /**
     * @return the endSessionEndpoint
     */
    public URI getEndSessionEndpoint() {

        return endSessionEndpoint;
    }

    /**
     * @param endSessionEndpoint
     *            the endSessionEndpoint to set
     */
    public void setEndSessionEndpoint(URI endSessionEndpoint) {

        this.endSessionEndpoint = endSessionEndpoint;
    }

    /**
     * @return the idTokenEncryptionAlgValuesSupported
     */
    public List<String> getIdTokenEncryptionAlgValuesSupported() {

        return idTokenEncryptionAlgValuesSupported;
    }

    /**
     * @param idTokenEncryptionAlgValuesSupported
     *            the idTokenEncryptionAlgValuesSupported to set
     */
    public void setIdTokenEncryptionAlgValuesSupported(List<String> idTokenEncryptionAlgValuesSupported) {

        this.idTokenEncryptionAlgValuesSupported = idTokenEncryptionAlgValuesSupported;
    }

    /**
     * @return the idTokenEncryptionEncValuesSupported
     */
    public List<String> getIdTokenEncryptionEncValuesSupported() {

        return idTokenEncryptionEncValuesSupported;
    }

    /**
     * @param idTokenEncryptionEncValuesSupported
     *            the idTokenEncryptionEncValuesSupported to set
     */
    public void setIdTokenEncryptionEncValuesSupported(List<String> idTokenEncryptionEncValuesSupported) {

        this.idTokenEncryptionEncValuesSupported = idTokenEncryptionEncValuesSupported;
    }

    /**
     * @return the idTokenSigningAlgValuesSupported
     */
    public List<String> getIdTokenSigningAlgValuesSupported() {

        return idTokenSigningAlgValuesSupported;
    }

    /**
     * @param idTokenSigningAlgValuesSupported
     *            the idTokenSigningAlgValuesSupported to set
     */
    public void setIdTokenSigningAlgValuesSupported(List<String> idTokenSigningAlgValuesSupported) {

        this.idTokenSigningAlgValuesSupported = idTokenSigningAlgValuesSupported;
    }

    /**
     * @return the issuer
     */
    public String getIssuer() {

        return issuer;
    }

    /**
     * @param issuer
     *            the issuer to set
     */
    public void setIssuer(String issuer) {

        this.issuer = issuer;
    }

    /**
     * @return the jwksUri
     */
    public URI getJwksUri() {

        return jwksUri;
    }

    /**
     * @param jwksUri
     *            the jwksUri to set
     */
    public void setJwksUri(URI jwksUri) {

        this.jwksUri = jwksUri;
    }

    /**
     * @return the registrationEndpoint
     */
    public URI getRegistrationEndpoint() {

        return registrationEndpoint;
    }

    /**
     * @param registrationEndpoint
     *            the registrationEndpoint to set
     */
    public void setRegistrationEndpoint(URI registrationEndpoint) {

        this.registrationEndpoint = registrationEndpoint;
    }

    /**
     * @return the requestObjectEncryptionAlgValuesSupported
     */
    public List<String> getRequestObjectEncryptionAlgValuesSupported() {

        return requestObjectEncryptionAlgValuesSupported;
    }

    /**
     * @param requestObjectEncryptionAlgValuesSupported
     *            the requestObjectEncryptionAlgValuesSupported to set
     */
    public void setRequestObjectEncryptionAlgValuesSupported(List<String> requestObjectEncryptionAlgValuesSupported) {

        this.requestObjectEncryptionAlgValuesSupported = requestObjectEncryptionAlgValuesSupported;
    }

    /**
     * @return the requestObjectEncryptionEncValuesSupported
     */
    public List<String> getRequestObjectEncryptionEncValuesSupported() {

        return requestObjectEncryptionEncValuesSupported;
    }

    /**
     * @param requestObjectEncryptionEncValuesSupported
     *            the requestObjectEncryptionEncValuesSupported to set
     */
    public void setRequestObjectEncryptionEncValuesSupported(List<String> requestObjectEncryptionEncValuesSupported) {

        this.requestObjectEncryptionEncValuesSupported = requestObjectEncryptionEncValuesSupported;
    }

    /**
     * @return the requestObjectSigningAlgValuesSupported
     */
    public List<String> getRequestObjectSigningAlgValuesSupported() {

        return requestObjectSigningAlgValuesSupported;
    }

    /**
     * @param requestObjectSigningAlgValuesSupported
     *            the requestObjectSigningAlgValuesSupported to set
     */
    public void setRequestObjectSigningAlgValuesSupported(List<String> requestObjectSigningAlgValuesSupported) {

        this.requestObjectSigningAlgValuesSupported = requestObjectSigningAlgValuesSupported;
    }

    /**
     * @return the requestParameterSupported
     */
    public boolean isRequestParameterSupported() {

        return requestParameterSupported;
    }

    /**
     * @param requestParameterSupported
     *            the requestParameterSupported to set
     */
    public void setRequestParameterSupported(boolean requestParameterSupported) {

        this.requestParameterSupported = requestParameterSupported;
    }

    /**
     * @return the requestUriParameterSupported
     */
    public boolean isRequestUriParameterSupported() {

        return requestUriParameterSupported;
    }

    /**
     * @param requestUriParameterSupported
     *            the requestUriParameterSupported to set
     */
    public void setRequestUriParameterSupported(boolean requestUriParameterSupported) {

        this.requestUriParameterSupported = requestUriParameterSupported;
    }

    /**
     * @return the requireRequestUriRegistration
     */
    public boolean isRequireRequestUriRegistration() {

        return requireRequestUriRegistration;
    }

    /**
     * @param requireRequestUriRegistration
     *            the requireRequestUriRegistration to set
     */
    public void setRequireRequestUriRegistration(boolean requireRequestUriRegistration) {

        this.requireRequestUriRegistration = requireRequestUriRegistration;
    }

    /**
     * @return the responseTypesSupported
     */
    public List<String> getResponseTypesSupported() {

        return responseTypesSupported;
    }

    /**
     * @param responseTypesSupported
     *            the responseTypesSupported to set
     */
    public void setResponseTypesSupported(List<String> responseTypesSupported) {

        this.responseTypesSupported = responseTypesSupported;
    }

    /**
     * @return the revocationEndpoint
     */
    public URI getRevocationEndpoint() {

        return revocationEndpoint;
    }

    /**
     * @param revocationEndpoint
     *            the revocationEndpoint to set
     */
    public void setRevocationEndpoint(URI revocationEndpoint) {

        this.revocationEndpoint = revocationEndpoint;
    }

    /**
     * @return the serviceDocumentation
     */
    public URI getServiceDocumentation() {

        return serviceDocumentation;
    }

    /**
     * @param serviceDocumentation
     *            the serviceDocumentation to set
     */
    public void setServiceDocumentation(URI serviceDocumentation) {

        this.serviceDocumentation = serviceDocumentation;
    }

    /**
     * @return the tokenEndpoint
     */
    public URI getTokenEndpoint() {

        return tokenEndpoint;
    }

    /**
     * @param tokenEndpoint
     *            the tokenEndpoint to set
     */
    public void setTokenEndpoint(URI tokenEndpoint) {

        this.tokenEndpoint = tokenEndpoint;
    }

    /**
     * @return the tokenEndpointAuthSigningAlgValuesSupported
     */
    public Set<String> getTokenEndpointAuthSigningAlgValuesSupported() {

        return tokenEndpointAuthSigningAlgValuesSupported;
    }

    /**
     * @param tokenEndpointAuthSigningAlgValuesSupported
     *            the tokenEndpointAuthSigningAlgValuesSupported to set
     */
    public void setTokenEndpointAuthSigningAlgValuesSupported(Set<String> tokenEndpointAuthSigningAlgValuesSupported) {

        this.tokenEndpointAuthSigningAlgValuesSupported = tokenEndpointAuthSigningAlgValuesSupported;
    }

    /**
     * @return the uiLocalesSupported
     */
    public Set<Locale> getUiLocalesSupported() {

        return uiLocalesSupported;
    }

    /**
     * @param uiLocalesSupported
     *            the uiLocalesSupported to set
     */
    public void setUiLocalesSupported(Set<Locale> uiLocalesSupported) {

        this.uiLocalesSupported = uiLocalesSupported;
    }

    /**
     * @return the userinfoEncryptionAlgValuesSupported
     */
    public Set<String> getUserinfoEncryptionAlgValuesSupported() {

        return userinfoEncryptionAlgValuesSupported;
    }

    /**
     * @param userinfoEncryptionAlgValuesSupported
     *            the userinfoEncryptionAlgValuesSupported to set
     */
    public void setUserinfoEncryptionAlgValuesSupported(Set<String> userinfoEncryptionAlgValuesSupported) {

        this.userinfoEncryptionAlgValuesSupported = userinfoEncryptionAlgValuesSupported;
    }

    /**
     * @return the userinfoEncryptionEncValuesSupported
     */
    public Set<String> getUserinfoEncryptionEncValuesSupported() {

        return userinfoEncryptionEncValuesSupported;
    }

    /**
     * @param userinfoEncryptionEncValuesSupported
     *            the userinfoEncryptionEncValuesSupported to set
     */
    public void setUserinfoEncryptionEncValuesSupported(Set<String> userinfoEncryptionEncValuesSupported) {

        this.userinfoEncryptionEncValuesSupported = userinfoEncryptionEncValuesSupported;
    }

    /**
     * @return the userinfoEndpoint
     */
    public URI getUserinfoEndpoint() {

        return userinfoEndpoint;
    }

    /**
     * @param userinfoEndpoint
     *            the userinfoEndpoint to set
     */
    public void setUserinfoEndpoint(URI userinfoEndpoint) {

        this.userinfoEndpoint = userinfoEndpoint;
    }

    /**
     * @return the userinfoSigningAlgValuesSupported
     */
    public Set<String> getUserinfoSigningAlgValuesSupported() {

        return userinfoSigningAlgValuesSupported;
    }

    /**
     * @param userinfoSigningAlgValuesSupported
     *            the userinfoSigningAlgValuesSupported to set
     */
    public void setUserinfoSigningAlgValuesSupported(Set<String> userinfoSigningAlgValuesSupported) {

        this.userinfoSigningAlgValuesSupported = userinfoSigningAlgValuesSupported;
    }

    /**
     * @param acrValuesSupported
     *            the acrValuesSupported to set
     */
    public void setAcrValuesSupported(Set<String> acrValuesSupported) {

        this.acrValuesSupported = acrValuesSupported;
    }

    /**
     * @param authorizationEndpoint
     *            the authorizationEndpoint to set
     */
    public void setAuthorizationEndpoint(URI authorizationEndpoint) {

        this.authorizationEndpoint = authorizationEndpoint;
    }

    /**
     * @param checkSessionIframe
     *            the checkSessionIframe to set
     */
    public void setCheckSessionIframe(URI checkSessionIframe) {

        this.checkSessionIframe = checkSessionIframe;
    }

    /**
     * @param claimsSupported
     *            the claimsSupported to set
     */
    public void setClaimsSupported(Set<String> claimsSupported) {

        this.claimsSupported = claimsSupported;
    }

    /**
     * @param claimTypesSupported
     *            the claimTypesSupported to set
     */
    public void setClaimTypesSupported(Set<String> claimTypesSupported) {

        this.claimTypesSupported = claimTypesSupported;
    }
}
